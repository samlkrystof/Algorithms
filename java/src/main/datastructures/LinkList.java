package main.datastructures;

/******************************************************************************
 * Instances of class LinkList are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class LinkList<T> {
    private Link<T> first;
    private Link<T> current;
    private int size = 0;

    private static class Link<T> {
        Link<T> next;
        T value;

        public Link(T value) {
            this.value = value;
        }
    }

    public void moveToFirst() {
        current = null;
    }

    public void next() {
        if (isEmpty()) throw new NullPointerException("LinkedList is empty");
        if (current == null) {
            current = first;
        } else if (hasNext()) {
            current = current.next;
        } else {
            throw new NullPointerException("You have reached end of LinkedList");
        }
    }

    public void add(T element) {
        Link<T> newLink = new Link<>(element);
        if (current == null) {
            newLink.next = first;
            first = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
        }
        size++;
    }

    public void addFirst(T element) {
        Link<T> newLink = new Link<>(element);
        newLink.next = first;
        first = newLink;
        size++;
    }

    public T get() {
        if (current == null) {
            if (isEmpty()) throw new NullPointerException("LinkedList is empty");
            return first.value;
        } else if (hasNext()) {
            return current.next.value;
        } else {
            throw new NullPointerException("You are trying to get element after last element");
        }

    }

    public boolean hasNext() {
        if (current == null && !isEmpty()) return true;
        return current.next != null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void remove() {
        if (isEmpty()) throw new NullPointerException("LinkedList is empty");
        if (current == null) {
            first = first.next;
            size--;
        } else if (hasNext()) {
            current.next = current.next.next;
            size--;
        } else {
            throw new NullPointerException("You are trying to remove element after last element");
        }
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public int indexOf(T element) {
        if (isEmpty()) return -1;
        int index = 0;
        Link<T> tmp = first;
        while (tmp.next != null) {
            if (tmp.value.equals(element)) return index;
            tmp = tmp.next;
            index++;
        }

        return -1;
    }

    private static class Iterator<T> {
        private final LinkList<T> list;
        private Link<T> current;

        private Iterator(LinkList<T> list) {
            this.list = list;
            current = list.current;
        }

        public Iterator<T> clone() {
            Iterator<T> copy = new Iterator<>(list);
            copy.current = this.current;
            return copy;
        }

        public boolean hasNext() {
            if (list.isEmpty()) return false;
            return current == null || current.next != null;
        }

        public T next() {
            if (hasNext()) {
                if (current == null) {
                    current = list.first;
                } else {
                    current = current.next;
                }
                return current.value;
            } else {
                throw new RuntimeException("You have reached end of the list");
            }
        }

        public void remove() {
            if (hasNext()) {
                if (current == null) {
                    list.first = list.first.next;
                } else {
                    list.current.next = list.current.next.next;
                }
                list.size--;
            } else {
                throw new RuntimeException("You have reached end of the list");
            }
        }


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