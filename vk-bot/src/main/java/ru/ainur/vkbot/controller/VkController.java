package ru.ainur.vkbot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ainur.vkbot.pojo.request.VkEvent;
import ru.ainur.vkbot.service.VkEventHandlingService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/callback")
@Slf4j
public class VkController {
    private final VkEventHandlingService vkEventHandlingService;

    @PostMapping
    public String handleConfirmation(@RequestBody VkEvent event) {
        log.info("New event: {}", event);
        return vkEventHandlingService.handle(event);
    }
}