package org.viktsh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Viktor Shvidkiy. Lab 3
 */
public class MainClass {
    public static void main(String[] args) {
        printFile();
        printConsole();
    }

    private static void printConsole () {
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
        System.out.println(lList.getHead());
        //Извлечение значения из начала списка с удалением из списка
        System.out.println("Выводим первый элемент списка и удаляем.");
        System.out.println(lList.getHeadDelete());
        System.out.println("Теперь первый элемент:");
        System.out.println(lList.getHead());
        //Добавление значения в конец списка
        System.out.println("Добавляем в конец 2, 3.");
        lList.addToTail(2);
        lList.addToTail(3);
        //Извлечение значения из конца списка без его удаления
        System.out.println("Последний элемент списка:");
        System.out.println(lList.getTail());
        //Извлечение значения из конца списка с удалением
        System.out.println("Выводим последний элемент списка и удаляем.");
        System.out.println(lList.getTailDelete());
        System.out.println("Теперь последний элемент списка:");
        System.out.println(lList.getTail());
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
        System.out.println(lList.getAll());
        //Удаление заданного значения из списка
        System.out.println("Удаляем значения 100 из списка:");
        lList.deleteValue(100);
        System.out.println(lList.getAll());
        //Выполенине действия, заданного в параметре метода для каждого значения из списка
        System.out.println("Выполняем действие над всеми - выводим на экран, является ли элемент четным:");
        lList.processEach(n -> {
            System.out.print(n + ": ");
            System.out.println(n % 2 == 0);
        });
        System.out.println("Выводим все значения списка:");
        System.out.println(lList.getAll());

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
        System.out.println(tlList.getHead());
        //Извлечение значения из начала списка с удалением из списка
        System.out.println("Выводим первый элемент списка и удаляем.");
        System.out.println(tlList.getHeadDelete());
        System.out.println("Теперь первый элемент:");
        System.out.println(tlList.getHead());
        //Добавление значения в конец списка
        System.out.println("Добавляем в конец 2, 3.");
        tlList.addToTail(2);
        tlList.addToTail(3);
        //Извлечение значения из конца списка без его удаления
        System.out.println("Последний элемент списка:");
        System.out.println(tlList.getTail());
        //Извлечение значения из конца списка с удалением
        System.out.println("Выводим последний элемент списка и удаляем.");
        System.out.println(tlList.getTailDelete());
        System.out.println("Теперь последний элемент списка:");
        System.out.println(tlList.getTail());
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
        System.out.println(tlList.getAll());
        //Удаление заданного значения из списка
        System.out.println("Удаляем значения 100 из списка:");
        tlList.deleteValue(100);
        System.out.println(tlList.getAll());
        //Выполенине действия, заданного в параметре метода для каждого значения из списка
        System.out.println("Выполняем действие над всеми - выводим на экран, является ли элемент четным:");
        tlList.processEach(n -> {
            System.out.print(n + ": ");
            System.out.println(n % 2 == 0);
        });
        System.out.println("Выводим все значения списка:");
        System.out.println(tlList.getAll());
        //Добавление всех значений заданного массива в начало списка с сохранением порядка
        System.out.println("Добавляем значения массива из 3-х чисел (-2, -1, 0) в начало списка:");
        Integer[] arr = {-2, -1, 0};
        tlList.addArrayToHead(arr);
        System.out.println(tlList.getAll());
        //Добавление всех значений заданной коллекции в начало списка с сохранением порядка
        System.out.println("Добавляем коллекцию arrayList из трех элементов (-5, -4, -3) в начало списка:");
        List<Integer> al = new ArrayList<>(Arrays.asList(-5, -4, -3));
        tlList.addIterableToHead(al);
        System.out.println(tlList.getAll());
        System.out.println("Добавляем коллекцию linkedList из трех элементов (-8, -7, -6) в начало списка:");
        List<Integer> ll = new LinkedList<>(Arrays.asList(-8, -7, -6));
        tlList.addIterableToHead(ll);
        System.out.println(tlList.getAll());
        //Добавление всех значений заданного массива/коллекции в конец списка
        System.out.println("Добавляем значения массива из 3-х чисел (6, 7, 8) в конец списка:");
        Integer[] arr1 = {6, 7, 8};
        tlList.addArrayToTail(arr1);
        System.out.println(tlList.getAll());
        System.out.println("Добавляем коллекцию arrayList из трех элементов (9, 10, 11) в конец списка:");
        List<Integer> al1 = new ArrayList<>(Arrays.asList(9, 10, 11));
        tlList.addIterableToTail(al1);
        System.out.println(tlList.getAll());
        System.out.println("Добавляем коллекцию linkedList из трех элементов (12, 13, 14) в конец списка:");
        List<Integer> ll1 = new ArrayList<>(Arrays.asList(12, 13, 14));
        tlList.addIterableToTail(ll1);
        System.out.println(tlList.getAll());
        //Поглощение списка другим списком с добавлением значений второго в начало/конец первого списка
        System.out.println("Поглощение списка. Добавляем список headList со значениями -9, -10, -11 в начало списка:");
        CustomTwoLinkedList<Integer> headList = new CustomTwoLinkedList<>();
        headList.addToTail(-11);
        headList.addToTail(-10);
        headList.addToTail(-9);
        tlList.addCustomTwoLinkedListToHead(headList);
        System.out.println(tlList.getAll());
        System.out.println("Добавляем список tailList со значениями 15, 16, 17 в конец списка:");
        CustomTwoLinkedList<Integer> tailList = new CustomTwoLinkedList<>();
        tailList.addToTail(15);
        tailList.addToTail(16);
        tailList.addToTail(17);
        tlList.addCustomTwoLinkedListToTail(tailList);
        System.out.println(tlList.getAll());
        //Печать всех значений списка в обратном порядке
        System.out.println("Печатаем все значения списка в обратном порядке:");
        System.out.println(tlList.getAllReverse());
        //Выполнение действия, заданного в параметре метода, для каждого значения списка в прямом/обратном порядке
        System.out.println("Инкрементируем все значения на 2 в прямом порядке и выводим в строку:");
        tlList.processEach(n->{n=n+2;
            System.out.print(n+" ");});
        System.out.println("\nИсходный список не изменился");
        System.out.println(tlList.getAll());
        System.out.println("Декрементируем все значения на 2 в обратном порядке:");
        tlList.processEachReverse(n->{n=n-2;
            System.out.print(n+" ");});
        System.out.println("\nИсходный список не изменился");
        System.out.println(tlList.getAll());

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
        System.out.println(elList.getAll());
        //Извлечение значения из начала списка без его удаления
        System.out.println("Первый элемент списка:");
        System.out.println(elList.getHead());
        //Извлечение значения из начала списка с удалением из списка
        System.out.println("Выводим первый элемент списка и удаляем.");
        System.out.println(elList.getHeadDelete());
        System.out.println("Теперь первый элемент:");
        System.out.println(elList.getHead());
        //Добавление значения в конец списка
        System.out.println("Добавляем в конец 5, 6.");
        elList.addToTail(5);
        elList.addToTail(6);
        //Извлечение значения из конца списка без его удаления
        System.out.println("Последний элемент списка:");
        System.out.println(elList.getTail());
        //Извлечение значения из конца списка с удалением
        System.out.println("Выводим последний элемент списка и удаляем.");
        System.out.println(elList.getTailDelete());
        System.out.println("Теперь последний элемент списка:");
        System.out.println(elList.getTail());
        //Определение, содержит ли список заданное значение, или нет
        System.out.println("Содержит ли список значение 1: " + elList.contains(1));
        System.out.println("Содержит ли список значение 10: " + elList.contains(10));
        //Печать всех значений списка
        System.out.print("Все значения списка: ");
        System.out.println(elList.getAll());
        //Определение, является ли список пустым
        System.out.println("Является ли список пустым: " + elList.isEmpty());
        System.out.println("Удаляем все элементы из списка.");
        for (int i = 1; i < 6; i++) elList.deleteValue(i);
        System.out.println("Является ли список пустым: " + elList.isEmpty());
        //Печать всех значений списка
        System.out.println("Все значения списка: ");
        System.out.println(elList.getAll());
        //Удаление заданного значения из списка
        System.out.println("создаем новый список из 100,1,2,100,3,4,5,100");
        for (int i = 1; i <6; i++) {
            if(i==3) elList.addToTail(100);
            elList.addToTail(i);
        }
        System.out.println(elList.getAll());
        elList.addToHead(100);
        elList.addToTail(100);
        System.out.print("Все значения списка: ");
        System.out.println(elList.getAll());
        System.out.println("Удаляем значения 100 из списка:");
        elList.deleteValue(100);
        System.out.println(elList.getAll());
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
        System.out.println(elList.getAll());
        //Добавление всех значений заданной коллекции в начало списка с сохранением порядка
        System.out.println("Добавляем коллекцию arrayList из четырех элементов (-7, -6, -5, -4) в начало списка:");
        List<Integer> alist = new ArrayList<>(Arrays.asList(-7, -6, -5, -4));
        elList.addIterableToHead(alist);
        System.out.println(elList.getAll());
        System.out.println("Добавляем коллекцию linkedList из четырех элементов (-11, -10, -9, -8) в начало списка:");
        List<Integer> llist = new LinkedList<>(Arrays.asList(-11, -10, -9, -8));
        elList.addIterableToHead(llist);
        System.out.println(elList.getAll());
        //Добавление всех значений заданного массива/коллекции в конец списка
        System.out.println("Добавляем значения массива из 2-х чисел (6, 7) в конец списка:");
        Integer[] array1 = {6, 7};
        elList.addArrayToTail(array1);
        System.out.println(elList.getAll());
        System.out.println("Добавляем коллекцию arrayList из двух элементов (8, 9) в конец списка:");
        List<Integer> alist1 = new ArrayList<>(Arrays.asList(8, 9));
        elList.addIterableToTail(alist1);
        System.out.println(elList.getAll());
        System.out.println("Добавляем коллекцию linkedList из двух элементов (10, 11) в конец списка:");
        List<Integer> llist1 = new ArrayList<>(Arrays.asList(10, 11));
        elList.addIterableToTail(llist1);
        System.out.println(elList.getAll());
        //Поглощение списка другим списком с добавлением значений второго в начало/конец первого списка
        System.out.println("Добавляем список headList со значениями -12, -13, -14, -15 в начало списка:");
        CustomExpandedLinkedList<Integer> headList1 = new CustomExpandedLinkedList<>();
        headList1.addToTail(-15);
        headList1.addToTail(-14);
        headList1.addToTail(-13);
        headList1.addToTail(-12);
        elList.addCustomEListToHead(headList1);
        System.out.println(elList.getAll());
        System.out.println("Добавляем список tailList со значениями 12, 13, 14, 15 в конец списка:");
        CustomExpandedLinkedList<Integer> tailList1 = new CustomExpandedLinkedList<>();
        tailList1.addToTail(12);
        tailList1.addToTail(13);
        tailList1.addToTail(14);
        tailList1.addToTail(15);
        elList.addCustomEListToTail(tailList1);
        System.out.println(elList.getAll());
    }

