package com.example.ratelimiter;

import java.time.Instant;

public class RateLimiter {
    private final String key;
    private final int limit;
    private final int window;
    private long lastReset;
    private int remaining;

    public RateLimiter(int limit, int window) {
        this.limit = limit;
        this.window = window;
        this.lastReset = Instant.now().getEpochSecond();
        this.remaining = limit;
    }

    public String getKey() {
        return key;
    }

    public int getLimit() {
        return limit;
    }

    public int getWindow() {
        return window;
    }

    public int getRemaining() {
        return remaining;
    }

    public void updateRemaining() {
        long now = Instant.now().getEpochSecond();
        if (now - lastReset >= window) {
            lastReset = now;
            remaining = limit;
        }
        remaining--;
    }
}