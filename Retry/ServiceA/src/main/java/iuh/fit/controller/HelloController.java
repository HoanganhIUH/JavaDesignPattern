package iuh.fit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.retry.annotation.Retry;
import iuh.fit.client.HelloClient;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloClient client;

    @Retry(name = "retryB", fallbackMethod = "fallback")
    @GetMapping("/callB")
    public String callB() {
        return client.getHello();
    }

    public String fallback(Exception e) {
        return "Fallback from A: Service B is down!";
    }
}
