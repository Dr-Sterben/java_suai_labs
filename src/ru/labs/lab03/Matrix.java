package ru.labs.lab03;

public class Matrix {
    protected int n;
    protected int m;
    protected int[][] matrix = null;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        matrix = new int[n][m];
    }
    public Matrix(int n) {
        this(n, n);
    }
    public Matrix() {
        this(1, 1);
    }

    public int getN() {
        return n;
    }
    public int getM() {
        return m;
    }
    public void setElement(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public int getElement(int i, int j) {
        return matrix[i][j];
    }

    public Matrix sum(Matrix matrix) {
        if (this.n != matrix.getN() || this.m != matrix.getM()) {
            throw new MatrixExeptions("Wrong sum parameters");
        }
        Matrix result = new Matrix(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.setElement(i, j, this.getElement(i, j) + matrix.getElement(i, j));
            }
        }
        return result;
    }

    public Matrix product(Matrix m2) {
        if (this.m != m2.getN()) {
            throw new MatrixExeptions("Wrong product parameters");
        }
        Matrix result = new Matrix(n, m2.getM());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m2.m; j++) {
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += this.getElement(i, k) * m2.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.append(matrix[i][j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

}
