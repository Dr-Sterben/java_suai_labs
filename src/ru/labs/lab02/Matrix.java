package ru.labs.lab02;

public class Matrix {
    private int n = 0;
    private int[][] matrix = null;

    public Matrix(int n) {
        this.n = n;
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setElement(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public int getElement(int i, int j) {
        return matrix[i][j];
    }

    public Matrix sum(Matrix m) {
        Matrix result = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.setElement(i, j, matrix[i][j] + m.getElement(i, j));
            }
        }
        return result;
    }

    public Matrix product(Matrix m) {
        Matrix result = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += matrix[i][k] * m.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
