package main.sorting;

/******************************************************************************
 * Instances of class CountingSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 * @date 11.08.2021
 */

public class CountingSort implements ISorting {
    public void sort(int[] array) {
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

    private void sort(int[] array, int minVal, int maxVal) {
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
