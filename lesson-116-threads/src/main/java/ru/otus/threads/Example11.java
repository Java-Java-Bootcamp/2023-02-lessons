package ru.otus.threads;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

@Slf4j
public class Example11 extends Thread {
	private static final ThreadLocal<Integer> a = new ThreadLocal<>();

	@Override
	public void run() {
		a.set(0);
		for (int i = 0; i < 10000; ++i)
			a.set(a.get() + 1);

		log.info("complete, a = {}", a.get());
	}

	@SneakyThrows
	public static void main(String[] args) {
		var threads = List.of(new Example11(), new Example11());

		a.set(42);

		for (var t : threads)
			t.start();

		for (var t : threads)
			t.join();

		log.info("complete, a = {}", a.get());
	}
}
