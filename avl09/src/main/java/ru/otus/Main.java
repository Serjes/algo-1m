package ru.otus;

import ru.otus.model.AvlTree;
import ru.otus.model.ITree;

public class Main {
    public static void main(String[] args) {
        ITree<Integer, Integer> tree = new AvlTree<>();
        tree.rebalance();
    }
}
