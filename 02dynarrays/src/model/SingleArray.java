package model;

public class SingleArray<T> implements IArray<T> {
    private Object[] array;

    public SingleArray() {
        this.array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        resize();
        array[size() - 1] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public void add(T item, int index) {
        if (index == array.length) {
            resize();
        } else {
            resize(index, true);
        }
        array[index] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        T ret = (T) array[index];
        resize(index, false);
        return ret;
    }

    private void resize() {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }

    private void resize(int index, boolean adding){
        Object[] newArray;
        if (adding) {
            newArray = new Object[size() + 1];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index, newArray, index + 1, array.length - index);
        } else {
            newArray = new Object[size() - 1];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index , array.length - index - 1);
        }
        array = newArray;
    }
}
