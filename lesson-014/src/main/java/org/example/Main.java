package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1 - "task1", "task2"
        // 2  - "task3"
        // 7 x i+1
        String[][] tasks = new String[7][];
        for (int i = 0; i < 7; i++) {
            tasks[i] = new String[i+1];
            for (int j = 0; j < tasks[i].length; j++) {
                tasks[i][j] = "abc";
            }

            }

        for (String[] str : tasks) {
            for (String s : str) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        System.out.println("Enter 1-7");
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (scanner.hasNext()) {
            if (!scanner.hasNextInt()) {
                System.out.println("Not a number");
                scanner.next();
            } else {
                i = scanner.nextInt();
                if (i >= 1 && i <= 7) {
                    break;
                } else {
                    System.out.println("Out of range");
                }
            }
        }
//        if (!scanner.hasNextInt()) {
//            System.out.println("Not a number");
//            return;
//        }
//        int i = scanner.nextInt(); // 4
        /**
         * если число в диапазоне (пн-пт) то рабочий день
         * иначе если число в диапазоне (сб-вс) то выходной день
         * иначе некорректное число
         */

        chooseDayType(i);
    }

    private static void chooseDayType(int i) {
//        System.out.println(i >= 1 && i < 6
//                ? "Work day" :
//                i >= 6 && i <= 7 ? "Weekend" : "Incorrect day" );

        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: System.out.println("Work day");
                break;
            case 6:
            case 7: System.out.println("Weekend");
            break;
            default:
                System.out.println("Incorrect day");
        }

        // todo: запросить дело на этот день недели
        // сохранить его в нужную строчку массива

//        if (i >= 1 && i < 6) {
//            System.out.println("Work day");
//        } else if (i >= 6 && i <= 7) {
//            System.out.println("Weekend");
//        } else {
//            System.out.println("Incorrect day");
//        }
    }
}
