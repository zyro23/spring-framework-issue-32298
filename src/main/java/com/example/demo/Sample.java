package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class Sample {

    private final TaskScheduler taskScheduler;

    public Sample(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    @PostConstruct
    public void init() {
        taskScheduler.schedule(() -> {
            throw new IllegalStateException("o.O");
        }, Instant.now());
    }
}
