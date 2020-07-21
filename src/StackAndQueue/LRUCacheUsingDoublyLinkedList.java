package StackAndQueue;

import java.util.HashMap;

class Node{
    int data;
    int key;
    Node prev;
    Node next;

    Node(int key, int data) {
        this.key = key;
        this.data = data;
    }
}

public class LRUCacheUsingDoublyLinkedList {
    private HashMap<Integer, Node> map;
    int capacity, count;
    private Node tail, head;

    LRUCacheUsingDoublyLinkedList(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.tail.prev = head;
        this.head.next = tail;
        this.head.prev = null;
        this.tail.next = null;
        this.count = 0;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        node.next = head;
        node.prev = null;
        head = node;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return map.get(key).data;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.data = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if(count < capacity) {
                addToHead(node);
                count++;
            } else {
                map.remove(tail.key);
                Node temp = tail.prev;
                deleteNode(tail);
                tail = temp;
                addToHead(node);
            }
        }
    }
}
