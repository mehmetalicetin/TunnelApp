package com.i2i.ssh.tunnelling;

import com.i2i.ssh.tunnelling.configuration.MSAccConfiguration;
import com.i2i.ssh.tunnelling.configuration.MSIntConfiguration;
import com.i2i.ssh.tunnelling.configuration.Test5Configuration;
import com.i2i.ssh.tunnelling.configuration.Test7Configuration;
import com.jcraft.jsch.JSchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Launch implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MSIntConfiguration msIntConfiguration;

    @Autowired
    MSAccConfiguration msAccConfiguration;

    @Autowired
    Test7Configuration test7Configuration;

    @Autowired
    Test5Configuration test5Configuration;

    public static void main(String[] args) {
        SpringApplication.run(Launch.class, args);
    }

    @Override
    public void run(String... args) throws JSchException {
        try {
            //msAccConfiguration.portForward();
            msIntConfiguration.portForward();
           // test7Configuration.portForward();
           // test5Configuration.portForward();
        } catch (Exception exception){
            logger.error("Try to connect Vpn, UnknownHostException Exception -> {}",exception.getMessage());
            msAccConfiguration.portForward();
        }
    }
}
