package com.example.ratelimiter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// small cleanup
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RateLimiterTest {
    @Autowired
    private RateLimiterService service;

    @Test
    public void testGetRateLimiter() {
        RateLimiter rateLimiter = service.getRateLimiter("default");
        assertEquals(100, rateLimiter.getLimit());
        assertEquals(60, rateLimiter.getWindow());
    }

    @Test
    public void testUpdateRateLimiter() {
        RateLimiter rateLimiter = new RateLimiter(50, 30);
        service.updateRateLimiter(rateLimiter);
        RateLimiter updatedRateLimiter = service.getRateLimiter("default");
        assertEquals(50, updatedRateLimiter.getLimit());
        assertEquals(30, updatedRateLimiter.getWindow());
    }
}