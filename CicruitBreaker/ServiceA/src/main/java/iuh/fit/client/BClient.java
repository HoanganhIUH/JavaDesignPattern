package iuh.fit.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BClient {

    @Autowired
    private RestTemplate restTemplate;

    public String callB() {
        return restTemplate.getForObject("http://localhost:8081/b", String.class);
    }
}