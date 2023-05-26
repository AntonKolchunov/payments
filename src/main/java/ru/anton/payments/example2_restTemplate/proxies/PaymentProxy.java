package ru.anton.payments.example2_restTemplate.proxies;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import ru.anton.payments.example2_restTemplate.models.Payment;

import java.util.UUID;

@Component
public class PaymentProxy {
    @Value("${name.service.url}")
    private String paymentServiceUrl;
    private final RestTemplate restTemplate;


    public PaymentProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment createPayment(
            @RequestBody Payment payment) {
        String uri = paymentServiceUrl+"/payment";

        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);

        ResponseEntity<Payment> responseEntity =
                restTemplate.exchange(
                        uri,
                        HttpMethod.POST,
                        httpEntity,
                        Payment.class);

        return responseEntity.getBody();
    }
}
