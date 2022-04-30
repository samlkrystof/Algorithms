package main.datastructures;

/******************************************************************************
 * Instances of class AVLTree are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class AVLTree<K extends Comparable<K>, V> {

    private int size = 0;
    private Node<K,V> root;

    private static class Node<K,V> {
        public K key;
        public V value;
        public byte balance;
        public Node<K,V> parent;
        public Node<K,V> left;
        public Node<K,V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.balance = 0;
        }
    }

    public void add(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);

        if (isEmpty()) {
            root = newNode;
        } else {
            Node<K,V> parent = null;
            Node<K,V> node = root;
            while (node != null) {
                parent = node;
                if (newNode.key.compareTo(node.key) < 0)  {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            newNode.parent = parent;
            if (newNode.key.compareTo(parent.key) < 0) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            updateBalance(newNode);
        }

        size++;
    }

    private void updateBalance(Node<K, V> child) {
        Node<K,V> parent = child.parent;
        while (parent != null) {
            if (child == parent.left) {
                parent.balance--;
            } else {
                parent.balance++;
            }
            if (parent.balance > 1 || parent.balance < -1) {
                rotateTree(parent);
                break;
            }

            child = parent;
            parent = child.parent;
        }
    }

    private void rotateTree(Node<K, V> node) {
        if (node.balance == 2) {
            if (node.right.balance >= 0) {
                rightRightRotate(node);
            } else {
                rightLeftRotate(node);
            }
        } else {
            if (node.left.balance <= 0) {
                leftLeftRotate(node);
            } else {
                leftRightRotate(node);
            }
        }
    }

    private void rightRightRotate(Node<K, V> node) {
        Node<K, V> rightChild = node.right;
        rightChild.parent = node.parent;
        if (node.parent != null) {
            if (node.parent.right == node) {
                node.parent.right = rightChild;
            } else {
                node.parent.left = rightChild;
            }
        } else {
            root = rightChild;
        }
        node.parent = rightChild;
        node.right = rightChild.left;
        rightChild.left = node;
    }

    private void rightLeftRotate(Node<K, V> node) {
        Node<K, V> rightChild = node.right;
        Node<K, V> rightLeftChild = rightChild.left;

        node.right = rightLeftChild;
        rightLeftChild.parent = node;

        rightChild.parent = rightLeftChild;
        rightLeftChild.right = rightChild;

        rightRightRotate(node);
    }

    private void leftRightRotate(Node<K, V> node) {
        Node<K, V> leftChild = node.left;
        Node<K, V> leftRightChild = leftChild.right;

        node.left = leftRightChild;
        leftRightChild.parent = node;

        leftChild.parent = leftRightChild;
        leftRightChild.left = leftChild;

        leftLeftRotate(node);
    }

    private void leftLeftRotate(Node<K, V> node) {
        Node<K, V> leftChild = node.left;
        leftChild.parent = node.parent;
        if (node.parent != null) {
            if (node.parent.right == node) {
                node.parent.right = leftChild;
            } else {
                node.parent.left = leftChild;
            }
        } else {
            root = leftChild;
        }
        node.parent = leftChild;
        node.left = leftChild.right;
        leftChild.right = node;
    }

    public boolean isEmpty() {
        return size == 0;
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
    public static void main(String[] args) {
        AVLTree<Integer, Integer> tree = new AVLTree<>();
        tree.add(3,3);
        tree.add(2,2);
        tree.add(1,1);
        tree.add(4,4);
        tree.add(5,5);
        System.out.println();
        int[] nums = new int[]{105, 924, 32, 968};
        System.out.println(canBeIncreasing(nums));

    }

    public static boolean canBeIncreasing(int[] nums) {
        int problems = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                problems++;
                if (problems > 1) return false;
                if (i != 0 && i != nums.length - 2) {
                    if (nums[i] >= nums[i + 2]) return false;
                }
            }
        }

        return true;
    }
}

