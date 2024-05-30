package ru.ainur.vkbot.pojo.request.message;

import lombok.Data;

@Data
public class Message {
    private int id;
    private int fromId;
    private String text;
    private String v;
}
