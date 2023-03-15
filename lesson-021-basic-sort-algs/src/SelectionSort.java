import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = generateArray();

        System.out.println("Before sort: " + arrayToStr(array));

        selectionSort(array);

        System.out.println("After sort: " + arrayToStr(array));

    }

    private static void selectionSort(int[] array) {
        /*
        1. Находим минимальный элемент
        2. Меняем местами минимальный элемент с первым
        3. Сдвигаем "рабочую" область массива вправо на один элемент

        Повторяем данные действия [длина массива - 1] раз.
         */

        for (int i = 0; i < array.length; i++) {
            findAndSwapMin(i, array);
        }
    }

    /**
     * 1. Находим минимальный элемент
     * 2. Меняем местами минимальный элемент с первым
     * @param startIdx - индекс, с которого начинаем поиск минимального элемента
     * @param array - целевой массив
     */
    private static void findAndSwapMin(int startIdx, int[] array) {
        System.out.println("Searching min from idx: " + startIdx);

        int minIdx = startIdx;
        for (int i = startIdx; i < array.length; i++) {
            if(array[i] < array[minIdx]) {
                minIdx = i;
            }
        }

        System.out.println("Found min idx: " + minIdx + ", value: " + array[minIdx]);

        swap(startIdx, minIdx, array);

        System.out.println("After swap: " + arrayToStr(array));
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
