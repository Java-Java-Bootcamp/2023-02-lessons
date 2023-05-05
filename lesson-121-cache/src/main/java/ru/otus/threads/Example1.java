package ru.otus.threads;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/*
-Xms16m
-Xmx16m
*/
@Slf4j
public class Example1 {
	private final static Map<Reference<?>, String> refToKey = new ConcurrentHashMap<>();
	private final static Map<String, Reference<String>> keyToValue = new ConcurrentHashMap<>();
	private final static ReferenceQueue<Object> removedQueue = new ReferenceQueue<>();

	@SneakyThrows
	private static void monitor() {
		while(true) {
			var removed = removedQueue.remove();
			var key = refToKey.remove(removed);
			keyToValue.remove(key);
			log.info("Remove from cache {}", key);

		}
	}

	private static String calculate(String key) {
		log.info("Calculate {}", key);
		var sb = new StringBuilder();
		while (sb.length() < 2000000) {
			sb.append(key);
		}
		return sb.toString();
	}

	private static String calculateWithCache(String key) {
		var ref = keyToValue.get(key);
		String result = ref == null ? null : ref.get();
		if (result != null) {
			log.info("Find in cache {}", key);
			return result;
		}

		result = calculate(key);
		ref = new SoftReference<>(result, removedQueue);

		refToKey.put(ref, key);
		keyToValue.put(key, ref);
		return result;
	}

	@SneakyThrows
	public static void main(String[] args) {
		var thread = new Thread(Example1::monitor);
		thread.setDaemon(true);
		thread.start();


		var s1 = calculateWithCache("s1");
		var s2 = calculateWithCache("s2");
		var s3 = calculateWithCache("s3");
		s1 = null;
		s2 = null;

		calculateWithCache("s1");
		calculateWithCache("s2");
		var s4 = calculateWithCache("s4");
		calculateWithCache("s5");
		calculateWithCache("s6");
		calculateWithCache("s7");
		calculateWithCache("s1");
	}
}
