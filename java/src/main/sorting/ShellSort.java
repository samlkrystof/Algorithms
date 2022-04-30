package main.sorting;

/******************************************************************************
 * Instances of class ShellSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class ShellSort extends ASorting {
    public void sort(int[] array) {
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
