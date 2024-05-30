package ru.ainur.vkbot.pojo.request;

import lombok.Data;
import ru.ainur.vkbot.pojo.request.message.ClientInfo;
import ru.ainur.vkbot.pojo.request.message.Message;

@Data
public class VkObject {
    private Message message;
    private ClientInfo clientInfo;
}
