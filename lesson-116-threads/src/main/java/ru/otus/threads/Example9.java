package ru.otus.threads;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class Example9 {
	static final List<Integer> list = new ArrayList<>();
	static final Map<Integer, Integer> map = new HashMap<>();

	@SneakyThrows
	public static void main(String[] args) {
		var threads = List.of(
				new Thread(() -> {
					for (int i = 0; i < 2000; ++i) {
						synchronized (list) {
							synchronized (map) {
								list.add(i);
								map.put(i, i + 1);
							}
						}
					}
				}),
				new Thread(() -> {
					for (int i = 0; i < 2000; ++i) {
						synchronized (map) {
							synchronized (list) {
								list.add(i);
								map.put(i, i + 1);
							}
						}
					}
				}));

		for (var t : threads)
			t.start();

		for (var t : threads)
			t.join();

		log.info("a={}", list.size());
	}
}
