package ru.labs.lab02;

public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(2);
        Matrix m2 = m1;
        m1.setElement(0, 0, 1);
        m1.setElement(0, 1, 1);
        m1.setElement(1, 0, 1);
        m1.setElement(1, 1, 0);
        for (int i = 0; i < 9; i++){
            m1 = m1.product(m2);
            System.out.println(m1);
        }
        String st = m1.toString();
        System.out.println(st);
    }
}
