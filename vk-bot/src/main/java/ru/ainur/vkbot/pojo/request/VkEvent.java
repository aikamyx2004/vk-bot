package ru.ainur.vkbot.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VkEvent {
    private String type;
    private int groupId;
    private String eventId;
    private String v;
    private String secret;
    private VkObject object;
}
