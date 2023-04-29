package ru.otus.threads;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


class Resource {
	int a;
}

@Slf4j
public class Example6 extends Thread {


	static final Resource r = new Resource();

	static Object lock = new Object();

	@Override
	public void run() {
		var obj = new Object();
		for (int i = 0; i < 100000; ++i) {
			synchronized (r) {
				r.a += 1;
			}
		}
	}

	@SneakyThrows
	public static void main(String[] args) {
		var obj1 = new Example6();
		var obj2 = new Example6();
		var threads = List.of(obj1, obj2);

		for (var t : threads)
			t.start();

		for (var t : threads)
			t.join();

		log.info("a={}", r.a);
	}
}
