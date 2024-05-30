package ru.ainur.vkbot.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.ainur.vkbot.exception.InvalidEventException;
import ru.ainur.vkbot.pojo.request.VkEvent;
import ru.ainur.vkbot.pojo.request.message.Message;
import ru.ainur.vkbot.service.VkApiConnector;
import ru.ainur.vkbot.util.VkApiRequestBuilder;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageHandler implements VkEventHandler {
    private final VkApiRequestBuilder requestBuilder;
    private final VkApiConnector apiConnector;

    @Override
    public boolean canHandle(VkEvent event) {
        return "message_new".equals(event.getType());
    }

    @Override
    public String handle(VkEvent event) {
        validateEvent(event);
        Message message = event.getObject().getMessage();
        message.setText("Вы сказали: " + message.getText());

        var request = requestBuilder.eventToMethodCallRequestUrl(event);

        apiConnector.callMethodByUrl(request);

        log.info("Message successfully sent");
        return "ok";
    }


    private void validateEvent(VkEvent event) {
        if (event.getObject() == null || event.getObject().getMessage() == null ||
                event.getObject().getMessage().getText() == null) {
            throw new InvalidEventException(
                    "Event does not contain message event: %n%s".formatted(event.toString())
            );
        }
    }

}
