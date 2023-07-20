package com.i2i.ssh.tunnelling.portforwarding;

import com.i2i.ssh.tunnelling.configproperties.TunnelConfigurationProperties;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Test7PortForward implements PortForward{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void forwardPort(Session session, TunnelConfigurationProperties configurationProperties) throws JSchException {
        sessionPortForward(session, configurationProperties);
        logger.info("Test7 Port Forwarding process completed successfully.");
    }
}
