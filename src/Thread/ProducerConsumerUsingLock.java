package Thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingLock {

    Queue<Integer> queue;
    int size;
    ReentrantLock lock = new ReentrantLock(true);
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public ProducerConsumerUsingLock(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public void put(int e) {
        lock.lock();
        if(queue.size() == size) {
            try {
                notFull.wait();
                queue.add(e);
                notEmpty.signalAll();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            queue.add(e);
            notEmpty.signalAll();
        }
    }

    public int take() {
        lock.lock();
        int temp = 0;
        if(queue.isEmpty()) {
            try {
                notEmpty.wait();
                temp = queue.remove();
                notFull.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            temp = queue.remove();
        }
        return temp;
    }
}
