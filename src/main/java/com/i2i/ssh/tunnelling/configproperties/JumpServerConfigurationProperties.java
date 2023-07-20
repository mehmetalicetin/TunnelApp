package com.i2i.ssh.tunnelling.configproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties
@Configuration
public class JumpServerConfigurationProperties {
    @Value("${jumpServerHost}")
    public String jumpServerHost;

    @Value("${jumpServerUserName}")
    public String jumpServerUserName;

    @Value("${jumpServerUserPass}")
    public String jumpServerUserPass;

}
