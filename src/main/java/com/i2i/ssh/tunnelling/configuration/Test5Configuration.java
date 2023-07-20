package com.i2i.ssh.tunnelling.configuration;

import com.i2i.ssh.tunnelling.configproperties.Test5ConfigurationProperties;
import com.i2i.ssh.tunnelling.portforwarding.Test5PortForward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test5Configuration extends TunnelConfiguration{
    @Autowired
    Test5ConfigurationProperties test5ConfigurationProperties;

    @Autowired
    Test5PortForward test5PortForward;

    @Override
    public void setConfigurations(){
        tunnelConfigurationProperties = test5ConfigurationProperties;
        portForward = test5PortForward;
    }
}
