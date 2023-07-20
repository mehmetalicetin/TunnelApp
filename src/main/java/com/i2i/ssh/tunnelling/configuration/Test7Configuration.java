package com.i2i.ssh.tunnelling.configuration;

import com.i2i.ssh.tunnelling.configproperties.Test7ConfigurationProperties;
import com.i2i.ssh.tunnelling.portforwarding.Test7PortForward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test7Configuration extends TunnelConfiguration{

    @Autowired
    Test7ConfigurationProperties test7ConfigurationProperties;

    @Autowired
    Test7PortForward test7PortForward;

    @Override
    public void setConfigurations(){
        tunnelConfigurationProperties = test7ConfigurationProperties;
        portForward = test7PortForward;
    }
}
