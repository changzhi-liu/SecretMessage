package com.SecureMessage.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class ServerPortConfig {
    public List<String> getServerPorts() {
        return serversports;
    }

    public void setServerPorts(List<String> serverPorts) {
        this.serversports = serverPorts;
    }

    private List<String> serversports;
}
