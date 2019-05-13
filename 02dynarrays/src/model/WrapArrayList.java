package model;

import java.util.ArrayList;

public class WrapArrayList<T> implements IArray<T> {

    private ArrayList<T> array;

    public WrapArrayList() {
        array = new ArrayList<>();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public void add(T item) {
        array.add(item);

    }

    @Override
    public T get(int index) {
        return array.get(index);
    }

    @Override
    public void add(T item, int index) {
        array.add(index, item);
    }

    @Override
    public T remove(int index) {
        return array.remove(index);
    }
}
