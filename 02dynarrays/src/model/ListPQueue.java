package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPQueue<T> implements PriorityQueue<T> {
    //    public static final int NUMMBER_OF_PRIORITIES = 10;
    private List<List<T>> queue;
    private int numberOfPriorities = 10;

    public ListPQueue(int numberOfPriorities) {
        this();
        this.numberOfPriorities = numberOfPriorities;
    }

    public ListPQueue() {
        queue = new ArrayList<>();
        for (int i = 0; i < numberOfPriorities; i++) {
            queue.add(i, new LinkedList<>());
        }
    }

    @Override
    public void enqueue(int priority, T item) {
        int realPriority = priority % numberOfPriorities;
//        if (queue.get(realPriority) == null) {
//            queue.add(realPriority, new LinkedList<>());
//        }
        queue.get(realPriority).add(item);
    }

    @Override
    public T dequeue() {
        for (int i = 0; i < numberOfPriorities; i++) {
            if (queue.get(i).get(0) != null) {
                T q = queue.get(i).get(0);
                queue.get(i).remove(0);
                return q;
            }
        }
        return null;
    }
}
