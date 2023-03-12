package ru.otus.collections;

import java.util.ArrayList;

public class ArrayListIter {
	public static void main(String[] args) {
		var list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add(0, "x");
		list.add(1, "y");

		for (var e : list) {
			System.out.println(e);
		}

		System.out.println("------");
		var iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println("------");
		iter = list.iterator();
		while (iter.hasNext()) {
			var e = iter.next();
			if (e.equals("c"))
				iter.remove();
		}
		System.out.println(list);

	}
}
