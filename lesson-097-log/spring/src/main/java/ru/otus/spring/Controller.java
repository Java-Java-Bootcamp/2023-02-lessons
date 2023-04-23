package ru.otus.spring;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Controller {
	private final MyService myService;

	@PostMapping
	public void doSomething(String user, String action) {
		// log.warn("user {}", user);
		// myService.doSomething(action, user);
		//MDC.put("user", user);
		myService.doSomething(action);
	}
}
