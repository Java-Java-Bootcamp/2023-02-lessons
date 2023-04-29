package ru.otus.threads126;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class Example3  {
	@SneakyThrows
	public static void main(String[] args) {
		var thread1 = new Thread(() -> {
			try {
				log.info("before sleep");
				Thread.sleep(4000);
				log.info("after sleep");
			} catch (InterruptedException e) {

			}
			log.info("complete");
		});

		var thread2 = new Thread(() -> {
			log.info("before");
			var list = new ArrayList<Integer>();
			for (int i = 0; i < 1_000_000_000; ++i) {
				list.add(i);
				if (list.size() > 1_000_000) list.clear();
				// надо как-то прервать этот цикл, если поток прерван
			}
			log.info("Completed {}", list.size());
		});

		thread1.start();
		Thread.sleep(500);
		thread1.interrupt();
	}
}
