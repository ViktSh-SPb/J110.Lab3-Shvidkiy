package org.viktsh;

import java.util.List;
import java.util.function.Consumer;

public interface CustomList<T> extends Iterable<T>{
    void addToHead(T data);

    void addToTail(T data);

    T getHead();

    T getHeadDelete();

    T getTail();

    T getTailDelete();

    boolean contains(T value);

    boolean isEmpty();

    List<T> getAll();

    void deleteValue(T value);

    default void processEach(Consumer<T> consumer){
        for(T item : this){
            consumer.accept(item);
        }
    }

}
