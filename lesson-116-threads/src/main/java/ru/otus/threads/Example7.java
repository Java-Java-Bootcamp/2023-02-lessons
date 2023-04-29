package ru.otus.threads;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Example7 extends Thread {
	static final AtomicInteger a = new AtomicInteger();

	@Override
	public void run() {
		for (int i = 0; i < 100000; ++i) {
			a.incrementAndGet();
		}
	}

	@SneakyThrows
	public static void main(String[] args) {
		var threads = List.of(new Example7(), new Example7());

		for (var t : threads)
			t.start();

		for (var t : threads)
			t.join();

		log.info("a={}", a);
	}
}
