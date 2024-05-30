package ru.ainur.vkbot.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@Getter
@ConfigurationProperties(prefix = "vk.api.config")
public class VkApiConfiguration {
    private final String secret;

    private final String groupId;

    private final String apiVersion;

    private final String confirmationCode;

    private final String accessKey;
    private final URI methodUrl;

    public VkApiConfiguration(String secret, String groupId, String apiVersion, String confirmationCode, String accessKey, String methodUrl) {
        this.secret = secret;
        this.groupId = groupId;
        this.apiVersion = apiVersion;
        this.confirmationCode = confirmationCode;
        this.accessKey = accessKey;
        this.methodUrl = URI.create(methodUrl);
    }
}