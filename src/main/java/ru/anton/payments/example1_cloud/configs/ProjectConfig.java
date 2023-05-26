package ru.anton.payments.example1_cloud.configs;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "ru.anton.payments.example1_cloud.proxies")
//Файл конфигурации нужен чтобы включить клиента Feign
public class ProjectConfig {
}
