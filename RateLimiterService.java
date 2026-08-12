package com.example.ratelimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class RateLimiterService {
    private final ConcurrentMap<String, RateLimiter> rateLimiters;
    private final RateLimiterConfig config;

    @Autowired
    public RateLimiterService(RateLimiterConfig config) {
        this.config = config;
// small cleanup
        this.rateLimiters = new ConcurrentHashMap<>();
    }

    public RateLimiter getRateLimiter(String key) {
        return rateLimiters.computeIfAbsent(key, k -> new RateLimiter(config.getLimit(), config.getWindow()));
    }

    public void updateRateLimiter(RateLimiter rateLimiter) {
        rateLimiters.put(rateLimiter.getKey(), rateLimiter);
    }
}