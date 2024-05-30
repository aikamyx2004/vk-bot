package ru.ainur.vkbot.handler;

import org.springframework.stereotype.Component;
import ru.ainur.vkbot.pojo.request.VkEvent;

/**
 * after sending message, in server generates new event message_reply,
 * so I have to ignore it, to not cause exceptions in request handling service
 */
@Component
public class MessageReplyHandler implements VkEventHandler {
    @Override
    public boolean canHandle(VkEvent event) {
        return "message_reply".equals(event.getType());
    }

    @Override
    public String handle(VkEvent event) {
        return "ok";
    }
}
