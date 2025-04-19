package iuh.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import iuh.fit.client.BClient;

@RestController
public class AController {

    @Autowired
    private BClient bClient;

    @GetMapping("/callB")
    @CircuitBreaker(name = "bServiceCB", fallbackMethod = "fallbackB")
    public String callB() {
        return bClient.callB();
    }

    public String fallbackB(Throwable t) {
        return "Service B is unavailable (Fallback)";
    }
}
