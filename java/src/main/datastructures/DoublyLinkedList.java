package main.datastructures;

/******************************************************************************
 * Instances of class DoublyLinkedList are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class DoublyLinkedList<T> {
    private Link<T> first;
    private Link<T> current;
    private Link<T> last;
    private int size;

    private static class Link<T> {
        public T data;
        public Link<T> next;
        public Link<T> previous;

        public Link(T data) {
            this.data = data;
        }
    }

    public void moveToFirst() {
        current = null;
    }

    public void moveToLast() {
        current = last.previous;
    }

    public boolean hasNext() {
        if (isEmpty()) return false;
        if (current == null) return first.next != null;
        return current.next != null;
    }

    public boolean hasPrevious() {
        if (isEmpty() || current == null) return false;
        if (current == first) return true;
        return current.previous != null;
    }

    public void next() {
        if (isEmpty()) throw new NullPointerException("List is empty");
        if (current == null) {
            current = first;
        } else if (current.next != null){
            current = current.next;
        } else {
            throw new NullPointerException("You have reached end of the list");
        }
    }

    public void previous() {
        if (isEmpty()) throw new NullPointerException("List is empty");
        if (current == null) throw new NullPointerException("You are on the start of the list");
        current = current.previous;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(T data) {
        Link<T> newLink = new Link<>(data);
        if (isEmpty()) {
            first = last = newLink;
        } else if (current == null) {
            newLink.next = first;
            first.previous = newLink;
            first = newLink;
        } else if (current == last) {
            newLink.previous = last;
            last.next = newLink;
            last = newLink;
        } else {
            current.next.previous = newLink;
            newLink.next = current.next;
            newLink.previous = current;
            current.next = newLink;
        }
        size++;
    }

    public T get() {
        if (isEmpty())
            throw new NullPointerException("List is empty");
        if (current == null) {
            return first.data;
        } else if (current == last) {
            throw new NullPointerException("You are on the end of the list");
        } else {
            return current.next.data;
        }
    }

    public void remove() {
        if (isEmpty())
            throw new NullPointerException("List is empty");
        if (current == last)
        throw new NullPointerException("You are on the end of the list");
        if (current == null) {
            if (first.next == null) {
                first = last = null;
            } else {
                first.next.previous = null;
                first = first.next;
            }
        } else if (current == last.previous) {
            current.next = null;
            last = current;
        } else {
            current.next.next.previous = current;
            current.next = current.next.next;
        }
        size--;
    }

    public void addFirst(T data) {
        Link<T> newLink = new Link<>(data);
        if (isEmpty()) {
            first = last = newLink;
        } else {
            first.previous = newLink;
            newLink.next = first;
            first = newLink;
        }
        size++;
    }

    public void addLast(T data) {
        Link<T> newLink = new Link<>(data);
        if (isEmpty()) {
            first = last = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
            last = newLink;
        }
        size++;
    }

    public T getFirst() {
        if (isEmpty())
            throw new NullPointerException("List is empty");
        return first.data;
    }

    public T getLast() {
        if (isEmpty())
            throw new NullPointerException("List is empty");
        return last.data;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NullPointerException("List is empty");
        if (size == 1) {
            first = last = null;
            current = null;
        } else {
            first.next.previous = null;
            first = first.next;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NullPointerException("List is empty");
        if (size == 1) {
            first = last = null;
        } else {
            last.previous.next = null;
            last = last.previous;
        }
        current = null;
        size--;
    }

    public void addAt(T data, int index) {
        if (isEmpty())
            throw new NullPointerException("List is empty");
        if (index > size - 1)
            throw new IllegalArgumentException("Index must be smaller than size of the list (" + size + ")");
        moveToFirst();
        for (int i = 0; i < index; i++) {
            next();
        }
        add(data);
    }

    public void removeAt(int index) {
        if (isEmpty())
            throw new NullPointerException("List is empty");
        if (index > size - 1)
            throw new IllegalArgumentException("Index must be smaller than size of the list (" + size + ")");
        moveToFirst();
        for (int i = 0; i < index; i++) {
            next();
        }
        remove();
    }

    public void remove(T data) {
        if (isEmpty()) throw new NullPointerException("List is empty");

        moveToFirst();
        Link<T> link = first;
        while (link != null) {
            if (link.data.equals(data)) {
                if (link == first) {
                    if (this.size == 1) {
                        first = last = null;
                    } else {
                        link.next.previous = null;
                        first = first.next;
                    }
                } else if (link == last) {
                    link.previous.next = null;
                    last = last.previous;
                } else {
                    link.previous.next = link.next;
                    link.next.previous = link.previous;
                }
                size--;
            }
            link = link.next;
        }
    }

    public int getSize() {
        return size;
    }

    public int indexOf(T data) {
        int index = 0;
        moveToFirst();
        while (hasNext()) {
            if (current.next.data.equals(data))
                return index;

            next();
            index++;
        }
        return -1;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    public Iterator<T> getIterator() {
        Iterator<T> iterator = new Iterator<>(this);
        iterator.current = this.current;
        return iterator;
    }

    static class Iterator<T> {
        DoublyLinkedList<T> list;
        Link<T> current;

        public Iterator(DoublyLinkedList<T> list) {
            this.list = list;
        }

        public Iterator<T> clone() {
            Iterator<T> newIterator = new Iterator<>(list);
            newIterator.current = this.current;
            return newIterator;
        }

        public T next() {
            if (list.isEmpty())
                throw new NullPointerException("List is empty");
            if (this.current == null) {
                current = list.first;
                return list.first.data;
            } else if (this.hasNext()) {
                this.current = this.current.next;
                return this.current.data;
            } else {
                throw new RuntimeException("You have reached end of the list");
            }
        }

        public T previous() {
            if (list.isEmpty())
                throw new NullPointerException("List is empty");
            if (hasPrevious()) {
                this.current = this.current.previous;
                return current.data;
            } else {
                throw new RuntimeException("You have reached end of the list");
            }
        }

        public boolean hasNext() {
            if (list.size <= 1) return false;
            return current == null || current.next != null;
        }

        public boolean hasPrevious() {
            if (list.size <= 1 || current == null) return false;
            return current.previous != null;
        }

        public void add(T data) {
            Link<T> newLink = new Link<>(data);
            if (list.isEmpty()) {
                list.first = list.last = newLink;
            } else if (current == null){
                newLink.next = list.first;
                list.first.previous = newLink;
                list.first = newLink;
            } else if (current == list.last) {
                newLink.previous = list.last;
                list.last.next = newLink;
                list.last = newLink;
            } else {
                newLink.next = current.next;
                newLink.previous = current;
                current.next.previous = newLink;
                current.next = newLink;
            }
            list.size++;

        }

        public void remove() {
            if (list.isEmpty())
                throw new RuntimeException("List is empty");
            if (current == null) {
                list.first.next.previous = null;
                list.first = list.first.next;
            } else if (current.next == null) {
                current.previous.next = null;
                current = current.previous;
                list.last = current;
            } else {
                current.next.next.previous = current;
                current.next = current.next.next;
            }
            list.size--;
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
