package ru.otus.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamExercise {
	public static void main(String ... args) {
		try (InputStream is = new FileInputStream("source.txt");
			 ZipOutputStream os = new ZipOutputStream(new FileOutputStream("target.zip"))) {

			// создайте файл (entry) внутри архива
			// скопируйте
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
