package sorting;

import java.util.Arrays;

public class SelectionSort {

    private static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{12, -3, 7, 6, 8, 92, -103};
        sort(array);
        //prints out -103, -3, 6, 7, 8, 12, 92
        System.out.println(Arrays.toString(array));
    }

}