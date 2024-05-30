package ru.ainur.vkbot.pojo.vk.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MethodCallRequest implements VkApiRequest {
    private String accessToken;

    private int randomId;

    private int userId;

    private String message;

    private String groupId;
}
