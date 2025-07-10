package org.viktsh;

import java.util.function.Consumer;

public interface CustomList<T> extends Iterable<T>{
    void addToHead(T data);

    void addToTail(T data);

    void printHead();

    void printHeadDelete();

    void printTail();

    void printTailDelete();

    boolean contains(T value);

    boolean isEmpty();

    void printAll();

    void deleteValue(T value);

    default void processEach(Consumer<T> consumer){
        for(T item : this){
            consumer.accept(item);
        }
    }

}
