package com.i2i.ssh.tunnelling.configproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties
@Configuration
public class Test7ConfigurationProperties implements TunnelConfigurationProperties{
    @Value("${test7.database.host}")
    public String databaseHost;
    @Value("${test7.server.host}")
    public String serverHost;

    @Value("${test7.port.database}")
    public String portDatabase;

    @Value("${test7.port.server}")
    public String portServer;

    public String databaseHost() {
        return this.databaseHost;
    }

    @Override
    public String serverHost() {
        return this.serverHost;
    }

    @Override
    public String portDatabase() {
        return this.portDatabase;
    }

    @Override
    public String portServer() {
        return this.portServer;
    }
}
