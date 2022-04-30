package main.datastructures;

/******************************************************************************
 * Instances of class HashTable are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class HashTable<K, V> {
    private Entry<K,V>[] data;
    private byte[] sizes;
    private final byte maxLength;

    private static class Entry<K, V> {
        Entry<K,V> next;
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        this(117);
    }

    public HashTable(int capacity) {
        capacity = findBiggerPrime(capacity);
        data = new Entry[capacity];
        sizes = new byte[capacity];
        maxLength = 15;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K,V> entry = new Entry<>(key, value);
        entry.next = data[index];
        data[index] = entry;

        if (++sizes[index] > maxLength) expandArrays();
    }

    public boolean contains(K key) {
        int index = hash(key);
        Entry<K, V> entry = data[index];
        while (data[index] != null) {
            if (entry.key.equals(key)) {
                return true;
            } else {
                entry = entry.next;
            }
        }
        return false;
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K,V> entry = data[index];
        if (entry == null) throw new RuntimeException("Key is not in the map");
        if (entry.next.key.equals(key)) {
            data[index] = data[index].next;
            return;
        } else {
            while (entry.next != null) {
                if (entry.next.key.equals(key)) {
                    entry.next = entry.next.next;
                    return;
                }
                entry = entry.next;
            }
        }
        throw new RuntimeException("Key is not in the map");
    }

    private int hash(K key) {
        return hash(key, data.length);
    }
    private int hash(K key, int arrayLength) {
        return Math.abs(key.hashCode()) % arrayLength;
    }

    private void expandArrays() {
        int newLength = findBiggerPrime(data.length * 2 + 1);
        Entry<K,V>[] newData = new Entry[newLength];
        byte[] newSizes = new byte[newLength];
        for (int i = 0; i < data.length; i++) {
            while (data[i] != null) {
                Entry<K, V> newEntry = new Entry<>(data[i].key, data[i].value);
                int index = hash(data[i].key, newData.length);
                newEntry.next = newData[index];
                newData[index] = newEntry;
                newSizes[index]++;
                data[i] = data[i].next;
            }
        }
        data = newData;
        sizes = newSizes;
    }

    private int findBiggerPrime(int number) {
        if (number % 2 == 0) number++;
        while (!isPrime(number)) number += 2;
        return number;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i < Math.sqrt(number) + 1; i += 2) {
            if (number % i == 0) return false;
        }

        return true;
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
