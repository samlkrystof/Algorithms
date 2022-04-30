package main.sorting;

/******************************************************************************
 * Instances of class DualPivotQuickSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 * @date 11.09.2021
 */

public class DualPivotQuickSort extends ASorting {
    @Override
    public void sort(int[] array) {
        this.array = array;
        if (array.length < 2) return;
        sort(0, array.length - 1);
    }

    protected void sort(int start, int end) {
        if (start >= end) return;
        if (array[start] > array[end]) swap(start, end);
        int leftPivot = array[start];
        int rightPivot = array[end];

        int smaller = start + 1;
        int walker = smaller;
        int bigger = end - 1;

        while (walker <= bigger) {
            if (array[walker] < leftPivot) {
                swap(smaller, walker);
                smaller++;
            } else {
                if (array[walker] > rightPivot) {
                    while (array[bigger] > rightPivot && bigger > walker) bigger--;
                    swap(walker, bigger);
                    bigger--;
                    if (array[walker] < leftPivot) {
                        swap(smaller, walker);
                        smaller++;
                    }
                }
            }

            walker++;
        }

        smaller--;
        bigger++;
        swap(smaller, start);
        swap(bigger, end);

        sort(start, smaller - 1);
        sort(smaller + 1, bigger - 1);
        sort(bigger + 1, end);
    }


    protected void swap(final int first, final int second) {
        final int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
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
