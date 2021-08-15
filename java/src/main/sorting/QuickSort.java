package main.sorting;

import java.util.Arrays;
import java.util.Random;

/******************************************************************************
 * Instances of class QuickSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 * @date 14.08.2021
 */

public class QuickSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) return;

        int middle = split(array, left, right);
        sort(array, left, middle - 1);
        sort(array, middle + 1, right);
    }

    private static int split(int[] array, int left, int right) {
        int pivot = array[right];
        while (true) {
            while (left < right && array[left] < pivot) left++;

            if (left < right) {
                array[right] = array[left];
                right--;
            } else break;

            while (left < right && array[right] > pivot) right--;

            if (left < right) {
                array[left] = array[right];
                left++;
            } else break;

        }
        array[left] = pivot;
        return left;
    }


    public static void test() {
        int max = 5000;
        Random random = new Random();
        for (int i = 0; i < max; i++) {
            int[] array = new int[random.nextInt(max)];
            int[] arrayCopy = new int[array.length];
            for (int j = 0; j < array.length; j++) {
                int number = random.nextInt(max) - 2500;
                array[j] = number;
                arrayCopy[j] = number;
            }
            Arrays.sort(arrayCopy);
            sort(array);
            for (int j = 0; j < array.length; j++) {
                if (array[j] != arrayCopy[j]) {
                    System.out.println("Chyba");
                }
            }
        }
    }

    public static void main(String[] args) {
        //int[] array = new int[]{2,5,1,4,7, 6, -3};
        //sort(array);
        test();
        //System.out.println(Arrays.toString(array));
    }
    //== CONSTANT CLASS ATTRIBUTES =============================================
    //== VARIABLE CLASS ATTRIBUTES =============================================
    //== STATIC INITIALIZER BLOCK ==============================================
    //== CONSTANT INSTANCE ATTRIBUTES ==========================================
    //== VARIABLE INSTANCE ATTRIBUTES ==========================================
    //==========================================================================
    //== CONSTRUCTORS AND FACTORY METHODS ======================================
    //==========================================================================
    //== PUBLIC CLASS METHODS ==================================================
    //== PRIVATE CLASS METHODS =================================================
    //== ACCESS METHODS OF INSTANCES ===========================================
    //== PUBLIC METHODS OF INSTANCES ===========================================
    //== PRIVATE METHODS OF INSTANCES ==========================================
}
