package main.datastructures;

import java.util.Hashtable;

/******************************************************************************
 * Instances of class UnionAndFind are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class UnionAndFind {

    private final int[] predecessor;
    private final int[] size;
    private int numberOfComponents;

    public UnionAndFind(int size) {
        this.size = new int[size];
        this.predecessor = new int[size];
        numberOfComponents = size;

        for (int i = 0; i < predecessor.length; i++) {
            this.predecessor[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(int number) {
        int root = predecessor[number];

        while (root != predecessor[root]) {
            root = predecessor[root];
        }

        compressPath(number, root);
        return root;
    }

    public void union(int first, int second) {
        int root1 = find(first);
        int root2 = find(second);

        if (root1 == root2) return;
        if (size[root1] >= size[root2]) {
            size[root1] += size[root2];
            predecessor[root2] = root1;
        } else {
            size[root2] += size[root1];
            predecessor[root1] = root2;
        }
        numberOfComponents--;
    }

    public int getSizeOfComponent(int element) {
        if (element < 0 || element >= predecessor.length)
            throw new IllegalArgumentException("Number of element must be between 0 and size of UnionAndFind!");
        return size[find(element)];
    }

    public boolean areConnected(int first, int second) {
        return predecessor[first] == predecessor[second];
    }

    private void compressPath(int element, int root) {
        int next;
        while (element != root) {
            next = predecessor[element];
            predecessor[element] = root;
            element = next;
        }
    }

    public int getNumberOfComponents() {
        return numberOfComponents;
    }

    public static void main(String[] args) {
        Hashtable<Character, Integer> table = new Hashtable<>();
        table.put('E', 0);
        table.put('F', 1);
        table.put('I', 2);
        table.put('D', 3);
        table.put('C', 4);
        table.put('A', 5);
        table.put('J', 6);
        table.put('L', 7);
        table.put('G', 8);
        table.put('K', 9);
        table.put('B', 10);
        table.put('H', 11);
        UnionAndFind unionAndFind = new UnionAndFind(12);
        unionAndFind.union(table.get('C'), table.get('K'));
        unionAndFind.union(table.get('F'), table.get('E'));
        unionAndFind.union(table.get('A'), table.get('J'));
        unionAndFind.union(table.get('A'), table.get('B'));
        unionAndFind.union(table.get('C'), table.get('D'));
        unionAndFind.union(table.get('D'), table.get('I'));
        unionAndFind.union(table.get('L'), table.get('F'));
        unionAndFind.union(table.get('C'), table.get('A'));
        unionAndFind.union(table.get('A'), table.get('B'));
        unionAndFind.union(table.get('H'), table.get('G'));
        unionAndFind.union(table.get('H'), table.get('F'));
        unionAndFind.union(table.get('H'), table.get('B'));

        for (int i = 0; i < unionAndFind.predecessor.length; i++) {
//            System.out.print(unionAndFind.find(i) + " " + unionAndFind.getSizeOfComponent(i) + " ");
            System.out.println(unionAndFind.predecessor[i]);
        }
        System.out.println();
        for (int i = 0; i < unionAndFind.predecessor.length; i++) {
//            System.out.print(unionAndFind.find(i) + " " + unionAndFind.getSizeOfComponent(i) + " ");
            System.out.println(unionAndFind.predecessor[i]);
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
