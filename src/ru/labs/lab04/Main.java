package ru.labs.lab04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int tstInt = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        tstInt = in.nextInt();
        if (tstInt == 0) {
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
        else {
            SortedIntegerListEdit listE = new SortedIntegerListEdit(true, true);
            listE.add(3);
            listE.add(1);
            listE.add(10);

            System.out.println(listE.toString());
            listE.reverse();
            System.out.println(listE.toString());
        }
    }
}
