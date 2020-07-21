package Thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerUsingWaitNotify {
    Queue<Integer> queue;
    int size;
    private Object notEmpty = new Object();
    private Object notFull = new Object();

    public ProducerConsumerUsingWaitNotify(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public synchronized void put(int e) {
        while(queue.size() == size) {
            try {
                notFull.wait();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            queue.add(e);
            notEmpty.notifyAll();
        }
    }

    public synchronized int take() {
        while(queue.isEmpty()) {
            try {
                notEmpty.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int temp = queue.remove();
        notFull.notifyAll();
        return temp;
    }
}
