package ru.otus.threads;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Thread1 extends Thread {
	@Override
	@SneakyThrows
	public void run() {
		log.info("Hello from thread1");

		//Thread.sleep(1000);
		log.info("after sleep");
	}
}

@Slf4j
public class Example1 {
	@SneakyThrows
	public static void main(String[] args) {
		var thread1 = new Thread1();
		var thread2 = new Thread(() -> {
			log.info("Hello from thread2");
		});

		log.info("Hello from main thread");

		thread1.start();
		thread1.interrupt();
		thread2.start();


		log.info("main complete");
	}
}
