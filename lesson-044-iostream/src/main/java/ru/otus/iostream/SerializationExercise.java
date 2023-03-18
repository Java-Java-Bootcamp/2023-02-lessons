package ru.otus.iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Entry {
	private int x, y;
	private String message;

	Entry(int x, int y, String message) {
		this.x = x;
		this.y = y;
		this.message = message;
	}

	@Override
	public String toString() {
		return "Entry{" +
				"x=" + x +
				", y=" + y +
				", message='" + message + '\'' +
				'}';
	}
}

public class SerializationExercise {
	public static void main(String ... args) throws Exception {
		try (var os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("serialization.bin")))) {
			os.writeObject(new Entry(1, 2, "Hello"));
			os.writeObject(new Entry(3, 4, "world"));
		}

		try (var is = new ObjectInputStream(new BufferedInputStream(new FileInputStream("serialization.bin")))) {
			var e1 = (Entry)is.readObject();
			var e2 = (Entry)is.readObject();
			System.out.println(e1);
			System.out.println(e2);
		}
	}
}
