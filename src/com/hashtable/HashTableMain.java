package com.hashtable;

class myMapNode {
    String key;
    int data;
    myMapNode next;
    myMapNode(String key, int data)
    {
        this.key = key;
        this.data = data;
        this.next = null;
    }
}
public class HashTableMain {
    myMapNode head = null;
    myMapNode tail = null;

    public void insert(String data, int count)
    {
        myMapNode newNode = new myMapNode(data, count);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.next = null;
        }
        tail = newNode;
    }
    public void display()
    {
        myMapNode current = head;
        if (head == null) {
            return;
        }
        else
        {
            while (current != null)
            {
                System.out.println(current.key + "=" + current.data);
                current = current.next;
            }
        }
    }

    public static void hashTableOperation(String sentence, HashTableMain hashTable) {
        String[] string = sentence.toLowerCase().split(" ");

        int count = 1;
        for (int i = 0; i < string.length; i++) {

            for (int j = i + 1; j < string.length; j++)//checking element at index equals sentence
            {
                if (string[i].equals(string[j]) && string[i] != "-1")
                {
                    string[j] = "-1";
                    count++;

                }
            }
            if (count > 0 && string[i] != "-1") { // print count string with repeating count
                System.out.println(string[i] + " : " + count);
                string[i] = "-1";
            }
            count = 1;
        }
        for (int i = 0; i < string.length; i++) {

            if ( string[i] != "-1"){
                hashTable.insert(string[i],count);
            }
        }
    }
    public static void main(String[] args) {
        HashTableMain hashTable = new HashTableMain();
        System.out.println("HashTable Operation");
        String string = "To be or not to be";
        hashTableOperation(string,hashTable);
        hashTable.display();
    }
}