package model;

public class FactorArray<T> implements IArray<T> {

    private Object[] array;
    private int factor;
    private int size;

    public FactorArray(int factor, int initLength) {
        this.factor = factor;
        array = new Object[initLength];
        size = 0;
    }

    public FactorArray() {
        this(50, 10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length)
            resize();
        array[size] = item;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public void add(T item, int index) {
        resize(index, true);
        array[index] = item;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        T ret = (T) array[index];
        resize(index, false);
        size--;
        return ret;
    }

    private void resize() {
        Object[] newArray = new Object[array.length + array.length * factor / 100];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    private void resize(int index, boolean adding) {
        Object[] newArray;
        if (adding) {
            newArray = new Object[size() + 1];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index, newArray, index + 1, size() - index);
        } else {
            newArray = new Object[size() - 1];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, size() - index - 1);
        }
        array = newArray;
    }
}
