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

        System.out.println("\n──────────────────────────────");
        System.out.println("Двусвязный список");
        System.out.println("──────────────────────────────");
        System.out.println("Создаем двусвязный список.");
        CustomTwoLinkedList<Integer> tlList = new CustomTwoLinkedList<>();
        //Добавление значения в начало списка
        System.out.println("Добавляем в начало 2, 1, 0.");
        for (int i = 2; i >= 0; i--) tlList.addToHead(i);
        //Извлечение значения из начала списка без его удаления
        System.out.println("Первый элемент списка:");
        tlList.printHead();
        //Извлечение значения из начала списка с удалением из списка
        System.out.println("Выводим первый элемент списка и удаляем.");
        tlList.printHeadDelete();
        System.out.println("Теперь первый элемент:");
        tlList.printHead();
        //Добавление значения в конец списка
        System.out.println("Добавляем в конец 2, 3.");
        tlList.addToTail(2);
        tlList.addToTail(3);
        //Извлечение значения из конца списка без его удаления
        System.out.println("Последний элемент списка:");
        tlList.printTail();
        //Извлечение значения из конца списка с удалением
        System.out.println("Выводим последний элемент списка и удаляем.");
        tlList.printTailDelete();
        System.out.println("Теперь последний элемент списка:");
        tlList.printTail();
        //Определение, содержит ли список заданное значение, или нет
        System.out.println("Содержит ли список значение 1: " + tlList.contains(1));
        System.out.println("Содержит ли список значение 10: " + tlList.contains(10));
        //Определение, является ли список пустым
        System.out.println("Является ли список пустым: " + tlList.isEmpty());
        System.out.println("Удаляем оба элемента из списка.");
        tlList.deleteValue(1);
        tlList.deleteValue(2);
        System.out.println("Является ли список пустым: " + tlList.isEmpty());
        //Печать всех значений списка
        System.out.println("Добавляем новые элементы.");
        tlList.addToHead(100);
        tlList.addToTail(4);
        tlList.addToHead(3);
        tlList.addToTail(5);
        tlList.addToHead(2);
        tlList.addToTail(100);
        tlList.addToHead(1);
        tlList.addToHead(100);
        System.out.println("Выводим все значения списка:");
        tlList.printAll();
        //Удаление заданного значения из списка
        System.out.println("Удаляем значения 100 из списка:");
        tlList.deleteValue(100);
        tlList.printAll();
        //Выполенине действия, заданного в параметре метода для каждого значения из списка
        System.out.println("Выполняем действие над всеми - выводим на экран, является ли элемент четным:");
        tlList.processEach(n -> {
            System.out.print(n + ": ");
            System.out.println(n % 2 == 0);
        });
        System.out.println("Выводим все значения списка:");
        tlList.printAll();
        //Добавление всех значений заданного массива в начало списка с сохранением порядка
        System.out.println("Добавляем значения массива из 3-х чисел (-2, -1, 0) в начало списка:");
        Integer[] arr = {-2, -1, 0};
        tlList.addArrayToHead(arr);
        tlList.printAll();
        //Добавление всех значений заданной коллекции в начало списка с сохранением порядка
        System.out.println("Добавляем коллекцию arrayList из трех элементов (-5, -4, -3) в начало списка:");
        List<Integer> al = new ArrayList<>(Arrays.asList(-5, -4, -3));
        tlList.addIterableToHead(al);
        tlList.printAll();
        System.out.println("Добавляем коллекцию linkedList из трех элементов (-8, -7, -6) в начало списка:");
        List<Integer> ll = new LinkedList<>(Arrays.asList(-8, -7, -6));
        tlList.addIterableToHead(ll);
        tlList.printAll();
        //Добавление всех значений заданного массива/коллекции в конец списка
        System.out.println("Добавляем значения массива из 3-х чисел (6, 7, 8) в конец списка:");
        Integer[] arr1 = {6, 7, 8};
        tlList.addArrayToTail(arr1);
        tlList.printAll();
        System.out.println("Добавляем коллекцию arrayList из трех элементов (9, 10, 11) в конец списка:");
        List<Integer> al1 = new ArrayList<>(Arrays.asList(9, 10, 11));
        tlList.addIterableToTail(al1);
        tlList.printAll();
        System.out.println("Добавляем коллекцию linkedList из трех элементов (12, 13, 14) в конец списка:");
        List<Integer> ll1 = new ArrayList<>(Arrays.asList(12, 13, 14));
        tlList.addIterableToTail(ll1);
        tlList.printAll();
        //Поглощение списка другим списком с добавлением значений второго в начало/конец первого списка
        System.out.println("Добавляем список headList со значениями -9, -10, -11 в начало списка:");
        CustomTwoLinkedList<Integer> headList = new CustomTwoLinkedList<>();
        headList.addToTail(-11);
        headList.addToTail(-10);
        headList.addToTail(-9);
        tlList.addCustomTwoLinkedListToHead(headList);
        tlList.printAll();
        System.out.println("Добавляем список tailList со значениями 15, 16, 17 в конец списка:");
        CustomTwoLinkedList<Integer> tailList = new CustomTwoLinkedList<>();
        tailList.addToTail(15);
        tailList.addToTail(16);
        tailList.addToTail(17);
        tlList.addCustomTwoLinkedListToTail(tailList);
        tlList.printAll();
        //Печать всех значений списка в обратном порядке
        System.out.println("Печатаем все значения списка в обратном порядке:");
        tlList.printAllReverse();
        //Выполнение действия, заданного в параметре метода, для каждого значения списка в прямом/обратном порядке
        System.out.println("Инкрементируем все значения на 2 в прямом порядке и выводим в строку:");
        tlList.processEach(n->{n=n+2;
            System.out.print(n+" ");});
        System.out.println("\nИсходный список не изменился");
        tlList.printAll();
        System.out.println("Декрементируем все значения на 2 в обратном порядке:");
        tlList.processEachReverse(n->{n=n-2;
            System.out.print(n+" ");});
        System.out.println("\nИсходный список не изменился");
        tlList.printAll();

        System.out.println("\n──────────────────────────────");
        System.out.println("Развернутый односвязный список");
        System.out.println("──────────────────────────────");
        System.out.println("Создаем развернутый односвязный список.");
        CustomExpandedLinkedList<Integer> elList = new CustomExpandedLinkedList<>();
        //Добавление значения в начало списка
        System.out.println("Добавляем в начало 4, 3, 2, 1, 0.");
        for (int i = 4; i >= 0; i--) {
            elList.addToHead(i);
        }
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
        //Выполнение действия, заданного в параметре метода, для каждого значения списка
        System.out.println("Выполняем действие над всеми - выводим на экран, является ли элемент четным:");
        elList.processEach(n -> {
            System.out.print(n + ": ");
            System.out.println(n % 2 == 0);
        });
        //Добавление всех значений заданного массива в начало списка с сохранением порядка
        System.out.println("Добавляем значения массива из 4-х чисел (-3, -2, -1, 0) в начало списка:");
        Integer[] array = {-3, -2, -1, 0};
        elList.addArrayToHead(array);
        elList.printAll();
        //Добавление всех значений заданной коллекции в начало списка с сохранением порядка
        System.out.println("Добавляем коллекцию arrayList из четырех элементов (-7, -6, -5, -4) в начало списка:");
        List<Integer> alist = new ArrayList<>(Arrays.asList(-7, -6, -5, -4));
        elList.addIterableToHead(alist);
        elList.printAll();
        System.out.println("Добавляем коллекцию linkedList из четырех элементов (-11, -10, -9, -8) в начало списка:");
        List<Integer> llist = new LinkedList<>(Arrays.asList(-11, -10, -9, -8));
        elList.addIterableToHead(llist);
        elList.printAll();
        //Добавление всех значений заданного массива/коллекции в конец списка
        System.out.println("Добавляем значения массива из 2-х чисел (6, 7) в конец списка:");
        Integer[] array1 = {6, 7};
        elList.addArrayToTail(array1);
        elList.printAll();
        System.out.println("Добавляем коллекцию arrayList из двух элементов (8, 9) в конец списка:");
        List<Integer> alist1 = new ArrayList<>(Arrays.asList(8, 9));
        elList.addIterableToTail(alist1);
        elList.printAll();
        System.out.println("Добавляем коллекцию linkedList из двух элементов (10, 11) в конец списка:");
        List<Integer> llist1 = new ArrayList<>(Arrays.asList(10, 11));
        elList.addIterableToTail(llist1);
        elList.printAll();
        //Поглощение списка другим списком с добавлением значений второго в начало/конец первого списка
        System.out.println("Добавляем список headList со значениями -12, -13, -14, -15 в начало списка:");
        CustomExpandedLinkedList<Integer> headList1 = new CustomExpandedLinkedList<>();
        headList1.addToTail(-15);
        headList1.addToTail(-14);
        headList1.addToTail(-13);
        headList1.addToTail(-12);
        elList.addCustomEListToHead(headList1);
        elList.printAll();
        System.out.println("Добавляем список tailList со значениями 12, 13, 14, 15 в конец списка:");
        CustomExpandedLinkedList<Integer> tailList1 = new CustomExpandedLinkedList<>();
        tailList1.addToTail(12);
        tailList1.addToTail(13);
        tailList1.addToTail(14);
        tailList1.addToTail(15);
        elList.addCustomEListToTail(tailList1);
        elList.printAll();

        // Мой тест. Удалить
        System.out.println("++++++++++++++++++++++++++++++++++++");
        elList = new CustomExpandedLinkedList<>();
        elList.printHead();
        elList.printHeadDelete();
        elList.printTail();
        elList.printTailDelete();
        elList.addToTail(10);
        elList.printTailDelete();
        elList.printAll();
        elList.addToTail(11);
        elList.printTailDelete();
        elList.printAll();
        elList.addToHead(12);
        elList.printHeadDelete();
        elList.printAll();
    }
}
