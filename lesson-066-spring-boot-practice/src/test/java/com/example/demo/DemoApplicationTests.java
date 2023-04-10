package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private TestService testService;

	@Test
	void contextLoads() {
		TestDto testDto = testService.get();

		TestDto expected = TestDto.builder()
				.id("123")
				.name("John")
				.build();
		Assertions.assertEquals(expected, testDto);
	}

}
