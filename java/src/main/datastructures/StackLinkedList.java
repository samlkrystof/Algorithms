package main.datastructures;

/******************************************************************************
 * Instances of class StackLinkedList are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class StackLinkedList<T> implements IStack<T> {
    Link<T> top;

    private static class Link<T> {
        T value;
        Link<T> next;

        public Link(T value) {
            this.value = value;
        }

    }


    @Override
    public void push(T element) {
        Link<T> newLink = new Link<>(element);
        newLink.next = top;
        top = newLink;
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
        return result;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public void removeLast() {
        if (isEmpty()) throw new NullPointerException("Stack is empty");
        top = top.next;
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