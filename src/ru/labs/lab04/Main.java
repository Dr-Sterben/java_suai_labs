package ru.labs.lab04;

public class Main {
    public static void main(String[] args) {
        SortedIntegerList list1 = new SortedIntegerList(false);
        SortedIntegerList list2 = new SortedIntegerList(true);

        // Test adding elements
        list1.add(3);
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(1); // Duplicate, should not be added

        list2.add(3);
        list2.add(1);
        list2.add(2);
        list2.add(4);
        list2.add(1); // Duplicate, should be added

        System.out.println(list1.toString());
        System.out.println(list2.toString());

        list2.remove(1);
        System.out.println(list2.toString());
        list2.remove(4);
        System.out.println(list2.toString());


        System.out.println(list1.equals(list2));

    }
}
