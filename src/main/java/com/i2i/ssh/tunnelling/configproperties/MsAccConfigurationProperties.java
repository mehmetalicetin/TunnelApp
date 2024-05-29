package com.i2i.ssh.tunnelling.configproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties
@Configuration
public class MsAccConfigurationProperties implements TunnelConfigurationProperties {
    @Value("${msacc.database.host}")
    public String databaseHost;
    @Value("${msacc.server.host}")
    public String serverHost;

    @Value("${msacc.port.database}")
    public String portDatabase;

    @Value("${msacc.port.server}")
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
