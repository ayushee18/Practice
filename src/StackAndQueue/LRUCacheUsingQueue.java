package StackAndQueue;

import java.util.*;

public class LRUCacheUsingQueue {
    Deque<Integer> queue;
    Set<Integer> set;
    int capacity = 0;

    public LRUCacheUsingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.set = new HashSet<>();
        this.capacity = capacity;
    }

    public void refer(int a){
        if(!set.contains(a)) {
            if(queue.size() == capacity) {
               int last = queue.removeLast();
               set.remove(last);
            }
        } else {
            int index = 0, i = 0;
            Iterator<Integer> itr = queue.iterator();
            while(itr.hasNext()) {
                if(a == itr.next()) {
                    index = i;
                    break;
                }
                i++;
            }
            queue.remove(index);
        }
        queue.push(a);
        set.add(a);
    }

    public void display() {
        Iterator<Integer> itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String[] args) {
        LRUCacheUsingQueue ca = new LRUCacheUsingQueue(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}
