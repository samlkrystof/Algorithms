package main.datastructures;

/******************************************************************************
 * Instances of class StackArray are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class StackArray<T> implements IStack<T> {
    private int filledItems;
    private int freeIndex;
    private Object[] array;

    public StackArray() {
        this(10);
    }

    public StackArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive number");
        }
        freeIndex = 0;
        filledItems = 0;
        array = new Object[initialCapacity];
    }

    @Override
    public int getSize() {
        return this.filledItems;
    }

    @Override
    public void push(T element) {
        if (freeIndex == array.length) expandArray();
        array[freeIndex++] = element;
        filledItems++;
    }

    @Override
    public void add(T element) {
        this.push(element);
    }

    private void expandArray() {
        Object[] newArray = new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public T get() {
        if (isEmpty()) throw new NullPointerException("Stack is empty");
        return (T) array[freeIndex - 1];
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new NullPointerException("Stack is empty");
        if (freeIndex < array.length / 2) reduceArray();
        T result = (T) array[--freeIndex];
        array[freeIndex] = null;
        filledItems--;
        return result;
    }

    @Override
    public void clear() {
        array = new Object[10];
    }

    @Override
    public void removeLast() {
        if (isEmpty()) throw new NullPointerException("Stack is empty");
        if (freeIndex < array.length / 2) reduceArray();
        array[--freeIndex] = null;
        filledItems--;
    }

    @Override
    public boolean isEmpty() {
        return freeIndex == 0;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < filledItems; i++) {
            if (array[Math.abs(freeIndex - 1 - i % array.length)].equals(element)) return true;
        }
        return false;
    }

    @Override
    public void remove(T element) {
        for (int i = 0; i < filledItems; i++) {
            if (array[Math.abs(freeIndex - 1 - i % array.length)].equals(element)) {
                array[Math.abs(freeIndex - 1 - i % array.length)] = null;
            }
        }
    }

    public T elementAt(int index) {
        if (index < 0 || index >= array.length)
            throw new IllegalArgumentException("Index must be between 0 and " + (array.length - 1));
        return (T) array[index];
    }

    private void reduceArray() {
        Object[] newArray = new Object[array.length / 2];
        System.arraycopy(array, 0, newArray, 0, newArray.length);
        array = newArray;
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
