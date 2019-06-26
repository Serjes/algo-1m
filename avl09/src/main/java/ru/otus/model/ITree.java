package ru.otus.model;

public interface ITree<Key, Value> {
    void insert(Key k, Value v);
    void remove(Key k);
    void rebalance();
}
