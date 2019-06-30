package ru.otus.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AvlTreeTest {

    private ITree<Integer, Integer> tree;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUp() throws Exception {
        tree = new AvlTree<>();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

//    @Test
//    public void find() {
//    }

    @Test
    public void insertForSmallLeftRotation() {
        tree.insert(5, 1004);
        tree.insert(6, 1003);
        tree.insert(7, 1002);
        tree.insert(8, 1001);
        tree.insert(9, 1000);
        ((AvlTree)tree).printLeaf(((AvlTree<Integer, Integer>) tree).getRoot(), null);
//        assertEquals("smallLeftRotation\r\nsmallLeftRotation\r\nleaf key = 6, value = 1003, height = 3, balance = -1\r\n", outContent.toString());
        assertEquals("leaf key = 6, value = 1003, height = 3, balance = -1\r\n", outContent.toString());
    }

    @Test
    public void insertForSmallRightRotation() {
        tree.insert(9, 1004);
        tree.insert(3, 1003);
        tree.insert(1, 1002);
        ((AvlTree)tree).printLeaf(((AvlTree<Integer, Integer>) tree).getRoot(), null);
//        assertEquals("smallRightRotation\r\nleaf key = 3, value = 1003, height = 2, balance = 0\r\n", outContent.toString());
        assertEquals("leaf key = 3, value = 1003, height = 2, balance = 0\r\n", outContent.toString());
    }

    @Test
    public void insertForBigRightRotation() {
        tree.insert(9, 1000);
        tree.insert(3, 1001);
        tree.insert(5, 1002);
        tree.insert(1, 1003);
        tree.insert(0, 1004);
        tree.insert(10, 1005);
        ((AvlTree)tree).printLeaf(((AvlTree<Integer, Integer>) tree).getRoot(), null);
//        assertEquals("smallLeftRotation\r\nsmallLeftRotation\r\nleaf key = 6, value = 1003, height = 3, balance = -1\r\n", outContent.toString());
        assertEquals("leaf key = 5, value = 1002, height = 3, balance = 0\r\n", outContent.toString());
    }

    @Test
    public void insertForBigLeftRotation() {
        tree.insert(10, 1005);
        tree.insert(0, 1004);
        tree.insert(1, 1003);
        tree.insert(5, 1002);
        tree.insert(3, 1001);
        tree.insert(9, 1000);
        ((AvlTree)tree).printLeaf(((AvlTree<Integer, Integer>) tree).getRoot(), null);
        assertEquals("leaf key = 5, value = 1002, height = 3, balance = 0\r\n", outContent.toString());
    }

//    @Test
//    public void remove() {
//    }
//
//    @Test
//    public void rebalance() {
//    }
//
//    @Test
//    public void printTree() {
//    }
}