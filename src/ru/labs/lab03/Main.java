package ru.labs.lab03;

public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(2, 3);
        Matrix m2 = new Matrix(3, 2);
        m1.setElement(0, 0, 1);
        m1.setElement(0, 1, 2);
        m1.setElement(0, 2, 3);
        m1.setElement(1, 0, 4);
        m1.setElement(1, 1, 5);
        m1.setElement(1, 2, 6);
        m2.setElement(0, 0, 7);
        m2.setElement(0, 1, 8);
        m2.setElement(1, 0, 9);
        m2.setElement(1, 1, 10);
        m2.setElement(2, 0, 11);
        m2.setElement(2, 1, 12);
        System.out.println(m1);
        System.out.println(m2);
        try {
            System.out.println(m1.sum(m2));
        } catch (MatrixExeptions e) {
            System.out.println(e.getMessage() + "\n");
        }
        System.out.println(m1.product(m2));
        SquareMatrix sm1 = new SquareMatrix(2);
        SquareMatrix sm2 = new SquareMatrix(2);
        sm1.setElement(0, 0, 1);
        sm1.setElement(0, 1, 2);
        sm1.setElement(1, 0, 3);
        sm1.setElement(1, 1, 4);
        sm2.setElement(0, 0, 5);
        sm2.setElement(0, 1, 6);
        sm2.setElement(1, 0, 7);
        sm2.setElement(1, 1, 8);
        System.out.println(sm1);
        System.out.println(sm2);
        System.out.println(sm1.sum(sm2));
        System.out.println(sm1.product(sm2));
    }
}
