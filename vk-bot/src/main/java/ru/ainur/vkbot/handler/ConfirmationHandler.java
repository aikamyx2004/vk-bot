package ru.ainur.vkbot.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ainur.vkbot.config.VkApiConfiguration;
import ru.ainur.vkbot.pojo.request.VkEvent;

@Component
@RequiredArgsConstructor
public class ConfirmationHandler implements VkEventHandler {
    private final VkApiConfiguration configuration;

    @Override
    public boolean canHandle(VkEvent event) {
        return "confirmation".equals(event.getType());
    }

    @Override
    public String handle(VkEvent event) {
        return configuration.getConfirmationCode();
    }

}
