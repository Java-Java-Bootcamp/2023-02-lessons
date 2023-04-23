package ru.otus.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyService {

	public void doSomething(String action) {
		log.warn("Some action: {}", action);
	}
}
