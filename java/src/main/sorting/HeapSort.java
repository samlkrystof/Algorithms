package main.sorting;

/******************************************************************************
 * Instances of class HeapSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 * @date 13.02.2022
 */

public class HeapSort extends ASorting {

    private int heapSize;

    @Override
    public void sort(int[] array) {
        heapSize = 0;
        this.array = array;
        heapify();

        for (int i = 0; i < array.length - 1; i++) {
            swap(0, array.length - 1 - i);
            heapSize++;
            fixDown(0);
        }
    }

    private void heapify() {
        for (int i = Math.max(0, array.length / 2 - 1); i >= 0; i--) {
            fixDown(i);
        }
    }

    private void fixDown(int index) {
        while (true) {
            int left = index * 2 + 1;
            int right = left + 1;
            int max = left;
            if (right < array.length - heapSize && array[left] < array[right]) max = right;
            if (left >= array.length - heapSize || array[max] <= array[index]) break;
            swap(max, index);

            index = max;
        }
    }

    private void swap(int first, int second) {
        int tmp = array[first];
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
