package ru.ainur.vkbot.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ConfirmationResponse implements BotResponse {
    private String confirmation;
}
