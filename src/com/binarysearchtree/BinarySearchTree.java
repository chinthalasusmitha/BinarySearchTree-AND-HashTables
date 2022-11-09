package com.binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>> {

    //Nested class
    static class myBinaryNode<T> {

        //Define variables for Binary Search Tree
        T data;
        myBinaryNode left;
        myBinaryNode right;

        //Declaring parameterized constructor
        myBinaryNode(T value) {
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }

    static myBinaryNode root = null;

    //Adding to Binary Search Tree. (by means of LinkedList)
    public void add(T data) {
        this.root = this.insertRec(this.root, data);
    }

    //Utility function to insert a new node with given data in BST.
    public myBinaryNode insertRec(myBinaryNode node, T data) {
        if (node == null) {
            this.root = new myBinaryNode(data);
            return this.root;
        }

        int comparator = data.compareTo((T) node.data);
//         recursively adding down the tree
        if (comparator <= 0) {
            node.left = this.insertRec(node.left, data);
        } else {
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }

    //Printing the Binary Search Tree.
    public void inOrder() {
        inorderUtil(this.root);
    }

    // Utility function for inorder traversal of tree.
    public void inorderUtil(myBinaryNode node) {
        if (node == null) {
            return;
        }

        inorderUtil(node.left);
        System.out.print(node.data + " ");
        inorderUtil(node.right);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Binary Search Tree");
        BinarySearchTree tree = new BinarySearchTree();

        //Adding values to BST
        tree.add(56);
        tree.add(30);
        tree.add(70);
        tree.add(22);
        tree.add(40);
        tree.add(60);
        tree.add(95);
        tree.add(11);
        tree.add(65);
        tree.add(3);
        tree.add(16);
        tree.add(63);
        tree.add(67);
        //Printing all the values of BST
        tree.inOrder();

//    int size=getSizeOfTree(root);

        int size = getSizeOfTree(root);

        System.out.println("\nThe size of the tree : " + size);
    }

    private static int getSizeOfTree(myBinaryNode current) {
        return current == null ? 0 : 1 + getSizeOfTree(current.left)
                + getSizeOfTree(current.right);


    }


}

