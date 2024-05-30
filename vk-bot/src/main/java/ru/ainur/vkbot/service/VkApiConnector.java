package ru.ainur.vkbot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import ru.ainur.vkbot.pojo.vk.api.VkApiResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class VkApiConnector {
    private final RestTemplate restTemplate = new RestTemplate();


    public void callMethodByUrl(UriComponents uri) {
        log.info("To vk send request:  {}", uri);
        VkApiResponse response = restTemplate.getForObject(uri.toUri(), VkApiResponse.class);
        log.info("Response from vk: {}", response);
        if (response == null || response.getError() != null) {
            log.error("Could not send request to vk api uri: {}%n response: {}", uri, response);
        }
    }
}
