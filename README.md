# Rate Limiter API

A production-ready REST API rate limiter built with Java and Spring Boot.

## Badges

[![Java Version](https://img.shields.io/badge/Java-11-blue.svg)](https://www.java.com/en/)
[![Spring Boot Version](https://img.shields.io/badge/Spring%20Boot-2.7.3-green.svg)](https://spring.io/projects/spring-boot)

## Installation

To install the Rate Limiter API, follow these steps:

1. Clone the repository using Git: `git clone https://github.com/your-username/RateLimiterAPI.git`
2. Navigate to the project directory: `cd RateLimiterAPI`
3. Build the project using Gradle: `./gradlew build`
4. Start the application: `./gradlew bootRun`

## Usage

The Rate Limiter API provides the following endpoints:

* `GET /api/limiter`: Returns the current rate limit status
* `POST /api/limiter`: Updates the rate limit configuration
* `GET /api/metrics`: Returns the current metrics

Example usage using `curl`: