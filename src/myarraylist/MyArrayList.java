package myarraylist;

import java.util.Arrays;


public class MyArrayList<T> {

    private Object[] values = new Object[10];

    private int size = 0;

    public void add(T obj) {
        rebalance();
        values[size] = obj;
        size++;
    }

    public void rebalance() {
        if (values.length == size) {
            values = Arrays.copyOf(values, values.length + 5);
        }
    }

    public T get(int index) {

        return (T) values[index];
    }

    public int size(){
        return size;
    }

    public void clear(){
        for(int i = 0; i<size;i++){
            values[i]=null;
        }
        size=0;
    }

    public boolean remove(int index) {
        for (int i = 0; i < size; i++) {
            if (values[index].equals(values[i])) {
                int numToMove = size - i - 1;
                if (numToMove > 0) {
                    System.arraycopy(values, i + 1, values, i, numToMove);
                }
                values[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(values, size));
    }

    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<String>();
        arrayList.add("name1");
        arrayList.add("name2");
        arrayList.add("name3");
        arrayList.add("name4");
        arrayList.add("name5");
        arrayList.add("name6");
        arrayList.add("name7");
        arrayList.add("name8");
        arrayList.add("name9");
        arrayList.add("name10");
        arrayList.add("name11");
        arrayList.add("name12");
        arrayList.add("name13");
        arrayList.add("name14");
        arrayList.add("name15");
        arrayList.add("name16");

        //System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(5));
        System.out.println(arrayList.size());
        //arrayList.clear();
        //System.out.println(arrayList.size());

        arrayList.remove(5);

        System.out.println(arrayList.get(5));
        System.out.println(arrayList.size);

    }

}