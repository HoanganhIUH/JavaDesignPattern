package iuh.fit.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "serviceB", url = "http://localhost:8081")
public interface HelloClient {
    @GetMapping("/hello")
    String getHello();
}
