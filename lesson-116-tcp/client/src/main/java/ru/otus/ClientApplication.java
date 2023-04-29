package ru.otus;

import java.net.Socket;
import java.util.Scanner;

public class ClientApplication {
	public static void main(String[] args) throws Exception {
		try (var socket = new Socket("localhost", 8081);
			var client = new Client(socket.getInputStream(), socket.getOutputStream())) {

			var scanner = new Scanner(System.in);

			while (true) {
				System.out.println("""
					1 - add
					0 - exit""");
				switch (scanner.nextInt()) {
					case 0:
						return;
					case 1:
						System.out.println("add: a, b:");
						System.out.println("result: " + client.add(scanner.nextInt(), scanner.nextInt()));
						break;
				}
			}
		}
	}
}
