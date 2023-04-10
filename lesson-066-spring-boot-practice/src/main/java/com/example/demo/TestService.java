package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public TestDto get() {
        return TestDto.builder()
                .id("123")
                .name("John")
                .build();
    }
}
