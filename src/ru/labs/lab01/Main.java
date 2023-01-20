package ru.labs.lab01;

public class Main {
    public static void main(String[] args) {
        Int tst = new Int(0);
        System.out.println(tst.get());
        tst.increment();
        tst.subtract(5);
        System.out.println(tst.get());
    }
}