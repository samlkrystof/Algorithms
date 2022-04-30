package main.datastructures;

public interface IStack<T> {
    int getSize();
    void push(T element);
    void add(T element);
    T get();
    T pop();
    void clear();
    void removeLast();
    boolean isEmpty();
    boolean contains(T element);
    void remove(T element);
}
