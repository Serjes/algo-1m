package model;

public class MatrixArray<T> implements IArray<T> {
    public static final int VECTOR = 10;
    private int size;
    private int vector;
    private IArray<IArray<T>> array;

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new SingleArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(VECTOR);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
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
        int pos = index % vector;
        int numVectors = size / vector; //общее количество веторов
        int posVectors = index / vector; //количество векторов до позиции вставки
//        VectorArray<T> newVectorArray;
        for (int i = 0; i < numVectors - posVectors; i++) { //сдвиг на 1 во всех следующих векторах кроме того где вставка
            IArray<T> lastRow = array.get(size / vector - i);
//            newVectorArray = new VectorArray<>(vector);
//            arraycopy(lastRow, 0, newVectorArray, 1, vector - 1 );
//            newVectorArray.add(array.get(size / vector - 1 - i).get(vector - 1), 0);
            lastRow.add(array.get(size / vector - 1 - i).get(vector - 1), 0);
//            array.remove(size / vector - i); // далее замена вектора
//            array.add(newVectorArray, size / vector - i);
        }
        IArray<T> curRow = array.get(size / vector - (numVectors - posVectors));
        curRow.add(item, pos);
        size++;
    }

//    private void arraycopy(IArray<T> srcIArray, int srcPos, IArray<T> dstIArray, int destPos, int len) {
//        for (int i = 0; i < len; i++) {
//            dstIArray.add(srcIArray.get(srcPos + i));
//        }
//
//    }

    @Override
    public T remove(int index) {
        T ret = array.get(index / vector).get(index % vector);
        int numVectors = size / vector; //общее количество веторов
        int posVectors = index / vector; //количество векторов до позиции вставки
        IArray<T> curRow = array.get(size / vector - (numVectors - posVectors));
        curRow.remove(index % vector);
        for (int i = 0; i < numVectors - posVectors; i++) {
            IArray<T> lastRow = array.get(size / vector - i);
            lastRow.remove(0);
        }
        size--;
        return ret;
    }
}
