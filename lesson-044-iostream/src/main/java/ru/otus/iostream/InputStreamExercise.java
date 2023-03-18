package ru.otus.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

public class InputStreamExercise {
	public static void main(String ... args) {
		try (InputStream is = new FileInputStream("source.txt");
			 OutputStream os = new FileOutputStream("target.txt")) {

			var buf = new byte[10];

			/*
			Читаем по 10 байт из is и пишем в os
			 */

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
