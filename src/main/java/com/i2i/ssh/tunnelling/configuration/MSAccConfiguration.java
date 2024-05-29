package com.i2i.ssh.tunnelling.configuration;

import com.i2i.ssh.tunnelling.configproperties.MsAccConfigurationProperties;
import com.i2i.ssh.tunnelling.portforwarding.MsACCPortForward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MSAccConfiguration extends TunnelConfiguration {

    @Autowired
    MsAccConfigurationProperties msAccConfigurationProperties;

    @Autowired
    MsACCPortForward msACCPortForward;

    @Override
    public void setConfigurations(){
        tunnelConfigurationProperties = msAccConfigurationProperties;
        portForward = msACCPortForward;
    }
}
