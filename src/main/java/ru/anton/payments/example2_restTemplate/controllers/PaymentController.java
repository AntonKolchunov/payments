package ru.anton.payments.example2_restTemplate.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.anton.payments.example2_restTemplate.models.Payment;
import ru.anton.payments.example2_restTemplate.proxies.PaymentProxy;

@RestController
public class PaymentController {

    private final PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
        return paymentProxy.createPayment(payment);
    }
}
