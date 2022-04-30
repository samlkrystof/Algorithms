package main.sorting;

/******************************************************************************
 * Instances of class CountingSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 * @date 11.08.2021
 */

public class CountingSort extends ASorting {
    public void sort(int[] array) {
        this.array = array;
        if (array.length < 2) return;
        int maxVal = array[0];
        int minVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            } else if (array[i] < minVal) {
                minVal = array[i];
            }
        }
        sort(minVal, maxVal);
    }

    private void sort(int minVal, int maxVal) {
        int length;
        try {
            length = Math.addExact(Math.subtractExact(maxVal, minVal), 1);
        } catch (ArithmeticException e) {
            System.out.println("Cannot sort this array with this algorithm");
            return;
        }

        int[] countArray = new int[length];
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
