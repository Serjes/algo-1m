package ru.otus.model;

public interface ITree<Key extends Comparable<Key>, Value> {
    void find(Key k);
    void insert(Key k, Value v);
    void remove(Key k);
    void rebalance();
}
