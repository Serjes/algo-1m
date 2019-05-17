package model;

public class ListPQueue<T> implements PriorityQueue<T> {
    private PQLinkedList[] queue;
    private int numberOfPriorities = 10;

    public ListPQueue(int numberOfPriorities) {
        this();
        this.numberOfPriorities = numberOfPriorities;
    }

    public ListPQueue() {
        queue = new PQLinkedList[numberOfPriorities];
        for (int i = 0; i < numberOfPriorities; i++) {
            queue[i] = new PQLinkedList<T>();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void enqueue(int priority, T item) {
        int realPriority = priority % numberOfPriorities;
        queue[realPriority].add(item);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        for (int i = 0; i < numberOfPriorities; i++) {
            if (!queue[i].isEmpty()) {
                return (T) queue[i].remove(0);
            }
        }
        return null;
    }

    class PQLinkedList<T> {
        private Node head;
        private int size;

        PQLinkedList() {
            head = null;
            size = 0;
        }

        void add(T element) {
            if (head == null) {
                head = new Node(element);
            } else {
                Node node = head;
                while (node.next != null) {
                    node = node.next;
                }
                node.next = new Node(element);
            }
            size++;
        }

        T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return (T) node.content;
        }

        T remove(int index) {
            T element = get(index);
            if (index == 0) {
                head = head.next;
            } else {
                Node node = head;
                for (int i = 0; i < index - 1; i++) {
                    node = node.next;
                }
                node.next = node.next.next;
            }
            size--;
            return element;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    class Node<T> {
        private T content;
        private Node next;

        Node(T content) {
            this.content = content;
            this.next = null;
        }
    }

}
