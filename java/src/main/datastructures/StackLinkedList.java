package main.datastructures;

/******************************************************************************
 * Instances of class StackLinkedList are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class StackLinkedList<T> implements IStack<T> {
    private Link<T> top;
    private int size = 0;

    private static class Link<T> {
        T value;
        Link<T> next;

        public Link(T value) {
            this.value = value;
        }

    }


    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void push(T element) {
        Link<T> newLink = new Link<>(element);
        newLink.next = top;
        top = newLink;
        size++;
    }

    @Override
    public void add(T element) {
        this.push(element);
    }

    @Override
    public T get() {
        if (isEmpty()) throw new NullPointerException("Stack is empty");
        return top.value;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new NullPointerException("Stack is empty");
        T result = top.value;
        top = top.next;
        size--;
        return result;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean contains(T element) {
        if (isEmpty()) return false;

        Link<T> link = top;
        do {
            if (link.equals(element)) return true;
            link = link.next;
        } while (link != null);

        return false;
    }

    @Override
    public void remove(T element) {
        if (isEmpty()) return;

        Link<T> link = top;

        while (link.next != null) {
            if (link.next.equals(element)) {
                link.next = link.next.next;
                return;
            }
            link = link.next;
        }
        size--;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            removeLast();
        }
    }

    @Override
    public void removeLast() {
        if (isEmpty()) throw new NullPointerException("Stack is empty");
        top = top.next;
        size--;
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