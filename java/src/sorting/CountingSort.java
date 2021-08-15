package sorting;

import java.util.Arrays;
import java.util.Random;

/******************************************************************************
 * Instances of class CountingSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 * @date 11.08.2021
 */

public class CountingSort {
    public static void sort(int[] array) {
        int maxVal = array[0];
        int minVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            } else if (array[i] < minVal) {
                minVal = array[i];
            }
        }
        sort(array, minVal, maxVal);
    }

    private static void sort(int[] array, int minVal, int maxVal) {
        int[] countArray = new int[maxVal - minVal + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - minVal]++;
        }
        int arrayIndex = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i]-- > 0) {
                array[arrayIndex++] = i + minVal;
            }
        }
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