package ru.otus.collections;

import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
		var list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add(0, "x");
		list.add(1, "y");
		list.remove(2);
		list.remove("c");
		System.out.println(list.indexOf("e"));
		System.out.println(list.subList(2, 5));
		System.out.println(list.get(1));
		list.set(2, "q");
	}
}
