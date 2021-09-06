package main.datastructures;

/******************************************************************************
 * Instances of class QueueLinkedList are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class QueueLinkedList<T> implements IQueue<T> {
    private Link<T> first;
    private Link<T> last;

    private static class Link<T> {
        T value;
        Link<T> next;

        public Link(T value) {
            this.value = value;
        }

    }
    @Override
    public void add(T element) {
        Link<T> newLink = new Link<>(element);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    @Override
    public T get() {
        if (isEmpty()) throw new NullPointerException("Queue is empty");
        return first.value;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) throw new NullPointerException("Queue is empty");
        first = first.next;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void enqueue(T element) {
        this.add(element);
    }

    @Override
    public T dequeue() {
        T result = get();
        removeFirst();
        return result;
    }

    @Override
    public T peek() {
        return this.get();
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
