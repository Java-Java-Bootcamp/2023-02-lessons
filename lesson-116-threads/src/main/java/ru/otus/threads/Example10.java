package ru.otus.threads;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

@Slf4j
public class Example10 extends Thread {
	private final Deque<Runnable> tasks = new ArrayDeque<>();

	@Override
	public void run() {
		try {
			while (true) {
				Runnable task;
				synchronized (this) {
					while (tasks.isEmpty()) {
						this.wait();
					}
					task = tasks.pop();
				}
				task.run();
			}
		} catch (InterruptedException e) {
		}
	}

	public void addTask(Runnable runnable) {
		synchronized (this) {
			tasks.add(runnable);
			this.notify();
		}
	}

	@SneakyThrows
	public static void main(String[] args) {
		var t = new Example10();
		t.start();

		t.addTask(() -> log.info("Hello"));
		t.addTask(() -> log.info("cool"));
		t.addTask(() -> log.info("world"));

		t.interrupt();
		t.join();

		log.info("complete");
	}
}
