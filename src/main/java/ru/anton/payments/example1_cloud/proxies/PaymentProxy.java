package ru.anton.payments.example1_cloud.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.anton.payments.example1_cloud.models.Payment;

@FeignClient(name="payments", url = "${name.service.url}")
//С помощью этой аннотации Spring автоматически сконфигурирует класс, который реализует этот интерфейс
// при внедрении зависимости в PaymentController-e
public interface PaymentProxy {

    @PostMapping("/payment")
    Payment createPayment(@RequestHeader String requestId,
                          @RequestBody Payment payment);
}
