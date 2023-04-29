package ru.otus.threads126;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class Example8 extends Thread {
	//static final List<Integer> list = new CopyOnWriteArrayList<>();
	//static final List<Integer> list = new ArrayList<>();
	static final List<Integer> list = Collections.synchronizedList(new ArrayList<>());
	//static final List<Integer> list = new Vector<>();

	@Override
	public void run() {
		for (int i = 0; i < 1000; ++i) {
			list.add(i);
		}
	}

	@SneakyThrows
	public static void main(String[] args) {
		var threads = List.of(new Example8(), new Example8());

		for (var t : threads)
			t.start();

		for (var t : threads)
			t.join();

		log.info("a={}", list.size());
	}
}
