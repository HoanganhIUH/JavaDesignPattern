package iuh.fit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BController {

    @GetMapping("/b")
    public String getB() {
        return "Hello from B";
    }
}
