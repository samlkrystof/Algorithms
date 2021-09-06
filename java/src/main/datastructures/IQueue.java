package main.datastructures;

public interface IQueue<T> {
    void add(T element);
    T get();
    void removeFirst();
    boolean isEmpty();
    void enqueue(T element);
    T dequeue();
    T peek();
}
