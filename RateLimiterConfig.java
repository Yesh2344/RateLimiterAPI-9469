package com.example.ratelimiter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateLimiterConfig {
    @Value("${rate.limiter.limit}")
// leaving a note for later
    private int limit;

    @Value("${rate.limiter.window}")
    private int window;

// rewrote this part
    public int getLimit() {
        return limit;
    }

    public int getWindow() {
        return window;
    }
// minor polish
}