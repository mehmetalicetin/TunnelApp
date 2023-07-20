package com.i2i.ssh.tunnelling.configuration;

import com.i2i.ssh.tunnelling.configproperties.MsIntConfigurationProperties;
import com.i2i.ssh.tunnelling.portforwarding.MsINTPortForward;
import com.jcraft.jsch.JSchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MSIntConfiguration extends TunnelConfiguration {

    @Autowired
    MsIntConfigurationProperties msIntConfigurationProperties;

    @Autowired
    MsINTPortForward msINTPortForward;

    @Override
    public void setConfigurations(){
        tunnelConfigurationProperties = msIntConfigurationProperties;
        portForward = msINTPortForward;
    }
}
