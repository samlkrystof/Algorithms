package main.datastructures;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/******************************************************************************
 * Instances of class BinarySearchTree are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class BinarySearchTree<K extends Comparable<K>,V> {
    private int size = 0;
    private Node<K,V> root;

    private static class Node<K,V> {
        public K key;
        public V value;
        public Node<K,V> left;
        public Node<K,V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K,V> getMinNode() {
        if (isEmpty()) throw new NullPointerException("BST is empty");
        Node<K,V> node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public V get(K key) {
        if (isEmpty()) throw new NullPointerException("BST is empty");
        Node<K,V> node = root;
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            } else if (node.key.compareTo(key) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    private Node<K,V> getMaxNode() {
        if (isEmpty()) throw new NullPointerException("BST is empty");
        Node<K,V> node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }



    public K getMaxKey() {
        return getMaxNode().key;
    }

    public V getMaxValue() {
        return getMaxNode().value;
    }

    public K getMinKey() {
        return getMinNode().key;
    }

    public V getMinValue() {
        return getMinNode().value;
    }

    public void add(K key, V value) {
        Node<K,V> newNode = new Node<>(key, value);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node<K,V> pred = null;
            Node<K,V> node = root;
            while (node != null) {
                pred = node;
                if (node.key.compareTo(newNode.key) > 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }

            if (pred.key.compareTo(newNode.key) > 0) {
                pred.left = newNode;
            } else {
                pred.right = newNode;
            }
        }
        size++;
    }

    public void remove(K key) {
        if (isEmpty()) throw new NullPointerException("BST is empty");
        Node<K,V> pred = null;
        Node<K,V> node = root;
        while (node != null) {
            int comp = key.compareTo(node.key);
            if (comp < 0) {
                pred = node;
                node = node.left;
            } else if (comp > 0) {
                pred = node;
                node = node.right;
            } else {
                break;
            }
        }
        if (node == null)
            throw new IllegalArgumentException("Item with this key is not in the BST");

        if (node.left == null || node.right == null) {
            Node<K,V> replacement = node.left;
            if (node.right != null) {
                replacement = node.right;
            }

            if (pred == null) {
                root = replacement;
            } else {
                if (pred.right == node) {
                    pred.right = replacement;
                } else {
                    pred.left = replacement;
                }
            }
        } else {
            Node<K,V> leftMaxPred = node;
            Node<K,V> leftMax = node.left;
            while (leftMax.right != null) {
                leftMaxPred = leftMax;
                leftMax = leftMax.right;
            }

            node.key = leftMax.key;
            node.value = leftMax.value;

            if (leftMax.left != null) {
                if (leftMaxPred == node) {
                    node.left = leftMax.left;
                } else {
                    leftMaxPred.right = leftMax.left;
                }
            } else {
                if (leftMaxPred == node) {
                    node.left = null;
                } else {
                    leftMaxPred.right = null;
                }
            }

            size--;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    private List<Node<K,V>> getSortedNodes() {
        if (isEmpty()) throw new NullPointerException("BST is empty");

        List<Node<K,V>> list = new ArrayList<>();
        Stack<Part> stack = new Stack<>();
        stack.push(new Part(root));
        while (!stack.isEmpty()) {
            Part part = stack.pop();
            switch (part.segment) {
                case 0:
                    part.segment++;
                    if (part.node.right != null)
                        stack.push(new Part(part.node.right));
                    stack.push(part);
                    if (part.node.left != null)
                        stack.push(new Part(part.node.left));
                    break;
                case 1:
                    list.add(part.node);
                    break;
            }
        }

        return list;
    }

    public List<K> getSortedKeys() {
        return getSortedNodes().stream()
                .map(node -> node.key)
                .collect(Collectors.toList());
    }

    public List<V> getSortedValues() {
        return getSortedNodes().stream()
                .map(node -> node.value)
                .collect(Collectors.toList());
    }

    public List<Node<K,V>> getAsPreOrder() {
        if (isEmpty()) throw new NullPointerException("BST is empty");
        List<Node<K,V>> list = new ArrayList<>(this.size);

        Stack<Node<K,V>> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node<K,V> node = stack.pop();

            list.add(node);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return list;
    }

    public List<Node<K,V>> getAsPostOrder() {
        if (isEmpty()) throw new NullPointerException("BST is empty");
        List<Node<K,V>> list = new ArrayList<>(this.size);

        Stack<Part> stack = new Stack<>();

        stack.push(new Part(root));
        while (!stack.isEmpty()) {
            Part part = stack.pop();

            switch (part.segment) {
                case 0:
                    part.segment++;
                    stack.push(part);
                    if (part.node.right != null) stack.push(new Part(part.node.right));
                    if (part.node.left != null) stack.push(new Part(part.node.left));
                    break;

                case 1:
                    list.add(part.node);
                    break;
            }
        }

        return list;
    }

    public List<Node<K,V>> getAsLevelOrder() {
        if (isEmpty()) throw new NullPointerException("BST is empty");
        List<Node<K,V>> list = new ArrayList<>(this.size);

        list.add(root);
        for (int i = 0; i < this.size; i++) {
            Node<K,V> node = list.get(i);

            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
        }

        return list;
    }

    public int getSize() {
        return this.size;
    }

    public void processBetween(K min, K max, Consumer<Node<K,V>> consumer) {
        boolean biggerThanMin;
        boolean smallerThanMax;
        if (isEmpty()) throw new NullPointerException("BST is empty");

        Stack<Node<K,V>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<K,V> node = stack.pop();
            if (node == null) continue;
            biggerThanMin = min.compareTo(node.key) <= 0;
            smallerThanMax = max.compareTo(node.key) >= 0;
            if (biggerThanMin) {
                stack.push(node.left);
            }
            if (smallerThanMax) {
                stack.push(node.right);
            }
            if (smallerThanMax && biggerThanMin) {
                consumer.accept(node);
            }
        }

    }

    private class Part {
        int segment;
        final Node<K,V> node;

        public Part(Node<K,V> node) {
            segment = 0;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
        bst.add(7,7);
        bst.add(3,3);
        bst.add(12,12);
        bst.add(1,1);
        bst.add(15,15);
        bst.add(10,10);
        bst.add(6,6);
        bst.add(5,5);
        bst.getSortedKeys().forEach(o -> System.out.print(o + " "));
        System.out.println();
        bst.processBetween(4, 13, o -> System.out.print(o.key + " "));
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
