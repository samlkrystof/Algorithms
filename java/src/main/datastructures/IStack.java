package main.datastructures;

public interface IStack<T> {
    void push(T element);
    void add(T element);
    T get();
    T pop();
    void clear();
    void removeLast();
    boolean isEmpty();
}
