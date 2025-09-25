# Spring Boot - Resilence4j

## What is Circuit Breaker Pattern in Microservices ?

The Circuit Breaker pattern is a design pattern used in microservices to enhance system resilience and fault tolerance. It acts like an electrical circuit breaker by preventing an application from repeatedly trying to execute an operation that is likely to fail, which can lead to cascading failures across the system.

## Characteristics

- Circuit Breaker enhances fault tolerance by isolating and managing failures in individual services.
- It continuously monitors interactions between services to detect issues in real time.
- Also useful in temporarily stops requests to failing services, preventing cascading failures and minimizing disruptions.
- It Provides fallback responses or error messages to clients during service failures, ensuring graceful degradation.
- It Automatically transitions back to normal operation when the failing service recovers, improving system reliability

## Working and Different States in Circuit Breaker Pattern

The Circuit Breaker pattern typically operates in three main states: Closed, Open, and Half-Open. Each state represents a different phase in the management of interactions between services. Here's an explanation of each state:

### Closed State

In the Closed state, the circuit breaker operates normally, allowing requests to flow through between services.
During this phase, the circuit breaker monitors the health of the downstream service by collecting and analyzing metrics such as response times, error rates, or timeouts..

### Open State

When the monitored metrics breach predetermined thresholds, signaling potential issues with the downstream service, the circuit breaker transitions to the Open state.
In the Open state, the circuit breaker immediately stops forwarding requests to the failing service, effectively isolating it.
This helps prevent cascading failures and maintains system stability by ensuring that clients receive timely feedback, even when services encounter issues.

### Half-Open State

After a specified timeout period in the Open state, transitions to Half-Open state.
Allows a limited number of trial requests to pass through to the downstream service.
Monitors responses to determine service recovery.
If trial requests succeed, indicating service recovery, transitions back to Closed state.
If trial requests fail, service issues persist.
May transition back to Open state or remain in Half-Open state for further evaluation.

### Reference Documentation
For further reference, please consider the following sections:

* [Resilience4j getting-started](https://resilience4j.readme.io/docs/getting-started)

