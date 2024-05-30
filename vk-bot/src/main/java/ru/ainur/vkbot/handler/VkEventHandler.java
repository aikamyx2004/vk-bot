package ru.ainur.vkbot.handler;

import ru.ainur.vkbot.pojo.request.VkEvent;

public interface VkEventHandler {
    boolean canHandle(VkEvent event);

    String handle(VkEvent event);
}
