package main.datastructures;

/******************************************************************************
 * Instances of class QueueArray are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class QueueArray<T> implements IQueue<T> {
    private Object[] array;
    private int first;
    private int count;

    public QueueArray() {
        this(10);
    }

    public QueueArray(int initialCapacity) {
        array = new Object[initialCapacity];
        first = 0;
        count = 0;
    }
    @Override
    public void add(T element) {
        if (count == array.length) expandArray();
        array[(first + count) % array.length] = element;
        count++;
    }

    private void expandArray() {
        Object[] newArray = new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[(first + i) % array.length];
        }
        array = newArray;
        first = 0;
    }

    @Override
    public T get() {
        if (isEmpty()) throw new NullPointerException("Queue is empty");

        return (T)array[first];
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) throw new NullPointerException("Queue is empty");
        array[first] = null;
        first = (first + 1) % array.length;
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void enqueue(T element) {
        this.add(element);
    }

    @Override
    public T dequeue() {
        T result = this.get();
        removeFirst();
        return result;
    }

    @Override
    public T peek() {
        return this.get();
    }

    public int getSize() {
        return this.count;
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
