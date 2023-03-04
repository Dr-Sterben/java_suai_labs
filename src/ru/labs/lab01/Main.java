package ru.labs.lab01;

public class Main {
    public static void main(String[] args) {
        Int tst = new Int(0);
        System.out.println(tst.get());
        tst.increment();
        tst.subtract(5);
        System.out.println(tst.get());
        Int tst2 = new Int(1000);
        Int tst4 = new Int(0);
        System.out.println(tst2.toString());

        Complex cm = new Complex(2, 3);
        System.out.println(cm.toString());
        cm.add(2, -2);
        System.out.println(cm.toString());
        cm.mult(-3, 2);
        System.out.println(cm.toString());
    }
}
//показать 1000
//доп класс для работы с комплексными числами (Complex) только add и mult