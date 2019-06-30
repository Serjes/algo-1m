package ru.otus.model;

public class AvlTree<Key extends Comparable<Key>, Value> implements ITree<Key, Value> {
//    private int size = 0;
    private TreeLeaf root;

    private class TreeLeaf {
        Key key;
        Value value;
        int balance;
        int height;
        TreeLeaf parent;
        TreeLeaf left;
        TreeLeaf right;

        TreeLeaf(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void find(Key k) {

    }

    @Override
    public void insert(Key k, Value v) {
        TreeLeaf newLeaf = new TreeLeaf(k, v);
        if (root == null) {
            root = newLeaf;
            root.height = 1;
            root.balance = 0;
        }
        else {
            TreeLeaf currentLeaf = root;
            TreeLeaf parent = null;
            while(currentLeaf != null){
                int cmpResult = k.compareTo(currentLeaf.key);
                if (cmpResult < 0) {
                    parent = currentLeaf;
                    currentLeaf = currentLeaf.left;
                }
                else if (cmpResult > 0) {
                    parent = currentLeaf;
                    currentLeaf = currentLeaf.right;
                }
                else {
                    currentLeaf.value = v;
                    return;
                }
            }
            int cmpResult = k.compareTo(parent.key);
            if (cmpResult < 0) {
                parent.left = newLeaf;
                newLeaf.parent = parent;
                newLeaf.height = 1;
                newLeaf.balance = 0;
                runToCalculateHeight(parent);
                runToCalculateBalance(parent);
            } else {
                parent.right = newLeaf;
                newLeaf.parent = parent;
                newLeaf.height = 1;
                runToCalculateHeight(parent);
                runToCalculateBalance(parent);
            }
        }
    }

    @Override
    public void remove(Key k) {

    }

    @Override
    public void rebalance() {

    }

    @Override
    public void printTree() {
        System.out.print("root => ");
        printLeaf(root);
        runInOrder(root);
    }

    private void runInOrder(TreeLeaf treeLeaf){
        if (treeLeaf == null) return;
        runInOrder(treeLeaf.left);
        printLeaf(treeLeaf);
        runInOrder(treeLeaf.right);
    }

    private void printLeaf(TreeLeaf treeLeaf) {
        System.out.println("leaf key = " + treeLeaf.key + ", value = " + treeLeaf.value +
                ", height = " + treeLeaf.height + ", balance = " + treeLeaf.balance);
    }

    private void runToCalculateHeight(TreeLeaf leaf) {
        leaf.height = calculateHeight(leaf);
        if (leaf.parent != null) runToCalculateHeight(leaf.parent);
    }

    private int calculateHeight(TreeLeaf leaf) {
        return height2Leaf(leaf.left, leaf.right) + 1;
    }

    private int height2Leaf(TreeLeaf x, TreeLeaf y){
        if(x == null && y == null) return 0;
        else if(x == null) return y.height;
        else if(y == null) return x.height;
        else return Math.max(x.height, y.height);
    }

    private void runToCalculateBalance(TreeLeaf leaf) {
        int balance = calculateBalance(leaf);
        if (balance > 1) {
            rightRotation(leaf);
        } else if (balance < -1) {
            leftRotation(leaf);
        } else {
            leaf.balance = calculateBalance(leaf);
        }
        if (leaf.parent != null) runToCalculateBalance(leaf.parent);
    }

    private void rightRotation(TreeLeaf leaf) {
        if ((leaf.left.right == null) || ((leaf.left.left != null) && (leaf.left.right.height <= leaf.left.left.height))) {
            smallRightRotation(leaf);
        } else {
            bigRightRotation(leaf);
        }
    }

    private void smallRightRotation(TreeLeaf leaf) {
        System.out.println("smallRightRotation");
        TreeLeaf a = leaf;
        TreeLeaf b = null;
        if (leaf.left != null) b = leaf.left;
        if (leaf.parent != null) {
            if (leaf.parent.left == leaf) {
                leaf.parent.left = b;
            } else {
                leaf.parent.right = b;
            }
//            leaf.parent.left = b;
            if (b != null) b.parent = leaf.parent;
        } else {
            if (b != null) b.parent = null;
            root = b;
        }
        a.parent = b;
        if (b != null) {
            a.left = b.right;
            b.right = a;
        }

        runToCalculateHeight(a);
        runToCalculateBalance(a);
    }

    private void bigRightRotation(TreeLeaf leaf) {
        System.out.println("bigRightRotation");
        TreeLeaf a = leaf;
//        TreeLeaf b = leaf.left;
//        TreeLeaf c = leaf.left.right;
        smallRightRotation(a);
        smallRightRotation(a);
    }

    private void leftRotation(TreeLeaf leaf) {
        if ((leaf.right.left == null) || ((leaf.right.right != null) && (leaf.right.left.height <= leaf.right.right.height))) {
            smallLeftRotation(leaf);
        } else {
            bigLeftRotation(leaf);
        }
    }

    private void smallLeftRotation(TreeLeaf leaf) {
        System.out.println("smallLeftRotation");
        TreeLeaf a = leaf;
        TreeLeaf b = leaf.right;
        if (leaf.parent != null) {
            leaf.parent.right = b;
            b.parent = leaf.parent;
        } else {
            b.parent = null;
            root = b;
        }
        a.parent = b;
        a.right = b.left;
        b.left = a;

        runToCalculateHeight(a);
        runToCalculateBalance(a);
    }

    private void bigLeftRotation(TreeLeaf leaf) {
        System.out.println("bigLeftRotation");
//        smallLeftRotation(leaf);
//        smallLeftRotation(leaf);
    }

    private int calculateBalance(TreeLeaf leaf) {
        return balance2Leaf(leaf.left, leaf.right);
    }

    private int balance2Leaf(TreeLeaf l, TreeLeaf r){
        if(l == null && r == null) return 0;
        else if(l == null) return -r.height;
        else if(r == null) return l.height;
        else return l.height - r.height;
    }
}
