package ru.otus.threads;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class Example4 {
	@SneakyThrows
	public static void main(String[] args) {
		var thread = new Thread(() -> {
			try {
				log.info("before sleep");
				Thread.sleep(2000);
				log.info("after sleep");
			} catch (Exception e) {

			}
			log.info("complete");
		});

		thread.start();
		thread.join();
		log.info("main complete");
	}
}
