package main.sorting;

import java.util.Arrays;
import java.util.Random;

/******************************************************************************
 * Instances of class MergeSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 * @date 15.08.2021
 */

public class MergeSort {

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) return;

        int middle = (left + right) / 2;
        sort(array, left, middle);
        sort(array, middle + 1, right);
        int[] bitonic = makeBitonic(array, left, middle, right);
        merge(array, bitonic, left);

    }

    private static void merge(int[] array, int[] bitonic, int index) {
        int left = 0;
        int right = bitonic.length - 1;
        for (int i = 0; i < bitonic.length; i++) {
            array[i + index] = bitonic[left] < bitonic[right] ? bitonic[left++] : bitonic[right--];
        }
    }

    private static int[] makeBitonic(int[] array, int start, int middle, int end) {
        int[] bitonic = new int[end - start + 1];

        for (int i = start; i <= middle; i++) {
            bitonic[i - start] = array[i];
        }
        for (int i = middle + 1; i <= end; i++) {
            bitonic[end - start + middle + 1 - i] = array[i];
        }

        return bitonic;
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
