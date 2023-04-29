package ru.otus.threads126;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Example6 extends Thread {
	static int a = 0;
	static Object sync = new Object();

	@Override
	public void run() {
		var obj = new Object();
		for (int i = 0; i < 100_000; ++i) {
			synchronized (obj) {
				a += 1;
			}
		}
	}

	@SneakyThrows
	public static void main(String[] args) {
		var threads = List.of(new Example6(), new Example6());

		for (var t : threads)
			t.start();

		for (var t : threads)
			t.join();

		log.info("a={}", a);
	}
}
