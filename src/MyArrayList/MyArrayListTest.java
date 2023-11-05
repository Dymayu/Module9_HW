package MyArrayList;

import java.util.Arrays;

public class MyArrayListTest<T> {

    private Object[] values = new Object[10];

    private int size = 0;

    public void add(T obj) {
        rebalance();
        values[size] = obj;
        size++;
    }

    public T get(int index) {
        //todo check size
        return (T) values[index];
    }

    private void rebalance() {
        if (values.length == size) {
            values = Arrays.copyOf(values, values.length + 5);
        }
    }

    public static void main(String[] args) {
        MyArrayListTest<String> arrayList = new MyArrayListTest();
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd");
        arrayList.add("asd11");
        arrayList.add("asd12");
        arrayList.add("asd13");


        System.out.println("arrayList.get(13) = " + arrayList.get(13));
    }
}
