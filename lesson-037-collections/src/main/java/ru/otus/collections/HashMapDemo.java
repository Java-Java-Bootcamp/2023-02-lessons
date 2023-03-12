package ru.otus.collections;

import java.util.HashMap;

public class HashMapDemo {
	public static void main(String ... args) {
		var t = new HashMap<String, String>();

		t.put("Ivan", "+7(123)456-78-90");
		t.put("Petr", "+7(123)789-45-60");
		System.out.println(t);

		t.remove("Sveta"); // ничего не сделает

		System.out.println(t.containsKey("Petr"));
		System.out.println(t.getOrDefault("Ivan", "<unknown>"));
	}
}
