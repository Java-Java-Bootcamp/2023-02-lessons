package ru.otus.threads126;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Thread1 extends Thread {
	@Override
	public void run() {
		log.info("Hello from thread1");
	}
}

@Slf4j
public class Example1 {
	public static void main(String[] args) {
		var thread1 = new Thread1();
		var thread2 = new Thread(() -> {
			log.info("Hello from thread2");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			log.info("sleep");
		});

		log.info("Hello from main thread");

		// запустите потоки thread1 / thread2

		log.info("main complete");
	}
}
