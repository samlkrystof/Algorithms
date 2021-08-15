package sorting;

import java.util.*;

/******************************************************************************
 * Instances of class ShellSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 * @date 11.08.2021
 */

public class ShellSort {
    public static void sort(int[] array) {
        int gap = 1;
        while (gap < array.length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int tmp = array[j];
                while (j >= gap && tmp < array[j - gap]) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = tmp;
            }
            gap /= 3;
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
