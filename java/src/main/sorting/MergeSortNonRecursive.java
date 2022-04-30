package main.sorting;

import java.util.Stack;

/******************************************************************************
 * Instances of class MergeStackSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class MergeSortNonRecursive extends ASorting {

    private static class Task {
        public int left;
        public int right;
        public int segment;
        public Task(int left, int right) {
            this.left = left;
            this.right = right;
            this.segment = 0;
        }
    }

    public void sort(int[] array) {
        this.array = array;
        Stack<Task> stack = new Stack<>();
        stack.push(new Task(0, array.length - 1));
        while (!stack.isEmpty()) {
            Task t = stack.pop();
            if (t.left >= t.right) continue;
            int middle = (t.left + t.right) / 2;
            switch (t.segment) {
                case 0:
                    t.segment++;
                    stack.push(t);
                    stack.push(new Task(t.left, middle));
                    stack.push(new Task(middle + 1, t.right));
                    break;
                case 1:
                    int[] bitonic = makeBitonic(t.left, middle, t.right);
                    merge(bitonic, t.left);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + t.segment);
            }
        }
    }

    private void merge(int[] bitonic, int index) {
        int left = 0;
        int right = bitonic.length - 1;
        for (int i = 0; i < bitonic.length; i++) {
            array[i + index] = bitonic[left] < bitonic[right] ? bitonic[left++] : bitonic[right--];
        }
    }

    private int[] makeBitonic(int start, int middle, int end) {
        int[] bitonic = new int[end - start + 1];

        for (int i = start; i <= middle; i++) {
            bitonic[i - start] = array[i];
        }
        for (int i = middle + 1; i <= end; i++) {
            bitonic[end - start + middle + 1 - i] = array[i];
        }

        return bitonic;
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


