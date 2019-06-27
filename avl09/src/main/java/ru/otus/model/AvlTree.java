package ru.otus.model;

public class AvlTree<Key extends Comparable<Key>, Value> implements ITree<Key, Value> {
    private int size = 0;
    private TreeLeaf root;

    private class TreeLeaf<Key, Value> {
        Key key;
        Value value;
        int balance;
        int height;
        TreeLeaf parent;
        TreeLeaf left;
        TreeLeaf right;

        public TreeLeaf(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void find(Key k) {

    }

    @Override
    public void insert(Key k, Value v) {

    }

    @Override
    public void remove(Key k) {

    }

    @Override
    public void rebalance() {

    }

    private int height(TreeLeaf x, TreeLeaf y){
        if(x == null && y == null) return 0;
        else if(x == null) return y.height;
        else if(y == null) return x.height;
        else return Math.max(x.height, y.height);
    }

    private int balance(TreeLeaf x, TreeLeaf y){
        if(x == null && y == null) return 0;
        else if(x == null) return - y.height;
        else if(y == null) return x.height;
        else return x.height - y.height;
    }
}
