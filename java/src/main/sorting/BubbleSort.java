package main.sorting;

/******************************************************************************
 * Instances of class BubbleSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 * @date 11.08.2021
 */

public class BubbleSort implements ISorting {

    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean notSwapped = true;
            int tmp;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                    notSwapped = false;
                }
            }

            if (notSwapped) {
                return;
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
