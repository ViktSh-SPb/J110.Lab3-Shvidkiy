package org.viktsh;

import java.util.function.Consumer;

public interface CustomList<T> {
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

    void processEach(Consumer<T> consumer);

}
