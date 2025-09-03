package org.viktsh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Viktor Shvidkiy. Lab 3
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("\n──────────────────────────────");
        System.out.println("Односвязный список");
        System.out.println("──────────────────────────────");
        System.out.println("Создаем односвязный список.");
        CustomList<Integer> lList = new CustomLinkedList<>();
        //Добавление значения в начало списка
        System.out.println("Добавляем в начало 2, 1, 0.");
        for (int i = 2; i >= 0; i--) lList.addToHead(i);
        //Извлечение значения из начала списка без его удаления
        System.out.println("Первый элемент списка:");
        lList.printHead();
        //Извлечение значения из начала списка с удалением из списка
        System.out.println("Выводим первый элемент списка и удаляем.");
        lList.printHeadDelete();
        System.out.println("Теперь первый элемент:");
        lList.printHead();
        //Добавление значения в конец списка
        System.out.println("Добавляем в конец 2, 3.");
        lList.addToTail(2);
        lList.addToTail(3);
        //Извлечение значения из конца списка без его удаления
        System.out.println("Последний элемент списка:");
        lList.printTail();
        //Извлечение значения из конца списка с удалением
        System.out.println("Выводим последний элемент списка и удаляем.");
        lList.printTailDelete();
        System.out.println("Теперь последний элемент списка:");
        lList.printTail();
        //Определение, содержит ли список заданное значение, или нет
        System.out.println("Содержит ли список значение 1: " + lList.contains(1));
        System.out.println("Содержит ли список значение 10: " + lList.contains(10));
        //Определение, является ли список пустым
        System.out.println("Является ли список пустым: " + lList.isEmpty());
        System.out.println("Удаляем оба элемента из списка.");
        lList.deleteValue(1);
        lList.deleteValue(2);
        System.out.println("Является ли список пустым: " + lList.isEmpty());
        //Печать всех значений списка
        System.out.println("Добавляем новые элементы.");
        lList.addToHead(100);
        lList.addToTail(4);
        lList.addToHead(3);
        lList.addToTail(5);
        lList.addToHead(2);
        lList.addToTail(100);
        lList.addToHead(1);
        lList.addToHead(100);
        System.out.println("Выводим все значения списка:");
        lList.printAll();
        //Удаление заданного значения из списка
        System.out.println("Удаляем значения 100 из списка:");
        lList.deleteValue(100);
        lList.printAll();
        //Выполенине действия, заданного в параметре метода для каждого значения из списка
        System.out.println("Выполняем действие над всеми - выводим на экран, является ли элемент четным:");
        lList.processEach(n -> {
            System.out.print(n + ": ");
            System.out.println(n % 2 == 0);
        });
        System.out.println("Выводим все значения списка:");
        lList.printAll();
        //Для проверки данных методов для двусвязного списка можно исправить тип в объявлении списка lList
        //Далее проверим уникальные методы для двусвязного списка

        System.out.println("\n──────────────────────────────");
        System.out.println("Двусвязный список");
        System.out.println("──────────────────────────────");
        System.out.println("Создаем двусвязный список с числами от 9 до 11");
        CustomTwoLinkedList<Integer> tlList = new CustomTwoLinkedList<>();
        for (int i = 9; i < 12; i++) tlList.addToTail(i);
        tlList.printAll();
        //Добавление всех значений заданного массива в начало списка с сохранением порядка
        System.out.println("Добавляем значения массива из 3-х чисел (6, 7, 8) в начало списка:");
        Integer[] arr = {6, 7, 8};
        tlList.addArrayToHead(arr);
        tlList.printAll();
        //Добавление всех значений заданной коллекции в начало списка с сохранением порядка
        System.out.println("Добавляем коллекцию arrayList из трех элементов (3, 4, 5) в начало списка:");
        List<Integer> al = new ArrayList<>(Arrays.asList(3, 4, 5));
        tlList.addIterableToHead(al);
        tlList.printAll();
        System.out.println("Добавляем коллекцию linkedList из трех элементов (0, 1, 2) в начало списка:");
        List<Integer> ll = new LinkedList<>(Arrays.asList(0, 1, 2));
        tlList.addIterableToHead(ll);
        tlList.printAll();
        //Добавление всех значений заданного массива/коллекции в конец списка
        System.out.println("Добавляем значения массива из 3-х чисел (12, 13, 14) в конец списка:");
        Integer[] arr1 = {12, 13, 14};
        tlList.addArrayToTail(arr1);
        tlList.printAll();
        System.out.println("Добавляем колелкцию arrayList из трех элементов (15, 16, 17) в конец списка:");
        List<Integer> al1 = new ArrayList<>(Arrays.asList(15, 16, 17));
        tlList.addIterableToTail(al1);
        tlList.printAll();
        System.out.println("Добавляем коллекцию linkedList из трех элементов (18, 19, 20) в конец списка:");
        List<Integer> ll1 = new ArrayList<>(Arrays.asList(18, 19, 20));
        tlList.addIterableToTail(ll1);
        tlList.printAll();
        //Поглощение списка другим списком с добавлением значений второго в начало/конец первого списка
        System.out.println("Добавляем список headList со значениями -3, -2, -1 в начало списка:");
        CustomTwoLinkedList<Integer> headList = new CustomTwoLinkedList<>();
        headList.addToTail(-3);
        headList.addToTail(-2);
        headList.addToTail(-1);
        tlList.addCustomTwoLinkedListToHead(headList);
        tlList.printAll();
        System.out.println("Добавляем список tailList со значениями 21, 22, 23 в конец списка:");
        CustomTwoLinkedList<Integer> tailList = new CustomTwoLinkedList<>();
        tailList.addToTail(21);
        tailList.addToTail(22);
        tailList.addToTail(23);
        tlList.addCustomTwoLinkedListToTail(tailList);
        tlList.printAll();
        //Печать всех значений списка в обратном порядке
        System.out.println("Печатаем все значения списка в обратном порядке:");
        tlList.printAllReverse();
        //Выполнение действия, заданного в параметре метода, для каждого значения списка в прямом/обратном порядке
        System.out.println("Инкрементируем все значения на 2 в прямом порядке:");
        //tlList.peek(2);
        tlList.printAll();
        System.out.println("Инкрементируем все значения на 2 в обратном порядке:");
        //tlList.peek(2);
        tlList.printAll();

        System.out.println("\n──────────────────────────────");
        System.out.println("Развернутый односвязный список");
        System.out.println("──────────────────────────────");
        System.out.println("Создаем развернутый односвязный список.");
        CustomList<Integer> elList = new CustomExpandedLinkedList<>();
        //Добавление значения в начало списка
        System.out.println("Добавляем в начало 4, 3, 2, 1, 0.");
        for (int i = 4; i >= 0; i--) {
            elList.addToHead(i);
        }
        ;
        elList.printAll();
        //Извлечение значения из начала списка без его удаления
        System.out.println("Первый элемент списка:");
        elList.printHead();
        //Извлечение значения из начала списка с удалением из списка
        System.out.println("Выводим первый элемент списка и удаляем.");
        elList.printHeadDelete();
        System.out.println("Теперь первый элемент:");
        elList.printHead();
        //Добавление значения в конец списка
        System.out.println("Добавляем в конец 5, 6.");
        elList.addToTail(5);
        elList.addToTail(6);
        //Извлечение значения из конца списка без его удаления
        System.out.println("Последний элемент списка:");
        elList.printTail();
        //Извлечение значения из конца списка с удалением
        System.out.println("Выводим последний элемент списка и удаляем.");
        elList.printTailDelete();
        System.out.println("Теперь последний элемент списка:");
        elList.printTail();
        //Определение, содержит ли список заданное значение, или нет
        System.out.println("Содержит ли список значение 1: " + elList.contains(1));
        System.out.println("Содержит ли список значение 10: " + elList.contains(10));
        //Печать всех значений списка
        System.out.print("Все значения списка: ");
        elList.printAll();
        //Определение, является ли список пустым
        System.out.println("Является ли список пустым: " + elList.isEmpty());
        System.out.println("Удаляем все элементы из списка.");
        for (int i = 1; i < 6; i++) elList.deleteValue(i);
        System.out.println("Является ли список пустым: " + elList.isEmpty());
        //Печать всех значений списка
        System.out.println("Все значения списка: ");
        elList.printAll();
        //Удаление заданного значения из списка
        System.out.println("создаем новый список из 3,1,2,3,4,5,3");
        for (int i = 1; i <6; i++) {
            elList.addToTail(i);
        }
        elList.printAll();
        elList.addToHead(3);
        elList.addToTail(3);
        System.out.print("Все значения списка: ");
        elList.printAll();
        System.out.println("Удаляем значения 100 из списка:");
        elList.deleteValue(100);
        elList.printAll();
        System.out.println("Удаляем значения 3 из списка:");
        elList.deleteValue(3);
        elList.printAll();
    }
}
