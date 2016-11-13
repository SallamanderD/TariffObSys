package ua.nure.util;

/**
 * Created by Александр Доротенко on 13.11.2016.
 */
public class Pair<K, T> {
    private K key;
    private T value;

    public Pair() {
    }

    public Pair(K key, T value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
