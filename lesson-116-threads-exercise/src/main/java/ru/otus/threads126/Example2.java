package ru.otus.threads126;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Example2 extends Thread{

	@SneakyThrows
	@Override
	public void run() {
		log.info("Before sleep");

		// добавьте засыпание

		log.info("After sleep");
	}

	public static void main(String[] args) {
		var thread = new Example2();
		thread.start();
	}
}
