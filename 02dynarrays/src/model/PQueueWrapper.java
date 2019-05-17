package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PQueueWrapper<T> implements PriorityQueue<T> {
    private List<List<T>> queue;
    private int numberOfPriorities = 10;

    public PQueueWrapper(int numberOfPriorities) {
        this();
        this.numberOfPriorities = numberOfPriorities;
    }

    public PQueueWrapper() {
        queue = new ArrayList<>();
        for (int i = 0; i < numberOfPriorities; i++) {
            queue.add(i, new LinkedList<>());
        }
    }

    @Override
    public void enqueue(int priority, T item) {
        int realPriority = priority % numberOfPriorities;
        queue.get(realPriority).add(item);
    }

    @Override
    public T dequeue() {
        for (int i = 0; i < numberOfPriorities; i++) {
            if (!queue.get(i).isEmpty()) {
                T q = queue.get(i).get(0);
                queue.get(i).remove(0);
                return q;
            }
        }
        return null;
    }
}
