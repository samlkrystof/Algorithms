package main.sorting;

/******************************************************************************
 * Instances of class QuickSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class QuickSort extends ASorting {
    public void sort(int[] array) {
        this.array = array;
        sort(0, array.length - 1);
    }

    private void sort(int left, int right) {
        if (left >= right) return;

        int middle = split(left, right);
        sort(left, middle - 1);
        sort(middle + 1, right);
    }

    private int split(int left, int right) {
        int pivot = array[right];
        while (true) {
            while (left < right && array[left] < pivot) left++;

            if (left < right) {
                array[right] = array[left];
                right--;
            } else break;

            while (left < right && array[right] > pivot) right--;

            if (left < right) {
                array[left] = array[right];
                left++;
            } else break;

        }
        array[left] = pivot;
        return left;
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
