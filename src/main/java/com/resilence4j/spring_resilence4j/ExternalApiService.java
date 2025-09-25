package com.resilence4j.spring_resilence4j;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExternalApiService {

    @CircuitBreaker(name = "externalServiceCB", fallbackMethod = "fallbackResponse")
    public String callApi() {
        // Simulate failure 50% of the time
        double randomNumber = Math.random();
        log.info("Random number: {}", randomNumber);
        if (randomNumber > 0.5) {
            throw new RuntimeException("External API is down!");
        }
        return "✅ Success from external API";
    }

    // fallback must have same signature (plus Throwable optional)
    public String fallbackResponse(Throwable t) {
        return "⚠️ Fallback: External service unavailable";
    }
}
