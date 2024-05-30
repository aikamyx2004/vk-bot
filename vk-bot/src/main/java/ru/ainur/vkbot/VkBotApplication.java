package ru.ainur.vkbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.ainur.vkbot.config.VkApiConfiguration;

@EnableConfigurationProperties(VkApiConfiguration.class)
@SpringBootApplication
public class VkBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(VkBotApplication.class, args);
    }

}
