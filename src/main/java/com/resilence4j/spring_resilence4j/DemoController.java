package com.resilence4j.spring_resilence4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final ExternalApiService service;

    public DemoController(ExternalApiService service) {
        this.service = service;
    }

    @GetMapping("/test-cb")
    public String testCircuitBreaker() {
        return service.callApi();
    }
}

