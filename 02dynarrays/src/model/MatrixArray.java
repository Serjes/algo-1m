package model;

public class MatrixArray<T> implements IArray<T> {
    private int size;
    private int vector;
    private IArray<IArray<T>> array;

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new SingleArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
//        System.out.println("size = " + size + " array.size() = " + array.size());
        if (size == array.size() * vector)
            array.add(new VectorArray<T>(vector));
        array.get(size / vector).add(item);
        size++;
    }

    @Override
    public T get(int index) {
        return array.get(index / vector).get(index % vector);
    }

    @Override
    public void add(T item, int index) {
//        if ((index + 1) == array.size() * vector)
//            array.add(new VectorArray<T>(vector));
//        array.get(size / vector).add(item);
        if (size == array.size() * vector) {

        }
        int allRemainder = size % vector;
        int remainder = index % vector;
        int numVectors = size / vector;
        int remVectors = numVectors - ((size - index) / vector);
        for (int i = 0; i < remVectors; i++) {


        }
        VectorArray<T> newVectorArray = new VectorArray<>(vector);
//        System.arraycopy(array.get(size / vector), 0, newVectorArray, 1, allRemainder);
        arraycopy(array.get(size / vector), 0, newVectorArray, 1, allRemainder);
        array.get(size / vector);
        size++;
    }

    private void arraycopy(IArray<T> srcIArray, int srcPos, IArray<T> dstIArray, int destPos, int len) {
//        private void arraycopy(IArray<T> tiArray, int srcPos, VectorArray<T> newVectorArray, int destPos, int len) {
//    private void arraycopy(VectorArray<T> srcVectorArray, int srcPos, VectorArray<T> newVectorArray, int destPos, int len) {
        for (int i = 0; i < len; i++) {
            T elem = srcIArray.get(srcPos + i);
            dstIArray.add(elem, destPos + i);
        }

    }

    @Override
    public T remove(int index) {
        return null;
    }
}
