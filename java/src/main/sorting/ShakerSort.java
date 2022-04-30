package main.sorting;

/******************************************************************************
 * Instances of class ShakerSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class ShakerSort extends ASorting {

    public void sort(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
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

            for (int j = array.length - i - 1; j > i ; j--) {
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
