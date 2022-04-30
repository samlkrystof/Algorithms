package main.sorting;

/******************************************************************************
 * Instances of class BinaryInsertionSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class BinaryInsertionSort extends ASorting {

    @Override
    public void sort(int[] array) {
        this.array = array;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                int index = binarySearchIndex(0, i - 1, array[i]);
                int num = array[i];
                moveToRight(index, i);
                array[index] = num;
            }
        }
    }

    private void moveToRight(int left, int right) {
        for (int i = right; i > left; i--) {
            array[i] = array[i - 1];
        }
    }

    private int binarySearchIndex(int left, int right, int value) {
        if (left >= right) {
            if (array[left] > value) {
                return left;
            } else if (array[left] < value) {
                return left + 1;
            } else {
                return findLastSame(left) + 1;
            }
        }
        int middle = (left + right) / 2;
        if (array[middle] > value) {
            return binarySearchIndex(left, middle - 1, value);
        } else if (array[middle] < value) {
            return binarySearchIndex(middle + 1, right, value);
        } else {
            middle = findLastSame(middle);
            return middle + 1;
        }
    }

    private int findLastSame(int index) {
        int newIndex = index;
        while (array[index] == array[newIndex + 1]) newIndex++;
        return newIndex;
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
