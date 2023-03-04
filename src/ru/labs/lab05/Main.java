package ru.labs.lab05;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Создание двух матриц размером 1000x1000 с 1000 ненулевых элементов
        Random random = new Random();
        int size = 1000;
        int numNonZeroElements = 1000;

        // Обычная матрица
        UsualMatrix usualMatrix1 = new UsualMatrix(size, size);
        SparseMatrix sparseMatrix1 = new SparseMatrix(size, size);
        for (int i = 0; i < numNonZeroElements; i++) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            double value = random.nextDouble();
            usualMatrix1.setValueAt(row, col, value);
            sparseMatrix1.setValueAt(row, col, value);
        }
        UsualMatrix usualMatrix2 = new UsualMatrix(size, size);
        SparseMatrix sparseMatrix2 = new SparseMatrix(size, size);
        for (int i = 0; i < numNonZeroElements; i++) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            double value = random.nextDouble();
            usualMatrix2.setValueAt(row, col, value);
            sparseMatrix2.setValueAt(row, col, value);
        }

        // Проверка сложения и умножения для обычной и разреженной матриц
        IMatrix sumU = usualMatrix1.add(usualMatrix2);
        IMatrix sumS = sparseMatrix1.add(sparseMatrix2);

        IMatrix productU = usualMatrix1.multiply(usualMatrix2);
        IMatrix productS = sparseMatrix1.multiply(sparseMatrix2);

        System.out.println(sumU.equals(sumS));
        System.out.println(productU.equals(productS));

/*        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (sum.getValueAt(i, j) != usualMatrix1.getValueAt(i, j) + sparseMatrix1.getValueAt(i, j)) {
                    System.out.println("Ошибка в сложении");
                    return;
                }
                double expectedValue = 0;
                for (int k = 0; k < size; k++) {
                    expectedValue += usualMatrix1.getValueAt(i, k) * sparseMatrix1.getValueAt(k, j);
                }
                if (product.getValueAt(i, j) != expectedValue) {
                    System.out.println("Ошибка в умножении");
                    return;
                }
            }
        }
        System.out.println("Операции сложения и умножения для разных видов матриц дают одинаковые результаты");*/
    }
}
