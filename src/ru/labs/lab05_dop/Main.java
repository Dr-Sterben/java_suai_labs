package ru.labs.lab05_dop;

public class Main {
    public static void main(String[] args) {
        Usual usual = new Usual(2, 2);
        usual.setElement(0, 0, 1);
        usual.setElement(0, 1, 2);
        usual.setElement(1, 0, 3);
        usual.setElement(1, 1, 4);
        Sparse sparse = new Sparse(2, 2);
        sparse.setElement(0, 0, 1);
        sparse.setElement(0, 1, 2);
        sparse.setElement(1, 0, 3);
        sparse.setElement(1, 1, 4);
        System.out.println(usual);
        System.out.println(sparse);
        System.out.println(usual.sum(sparse));
        System.out.println(usual.product(sparse));
    }
}
