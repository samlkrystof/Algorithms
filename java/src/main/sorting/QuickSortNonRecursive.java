package main.sorting;

import java.util.Stack;

/******************************************************************************
 * Instances of class QuickStackSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class QuickSortNonRecursive implements ISorting {

    private static class Task {
        public int left;
        public int right;

        public Task(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public void sort(int[] array) {
        Stack<Task> stack = new Stack<>();
        stack.push(new Task(0, array.length - 1));
        while (!stack.isEmpty()) {
            Task t = stack.pop();
            if (t.left >= t.right) continue;
            int middle = split(array, t.left, t.right);
            stack.push(new Task(t.left, middle - 1));
            stack.push(new Task(middle + 1, t.right));
        }
    }

    private int split(int[] array, int left, int right) {
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