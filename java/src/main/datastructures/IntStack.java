package main.datastructures;

/******************************************************************************
 * Instances of class IntStack are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class IntStack {
    private Link top;

    private static class Link {
        public int value;
        public Link next;

        public Link(int value) {
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int value) {
        Link newLink = new Link(value);
        newLink.next = top;
        top = newLink;
    }

    public int pop() {
        if (isEmpty()) throw new NullPointerException("Stack is empty");
        Link result = top;
        top = top.next;
        return result.value;
    }

    public int get() {
        if (isEmpty()) throw new NullPointerException("Stack is empty");
        return top.value;
    }

    public void clear() {
        top = null;
    }

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
