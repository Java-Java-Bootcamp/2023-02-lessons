package ru.otus.threads126;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Example5 extends Thread {
	static int a = 0;

	@Override
	public void run() {
		//for (int i = 0; i < 100000; ++i)
			a += 1;
	}

	@SneakyThrows
	public static void main(String[] args) {
		var threads = List.of(new Example5(), new Example5());

		for (var t : threads) {
			t.start();
		//	t.join();
		}

		for (var t : threads)
			t.join();

		log.info("a={}", a);
	}
}
