package hashmap;

public class MyHashMap<K, V> {
    private Entry<K, V>[] buckets;
    private int size = 0;

    public MyHashMap() {
        this.buckets = new Entry[10];
    }

    public void clear() {
        this.buckets = new Entry[10];
        size=0;
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> kvEntry = new Entry<>();
        kvEntry.setKey(key);
        kvEntry.setValue(value);

        if (buckets[bucketNumber] == null) {
            buckets[bucketNumber] = kvEntry;
        } else {
            kvEntry.setNextEntry(buckets[bucketNumber]);
            buckets[bucketNumber] = kvEntry;
        }
        size++;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> currentEntry = buckets[bucketNumber];
        if(currentEntry!=null){
            while (currentEntry.getNextEntry() != null) {
                V v = checkEquals(currentEntry, key);
                if (v != null)
                    return v;

                currentEntry = currentEntry.getNextEntry();
            }
            return checkEquals(currentEntry, key);
        } else {
            return null;
        }


    }

    private V checkEquals(Entry<K, V> e, K key) {
        if (e.getKey().equals(key)) {
            return e.getValue();
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void remove(K key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;
        Entry<K, V> prev = null;

        Entry<K, V> currentEntry = buckets[bucketNumber];

        while (currentEntry != null) {
            if (currentEntry.getKey().equals(key)){
                if (prev == null){
                    buckets[bucketNumber] = currentEntry.getNextEntry();
                }else {
                    Entry<K, V> prevGetNextEntry = prev.getNextEntry();
                    prevGetNextEntry = currentEntry.getNextEntry();
                }
                size--;
                return;
            }
            prev = currentEntry;
            currentEntry = currentEntry.getNextEntry();
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        myHashMap.put("name1", 1);
        myHashMap.put("name2", 2);
        myHashMap.put("name3", 3);
        myHashMap.put("name4", 4);
        myHashMap.put("name5", 5);

        System.out.println("myHashMap.get(\"name1\") = " + myHashMap.get("name1"));
        System.out.println("myHashMap.size() = " + myHashMap.size());
        //myHashMap.clear();
        myHashMap.remove("name1");

        System.out.println("myHashMap.get(\"name1\") = " + myHashMap.get("name1"));
        System.out.println("myHashMap.size() = " + myHashMap.size());

    }
}
