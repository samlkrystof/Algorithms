package main.datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;

/******************************************************************************
 * Instances of class Priorityq are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class PriorityQueue<K extends Comparable<K>, V> {
    private final ArrayList<K> priorities;
    private final ArrayList<V> values;
    private final Hashtable<V, Integer> hashtable;
    private final Comparator<K> comparator;

    public PriorityQueue(int initialCapacity, Comparator<K> comparator) {
        if (initialCapacity <= 0) throw new IllegalArgumentException("Initial capacity must be positive!");
        this.priorities = new ArrayList<>(initialCapacity);
        this.values = new ArrayList<>(initialCapacity);
        this.comparator = comparator;

        hashtable = new Hashtable<>();
    }
    public PriorityQueue(Comparator<K> comparator) {
        this(10, comparator);
    }

    public PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

    public PriorityQueue() {
        this(10, null);
    }

    public void add(K key, V value) {
        priorities.add(key);
        values.add(value);
        fixUp(priorities.size() - 1);
    }

    public boolean updatePriority(V value, K newPriority) {
        Integer index = hashtable.get(value);
        if (index == null) return false;

        K oldPriority = priorities.get(index);
        priorities.set(index, newPriority);
        if (comparator == null) {
            if (newPriority.compareTo(oldPriority) < 0) {
                fixUp(index);
            } else {
                fixDown(index);
            }
        } else {
            if (comparator.compare(newPriority, oldPriority) < 0) {
                fixUp(index);
            } else {
                fixDown(index);
            }
        }

        return true;
    }

    private void fixUp(int index) {
        while (true) {
            int parent = (index - 1) / 2;
            if (index == 0 || hasBiggerPriority(parent, index)) break;
            swap(index, parent);
            hashtable.replace(values.get(index), index);

            index = parent;
        }
        hashtable.put(values.get(index), index);

    }

    private void swap(int first, int second) {
        K tmpK = priorities.get(first);
        V tmpV = values.get(first);

        priorities.set(first, priorities.get(second));
        values.set(first, values.get(second));

        priorities.set(second, tmpK);
        values.set(second, tmpV);
    }

    public V peek() {
        if (isEmpty()) throw new NullPointerException("Priority Queue is empty");
        return values.get(0);
    }

    private boolean isEmpty() {
        return priorities.isEmpty();
    }

    public boolean contains(V value) {
        return hashtable.contains(value);
    }

    public void removeValue(V value) {
        Integer index = hashtable.get(value);
        if (index == null) return;

        int lastElement = priorities.size() - 1;
        hashtable.remove(values.get(index), index);
        priorities.set(index, priorities.remove(lastElement));
        values.set(index, values.remove(lastElement));
        fixDown(index);
    }


    public V poll() {
        if (isEmpty()) throw new NullPointerException("Priority Queue is empty");
        V value = values.get(0);
        int laslElement = priorities.size() - 1;
        if (laslElement == 0) {
            hashtable.remove(values.remove(0));
            priorities.remove(0);

            return value;
        }
        priorities.set(0, priorities.remove(laslElement));
        V removedValue = values.remove(laslElement);
        values.set(0, removedValue);
        hashtable.remove(removedValue, 0);

        fixDown(0);
        return value;
    }

    private boolean hasBiggerPriority(int first, int second) {
        if (first >= priorities.size() || second >= priorities.size())
            throw new IllegalArgumentException("Arguments must be smaller than size of Priority Queue!");

        if (comparator == null) {
            return priorities.get(first).compareTo(priorities.get(second)) < 0;
        }

        return comparator.compare(priorities.get(first), priorities.get(second)) < 0;
    }

    private void fixDown(int index) {

        while (true) {
            int left = index * 2 + 1;
            int right = left + 1;
            int max = left;
            if (right < priorities.size() && hasBiggerPriority(right, left)) max = right;

            if (left >= priorities.size() || hasBiggerPriority(index, left)) break;

            swap(max, index);
            hashtable.replace(values.get(index), index);

            index = max;
        }
        hashtable.replace(values.get(index), index);

    }

    public static void main(String[] args) {
        PriorityQueue<Integer, Integer> pq = new PriorityQueue<>();
        pq.add(7,7);
        pq.add(4,4);
        pq.add(6,6);
        pq.add(5,5);
        pq.add(3,3);
        pq.add(2,2);
        pq.add(1,1);
        pq.add(10,10);
        pq.add(-50, -50);
        pq.updatePriority(7, -1000);
        pq.removeValue(-50);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
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
