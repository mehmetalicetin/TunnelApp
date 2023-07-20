package com.i2i.ssh.tunnelling.portforwarding;

import com.i2i.ssh.tunnelling.configproperties.TunnelConfigurationProperties;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public interface PortForward {
    short DB_PORT = 5432;
    short SERVER_HOST_PORT = 22;
    void forwardPort(Session session, TunnelConfigurationProperties configurationProperties) throws JSchException;

    default void sessionPortForward(Session session, TunnelConfigurationProperties configurationProperties) throws JSchException {
        session.setPortForwardingL(Integer.parseInt(configurationProperties.portDatabase()),
                configurationProperties.databaseHost(), DB_PORT);
        session.setPortForwardingL(Integer.parseInt(configurationProperties.portServer()),
                configurationProperties.serverHost(), SERVER_HOST_PORT);
    }
}
