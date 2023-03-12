package ru.otus.collections;

import java.util.Scanner;

public class Example4 {
	private static void printMenu() {
		System.out.println("""
							0 - add entry
							1 - find entry
							2 - print
							3 - exit
				""");
	}

	public static void main(String ... args) {
		Scanner scanner = new Scanner(System.in);

		// заведите хэшмэп, ключ и значение - String

		while (true) {
			printMenu();
			switch (Integer.parseInt(scanner.nextLine())) {
				case 0: {
					System.out.println("Enter name");
					var key = scanner.nextLine();

					System.out.println("Enter value");
					var value = scanner.nextLine();

					// ваш выход - добавьте эту пару в хэшмэп
					break;
				}
				case 1: {
					System.out.println("Enter name");
					var key = scanner.nextLine();
					// ваш выход - если ключ есть, выведите значение. Если нет - выведите сообщение об отсутствии
					break;
				}
				case 2:
					/* ваш выход - распечатайте словарь, желательно "красиво" - шапка и в каждой строке по одной паре
					   Пользователь\tТелефон
					   Petr\t12-456-789
					   Vasya\t789-45-12
					 */
					break;
				case 3:
					return;
			}
		}
	}
}
