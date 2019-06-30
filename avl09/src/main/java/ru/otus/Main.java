package ru.otus;

import ru.otus.model.AvlTree;
import ru.otus.model.ITree;

public class Main {
    public static void main(String[] args) {
        ITree<Integer, Integer> tree = new AvlTree<>();
//        tree.insert(9, 1000);
//        tree.insert(3, 1001);
//        tree.insert(5, 1002);
//        tree.insert(1, 1003);
//        tree.insert(0, 1004);
//        tree.insert(10, 1005);

//        tree.rebalance();

//        tree.insert(9, 1000);
//        tree.insert(3, 1001);
//        tree.insert(1, 1001);

        tree.insert(9, 1000);
        tree.insert(8, 1000);
        tree.insert(7, 1000);
        tree.insert(6, 1000);
        tree.insert(5, 1000);
        tree.printTree();
    }
}
