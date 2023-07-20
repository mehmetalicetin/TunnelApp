package com.i2i.ssh.tunnelling.configuration;

import com.i2i.ssh.tunnelling.configproperties.TunnelConfigurationProperties;
import com.i2i.ssh.tunnelling.portforwarding.PortForward;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class TunnelConfiguration {
    Session session;
    PortForward portForward;
    TunnelConfigurationProperties tunnelConfigurationProperties;

    @Autowired
    JumpServerConfiguration jumpServerConfiguration;

    public void makeTunnel() throws JSchException {
        session = jumpServerConfiguration.startTunnelIfNotConnected();
    }

    public void portForward() throws JSchException {
        makeTunnel();
        setConfigurations();
        connect();
    }

    public abstract void setConfigurations();

    public void connect() throws JSchException {
        portForward.forwardPort(session, tunnelConfigurationProperties);
    }
}