    private static void printFile() {
        String filename = System.getenv().getOrDefault("REPORT_FILE_PATH", "report.md");
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.printf("## Односвязный список%n");
            writer.printf("Создаем односвязный список.%n");
            CustomList<Integer> lList = new CustomLinkedList<>();
            //Добавление значения в начало списка
            writer.printf("Добавляем в начало *2, 1, 0*%n");
            for (int i = 2; i >= 0; i--) lList.addToHead(i);
            //Извлечение значения из начала списка без его удаления
            writer.printf("Первый элемент списка: **%s**%n", lList.getHead());
            //Извлечение значения из начала списка с удалением из списка
            writer.printf("Выводим первый элемент списка и удаляем: **%s**%n", lList.getHeadDelete());
            writer.printf("Теперь первый элемент: **%s**%n", lList.getHead());
            //Добавление значения в конец списка
            writer.printf("Добавляем в конец *2, 3*%n");
            lList.addToTail(2);
            lList.addToTail(3);
            //Извлечение значения из конца списка без его удаления
            writer.printf("Последний элемент списка: **%s**%n", lList.getTail());
            //Извлечение значения из конца списка с удалением
            writer.printf("Выводим последний элемент списка и удаляем: **%s**%n", lList.getTailDelete());
            writer.printf("Теперь последний элемент списка: **%s**%n", lList.getTail());
            //Определение, содержит ли список заданное значение, или нет
            writer.printf("Содержит ли список значение *1*: **%s**%n", lList.contains(1));
            writer.printf("Содержит ли список значение *10*: **%s**%n", lList.contains(10));
            //Определение, является ли список пустым
            writer.printf("Является ли список пустым: **%s**%n", lList.isEmpty());
            writer.printf("Удаляем оба элемента из списка.%n");
            lList.deleteValue(1);
            lList.deleteValue(2);
            writer.printf("Является ли список пустым: **%s**%n", lList.isEmpty());
            //Печать всех значений списка
            writer.printf("Добавляем новые элементы.%n");
            lList.addToHead(100);
            lList.addToTail(4);
            lList.addToHead(3);
            lList.addToTail(5);
            lList.addToHead(2);
            lList.addToTail(100);
            lList.addToHead(1);
            lList.addToHead(100);
            writer.printf("Выводим все значения списка: **%s**%n", lList.getAll());
            //Удаление заданного значения из списка
            lList.deleteValue(100);
            writer.printf("Удаляем значения 100 из списка: **%s**%n", lList.getAll());
            //Выполенине действия, заданного в параметре метода для каждого значения из списка
            writer.printf("Выполняем действие над всеми - выводим на экран, является ли элемент четным.%n");
            lList.processEach(n -> {
                writer.printf("**%s** : **%s**%n", n, n % 2 == 0);
            });
            writer.printf("Выводим все значения списка: **%s**%n", lList.getAll());
            writer.printf("---%n");

            writer.printf("## Двусвязный список%n");
            writer.printf("Создаем двусвязный список.%n");
            CustomTwoLinkedList<Integer> tlList = new CustomTwoLinkedList<>();
            //Добавление значения в начало списка
            writer.printf("Добавляем в начало *2, 1, 0*%n");
            for (int i = 2; i >= 0; i--) tlList.addToHead(i);
            //Извлечение значения из начала списка без его удаления
            writer.printf("Первый элемент списка: **%s**%n", tlList.getHead());
            //Извлечение значения из начала списка с удалением из списка
            writer.printf("Выводим первый элемент списка и удаляем: **%s**%n", tlList.getHeadDelete());
            writer.printf("Теперь первый элемент: **%s**%n", tlList.getHead());
            //Добавление значения в конец списка
            writer.printf("Добавляем в конец *2, 3*%n");
            tlList.addToTail(2);
            tlList.addToTail(3);
            //Извлечение значения из конца списка без его удаления
            writer.printf("Последний элемент списка: **%s**%n", tlList.getTail());
            //Извлечение значения из конца списка с удалением
            writer.printf("Выводим последний элемент списка и удаляем: **%s**%n", tlList.getTailDelete());
            writer.printf("Теперь последний элемент списка: **%s**%n", tlList.getTail());
            //Определение, содержит ли список заданное значение, или нет
            writer.printf("Содержит ли список значение *1*: **%s**%n", tlList.contains(1));
            writer.printf("Содержит ли список значение *10*: **%s**%n", tlList.contains(10));
            //Определение, является ли список пустым
            writer.printf("Является ли список пустым: **%s**%n", tlList.isEmpty());
            writer.printf("Удаляем оба элемента из списка.%n");
            tlList.deleteValue(1);
            tlList.deleteValue(2);
            writer.printf("Является ли список пустым: **%s**%n", tlList.isEmpty());
            //Печать всех значений списка
            writer.printf("Добавляем новые элементы.");
            tlList.addToHead(100);
            tlList.addToTail(4);
            tlList.addToHead(3);
            tlList.addToTail(5);
            tlList.addToHead(2);
            tlList.addToTail(100);
            tlList.addToHead(1);
            tlList.addToHead(100);
            writer.printf("Выводим все значения списка: **%s**%n", tlList.getAll());
            //Удаление заданного значения из списка
            tlList.deleteValue(100);
            writer.printf("Удаляем значения *100* из списка: **%s**%n", tlList.getAll());
            //Выполенине действия, заданного в параметре метода для каждого значения из списка
            writer.printf("Выполняем действие над всеми - выводим на экран, является ли элемент четным:%n");
            tlList.processEach(n -> {
                writer.printf("**%s** : **%s**%n", n, n % 2 == 0);
            });
            writer.printf("Выводим все значения списка:%n**%s**%n", tlList.getAll());
            //Добавление всех значений заданного массива в начало списка с сохранением порядка
            writer.printf("Добавляем значения массива из 3-х чисел (*-2, -1, 0*) в начало списка.%n");
            Integer[] arr = {-2, -1, 0};
            tlList.addArrayToHead(arr);
            writer.printf("Выводим все значения списка:%n**%s**%n", tlList.getAll());
            //Добавление всех значений заданной коллекции в начало списка с сохранением порядка
            writer.printf("Добавляем коллекцию ArrayList из трех элементов (*-5, -4, -3*) в начало списка.%n");
            List<Integer> al = new ArrayList<>(Arrays.asList(-5, -4, -3));
            tlList.addIterableToHead(al);
            writer.printf("Выводим все значения списка:%n**%s**%n", tlList.getAll());
            writer.printf("Добавляем коллекцию LinkedList из трех элементов (*-8, -7, -6*) в начало списка.%n");
            List<Integer> ll = new LinkedList<>(Arrays.asList(-8, -7, -6));
            tlList.addIterableToHead(ll);
            writer.printf("Выводим все значения списка:%n**%s**%n", tlList.getAll());
            //Добавление всех значений заданного массива/коллекции в конец списка
            writer.printf("Добавляем значения массива из 3-х чисел (*6, 7, 8*) в конец списка.%n");
            Integer[] arr1 = {6, 7, 8};
            tlList.addArrayToTail(arr1);
            writer.printf("Выводим все значения списка:%n**%s**%n", tlList.getAll());
            writer.printf("Добавляем коллекцию arrayList из трех элементов (*9, 10, 11*) в конец списка.%n");
            List<Integer> al1 = new ArrayList<>(Arrays.asList(9, 10, 11));
            tlList.addIterableToTail(al1);
            writer.printf("Выводим все значения списка:%n**%s**%n", tlList.getAll());
            writer.printf("Добавляем коллекцию linkedList из трех элементов (*12, 13, 14*) в конец списка.%n");
            List<Integer> ll1 = new ArrayList<>(Arrays.asList(12, 13, 14));
            tlList.addIterableToTail(ll1);
            writer.printf("Выводим все значения списка:%n**%s**%n", tlList.getAll());
            //Поглощение списка другим списком с добавлением значений второго в начало/конец первого списка
            writer.printf("Поглощение списка. Добавляем список headList из трех элементов (*-9, -10, -11*) в начало списка.%n");
            CustomTwoLinkedList<Integer> headList = new CustomTwoLinkedList<>();
            for(int i = -11; i<-8; i++){
                headList.addToTail(i);
            }
            tlList.addCustomTwoLinkedListToHead(headList);
            writer.printf("Выводим все значения списка:%n**%s**%n", tlList.getAll());
            writer.printf("Добавляем список tailList из трех элементов (*15, 16, 17*) в конец списка.%n");
            CustomTwoLinkedList<Integer> tailList = new CustomTwoLinkedList<>();
            for(int i = 15; i<18; i++){
                tailList.addToTail(i);
            }
            tlList.addCustomTwoLinkedListToTail(tailList);
            writer.printf("Выводим все значения списка:%n**%s**%n", tlList.getAll());
            //Печать всех значений списка в обратном порядке
            writer.printf("Все значения списка в обратном порядке:%n**%s**%n",tlList.getAllReverse());
            //Выполнение действия, заданного в параметре метода, для каждого значения списка в прямом/обратном порядке
            writer.printf("Инкрементируем все значения на 2 в прямом порядке и выводим в строку:%n");
            tlList.processEach(n->{
                n=n+2;
                writer.printf("**%s** ", n);
            });
            writer.printf("%nИсходный список не изменился:%n**%s**%n", tlList.getAll());
            writer.printf("Декрементируем все значения на 2 в обратном порядке:%n");
            tlList.processEachReverse(n->{
                n=n-2;
                writer.printf("**%s** ", n);
            });
            writer.printf("%nИсходный список не изменился:%n**%s**%n", tlList.getAll());
            writer.printf("---%n");

            writer.printf("## Развернутый односвязный список%n");
            writer.printf("Создаем развернутый односвязный список.%n");
            CustomExpandedLinkedList<Integer> elList = new CustomExpandedLinkedList<>();
            //Добавление значения в начало списка
            writer.printf("Добавляем в начало *4, 3, 2, 1, 0*.%n");
            for (int i = 4; i >= 0; i--) {
                elList.addToHead(i);
            }
            writer.printf("Выводим все значения списка: **%s**%n",elList.getAll());
            //Извлечение значения из начала списка без его удаления
            writer.printf("Первый элемент списка: **%s**%n", elList.getHead());
            //Извлечение значения из начала списка с удалением из списка
            writer.printf("Выводим первый элемент списка и удаляем: **%s**%n", elList.getHeadDelete());
            writer.printf("Теперь первый элемент: **%s**%n", elList.getHead());
            //Добавление значения в конец списка
            writer.printf("Добавляем в конец списка *5, 6*.%n");
            elList.addToTail(5);
            elList.addToTail(6);
            //Извлечение значения из конца списка без его удаления
            writer.printf("Последний элемент списка: **%s**%n", elList.getTail());
            //Извлечение значения из конца списка с удалением
            writer.printf("Выводим последний элемент списка и удаляем: **%s**%n", elList.getTailDelete());
            writer.printf("Теперь последний элемент списка: **%s**%n", elList.getTail());
            //Определение, содержит ли список заданное значение, или нет
            writer.printf("Содержит ли список значение 1: **%s**%n", elList.contains(1));
            writer.printf("Содержит ли список значение 10: **%s**%n", elList.contains(10));
            //Печать всех значений списка
            writer.printf("Все значения списка: **%s**%n", elList.getAll());
            //Определение, является ли список пустым
            writer.printf("Является ли список пустым: **%s**%n", elList.isEmpty());
            writer.printf("Удаляем все элементы из списка.%n");
            for (int i = 1; i < 6; i++) elList.deleteValue(i);
            writer.printf("Является ли список пустым: **%s**%n", elList.isEmpty());
            //Печать всех значений списка
            writer.printf("Все значения списка: **%s**%n", elList.getAll());
            //Удаление заданного значения из списка
            writer.printf("Cоздаем новый список из *100, 1, 2, 100, 3, 4, 5, 100*.%n");
            for (int i = 1; i <6; i++) {
                if(i==1 || i==3 || i == 5) elList.addToTail(100);
                elList.addToTail(i);
            }
            writer.printf("Все значения списка: **%s**%n", elList.getAll());
            elList.deleteValue(100);
            writer.printf("Удаляем значения 100 из списка: **%s**%n", elList.getAll());
            //Выполнение действия, заданного в параметре метода, для каждого значения списка
            writer.printf("Выполняем действие над всеми - выводим на экран, является ли элемент четным:%n");
            elList.processEach(n -> {
                writer.printf("**%s** : **%s**%n", n, n % 2 == 0);
            });
            //Добавление всех значений заданного массива в начало списка с сохранением порядка
            writer.printf("Добавляем значения массива из 4-х чисел (*-3, -2, -1, 0*) в начало списка.%n");
            Integer[] array = {-3, -2, -1, 0};
            elList.addArrayToHead(array);
            writer.printf("Выводим все значения списка:%n**%s**%n", elList.getAll());
            //Добавление всех значений заданной коллекции в начало списка с сохранением порядка
            writer.printf("Добавляем коллекцию ArrayList из четырех элементов (*-7, -6, -5, -4*) в начало списка.%n");
            List<Integer> alist = new ArrayList<>(Arrays.asList(-7, -6, -5, -4));
            elList.addIterableToHead(alist);
            writer.printf("Выводим все значения списка:%n**%s**%n", elList.getAll());
            writer.printf("Добавляем коллекцию LinkedList из четырех элементов (*-11, -10, -9, -8*) в начало списка.%n");
            List<Integer> llist = new LinkedList<>(Arrays.asList(-11, -10, -9, -8));
            elList.addIterableToHead(llist);
            writer.printf("Выводим все значения списка:%n**%s**%n", elList.getAll());
            //Добавление всех значений заданного массива/коллекции в конец списка
            writer.printf("Добавляем значения массива из 2-х чисел (*6, 7*) в конец списка.%n");
            Integer[] array1 = {6, 7};
            elList.addArrayToTail(array1);
            writer.printf("Выводим все значения списка:%n**%s**%n", elList.getAll());
            writer.printf("Добавляем коллекцию arrayList из двух элементов (*8, 9*) в конец списка.%n");
            List<Integer> alist1 = new ArrayList<>(Arrays.asList(8, 9));
            elList.addIterableToTail(alist1);
            writer.printf("Выводим все значения списка:%n**%s**%n", elList.getAll());
            writer.printf("Добавляем коллекцию linkedList из двух элементов (*10, 11*) в конец списка.%n");
            List<Integer> llist1 = new ArrayList<>(Arrays.asList(10, 11));
            elList.addIterableToTail(llist1);
            writer.printf("Выводим все значения списка:%n**%s**%n", elList.getAll());
            //Поглощение списка другим списком с добавлением значений второго в начало/конец первого списка
            writer.printf("Добавляем список headList из четырех элементов (*-12, -13, -14, -15*) в начало списка.%n");
            CustomExpandedLinkedList<Integer> headList1 = new CustomExpandedLinkedList<>();
            for(int i = -15; i<-11; i++){
                headList1.addToTail(i);
            }
            elList.addCustomEListToHead(headList1);
            writer.printf("Выводим все значения списка:%n**%s**%n", elList.getAll());
            writer.printf("Добавляем список tailList из четырех элементов (*12, 13, 14, 15*) в конец списка.%n");
            CustomExpandedLinkedList<Integer> tailList1 = new CustomExpandedLinkedList<>();
            for (int i = 12; i<16; i++) {
                tailList1.addToTail(i);
            }
            elList.addCustomEListToTail(tailList1);
            writer.printf("Выводим все значения списка:%n**%s**%n", elList.getAll());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
