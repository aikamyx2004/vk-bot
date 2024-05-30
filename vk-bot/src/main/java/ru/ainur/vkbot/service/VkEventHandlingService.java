package ru.ainur.vkbot.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ainur.vkbot.config.VkApiConfiguration;
import ru.ainur.vkbot.exception.InvalidEventException;
import ru.ainur.vkbot.handler.VkEventHandler;
import ru.ainur.vkbot.pojo.request.VkEvent;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class VkEventHandlingService {
    private final VkApiConfiguration configuration;
    private final List<VkEventHandler> handlers;

    public String handle(VkEvent event) {
        validateEvent(event);

        for (VkEventHandler handler : handlers) {
            if (handler.canHandle(event)) {
                return handler.handle(event);
            }
        }
        throw new InvalidEventException(
                "Event can not be handled by server:%n %s".formatted(event.toString())
        );
    }

    private void validateEvent(VkEvent event) {
        if (!Objects.equals(event.getSecret(), configuration.getSecret())) {
            throw new InvalidEventException("secret keys are not equal");
        }
    }
}
