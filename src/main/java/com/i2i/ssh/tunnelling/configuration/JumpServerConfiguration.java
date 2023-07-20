package com.i2i.ssh.tunnelling.configuration;

import com.i2i.ssh.tunnelling.configproperties.JumpServerConfigurationProperties;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JumpServerConfiguration{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final short PORT = 22;
    private final short CONNECTION_TIMEOUT = 10000;

    @Autowired
    private JumpServerConfigurationProperties jumpServerConfigurationProperties;

    public Session startTunnelIfNotConnected() throws JSchException {
        Session session = null;
        if (this.isConnected(session)) {
            return session;
        }
        try {
            return this.startTunnel();
        } catch (JSchException e) {
            logger.error("Exception occurred while trying to start tunnel connection.", e);
            closeTunnel(session);
            throw e;
        }
    }
    public Session startTunnel() throws JSchException {
        Session session = null;
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
        config.put("PreferredAuthentications", "password");

        JSch jsch = new JSch();
        if (!this.isConnected(session)) {
            session = jsch.getSession(jumpServerConfigurationProperties.jumpServerUserName, jumpServerConfigurationProperties.jumpServerHost, PORT);
            session.setPassword(jumpServerConfigurationProperties.jumpServerUserPass);
            session.setConfig(config);
            session.connect(CONNECTION_TIMEOUT);
        }
        logger.info("Tunnelling completed.");
        return session;
    }


    public void closeTunnel(Session session) {
        if (session != null) {
            logger.info("Trying to close tunnel.");
            session.disconnect();
            logger.info("Tunnelling is closed");
        }
    }

    public boolean isConnected(Session session) {
        return session != null && session.isConnected();
    }

}
