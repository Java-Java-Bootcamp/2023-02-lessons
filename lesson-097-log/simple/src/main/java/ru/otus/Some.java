package ru.otus;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Some {
	//private static final Logger log = LoggerFactory.getLogger(Some.class);
	public static void f(String a) {
		log.info("Hello from {}", a);
	}
}
