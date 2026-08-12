package com.example.ratelimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
// leaving a note for later
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimiterController {
    private final RateLimiterService service;
// small cleanup

    @Autowired
    public RateLimiterController(RateLimiterService service) {
        this.service = service;
    }

    @GetMapping("/api/limiter")
    public ResponseEntity<RateLimiter> getRateLimiter() {
        RateLimiter rateLimiter = service.getRateLimiter("default");
        return ResponseEntity.ok(rateLimiter);
    }

    @PostMapping("/api/limiter")
    public ResponseEntity<String> updateRateLimiter(@RequestBody RateLimiter rateLimiter) {
        service.updateRateLimiter(rateLimiter);
        return ResponseEntity.ok("Rate limiter updated successfully");
    }
}