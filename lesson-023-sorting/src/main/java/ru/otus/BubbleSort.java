package ru.otus;

import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = generateArray();

        System.out.println("Before sort: " + arrayToStr(array));

        bubbleSort(array);

        System.out.println("After sort: " + arrayToStr(array));
    }

    static void bubbleSort(int[] array) {
        /*
        1. Находим два соседних элемента в неправильном порядке
        2. Меняем их местами
        3. Продолжаем двигаться до конца массива

        Повторяем данные действия пока хоть раз пришлось поменять элементы местами
         */

        while (reduceInversions(array) > 0) {
            //System.out.println("Inner loop: " + arrayToStr(array));
        }
    }

    private static int reduceInversions(int[] array) {
        int inversionCount = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                swap(i - 1, i, array);
                inversionCount++;
            }
        }

        return inversionCount;
    }

    private static String arrayToStr(int[] array) {
        String res = "";

        for (int i : array) {
            res += i;
            res += "  ";
        }

        return res;
    }

    private static int[] generateArray() {
        Random random = new Random();

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0, 10);
        }
        return array;
    }

    private static void swap(int idx1, int idx2, int[] array) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
}
