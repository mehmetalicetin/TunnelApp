package com.i2i.ssh.tunnelling.configproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties
@Configuration
public class MsIntConfigurationProperties implements TunnelConfigurationProperties {
    @Value("${msint.database.host}")
    public String databaseHost;
    @Value("${msint.server.host}")
    public String serverHost;

    @Value("${msint.port.database}")
    public String portDatabase;

    @Value("${msint.port.server}")
    public String portServer;

    @Override
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
