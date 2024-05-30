package ru.ainur.vkbot.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.ainur.vkbot.config.VkApiConfiguration;
import ru.ainur.vkbot.pojo.request.VkEvent;
import ru.ainur.vkbot.pojo.request.message.Message;

import java.security.SecureRandom;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class VkApiRequestBuilder {
    private final VkApiConfiguration configuration;
    private final Random random = new SecureRandom();

    public UriComponents eventToMethodCallRequestUrl(VkEvent event) {
        Message message = event.getObject().getMessage();

        return getCommonUriComponentsBuilder()
                .queryParam("user_id", message.getFromId())
                .queryParam("message", message.getText())
                .build();
    }

    private UriComponentsBuilder getCommonUriComponentsBuilder() {
        return UriComponentsBuilder.fromUri(configuration.getMethodUrl().resolve("messages.send"))
                .queryParam("random_id", random.nextInt())
                .queryParam("access_token", configuration.getAccessKey())
                .queryParam("v", configuration.getApiVersion());
    }
}
