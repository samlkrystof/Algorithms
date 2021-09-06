package main.sorting;

import java.util.Arrays;
import java.util.Random;

/******************************************************************************
 * Instances of class Test are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class Test {
    private static Random random;
    public static void main(String[] args) {
        ISorting[] array = new ISorting[]{new BubbleSort(), new CountingSort(), new InsertSort(), new MergeSort(),
        new MergeSortNonRecursive(), new QuickSort(), new QuickSort2(), new QuickSortNonRecursive(), new SelectionSort(),
        new ShakerSort(), new ShellSort()};
        for (ISorting algorithm : array) {
            if (isWorking(algorithm)) {
                test(algorithm);
            } else {
                System.out.println(algorithm.getClass().getName() + " is not working");
            }
        }
    }

    private static boolean isWorking(ISorting algorithm) {
        random = new Random(22);
        int max = 100;
        int reps = 5;
        int[] array;
        int[] arrayCopy;
        for (int j = 0; j < reps; j++) {
            int length = random.nextInt(max);
            array = new int[length];
            arrayCopy = new int[length];
            for (int i = 0; i < array.length; i++) {
                int value = random.nextInt(max);
                array[i] = value;
                arrayCopy[i] = value;
            }
            algorithm.sort(array);
            Arrays.sort(arrayCopy);
            for (int i = 0; i < array.length; i++) {
                if (array[i] != arrayCopy[i]) return false;
            }
        }

        return true;
    }

    private static void test(ISorting algorithm) {
        random = new Random(22);
        int max = 10_000;
        int reps = 200;
        int[] array;
        long start = System.currentTimeMillis();
        for (int j = 0; j < reps; j++) {
            array = new int[random.nextInt(max)];
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(max);
            }
            algorithm.sort(array);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " ms to test " + algorithm.getClass().getName());
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
