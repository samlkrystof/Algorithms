package main.sorting;

/******************************************************************************
 * Instances of class QuickSort2 are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class QuickSort2 implements ISorting {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right) {
        if (left >= right) return;

        int middle = split(array, left, right);
        sort(array, left, middle - 1);
        sort(array, middle + 1, right);
    }

    private int split(int[] array, int left, int right) {
        int median = findMedian(array, left, right);
        swap(array, median, right);
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

    private int findMedian(int[] array, int left, int right) {
        int middle = (left + right) / 2;
        int median = Math.max(Math.min(array[left], array[middle]), array[right]);
        if (median == array[right]) {
            return right;
        } else if (median == array[left]) {
            return left;
        } else {
            return middle;
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
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
