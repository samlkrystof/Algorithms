package main.sorting;

import java.util.*;

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
        ASorting[] array = new ASorting[]{ new DPQsortNRCS(), new DualPivotQuickSort(), new DualPivotQuickSort2(),
                new DualPivotQuickSort3(), new DualPivotQuickSort4(), new QuickSort(), new QuickSort2(),
        new Javasort()};
        long[] times = new long[array.length];
        for (int i = 0; i < 10; i++) {
            long seed = System.currentTimeMillis();
            for (int j = 0; j < array.length; j++) {
                ASorting algorithm = array[j];
                if (isWorking(algorithm, seed)) {
                    times[j] += test(algorithm, seed);
                } else {
                    System.out.println(algorithm.getClass().getName() + " is not working");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < times.length; i++) {
            System.out.printf("Total time + %d to test %s\n", times[i], array[i].getClass().getName());
        }
    }

    private static boolean isWorking(ASorting algorithm, long seed) {
        random = new Random(seed);
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

    private static long test(ASorting algorithm, long seed) {
        random = new Random(seed);
        int max = 10_000;
        int reps = 10_000;

        int[] array;
        long start = System.currentTimeMillis();
        for (int i = 0; i < reps / 100; i++) {
            array = new int[random.nextInt(max)];
            for (int j = 0; j < array.length; j++) {
                array[j] = j;
            }
            algorithm.sort(array);

            array = new int[random.nextInt(max)];
            for (int j = 0; j < array.length; j++) {
                array[j] = array.length - j;
            }
            algorithm.sort(array);
        }
        for (int j = 0; j < reps; j++) {
            array = new int[random.nextInt(max)];
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt();
            }
            algorithm.sort(array);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " ms to test " + algorithm.getClass().getName());
        return (end - start);
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
