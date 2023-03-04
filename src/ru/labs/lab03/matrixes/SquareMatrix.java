package ru.labs.lab03.matrixes;

public class SquareMatrix extends Matrix {
    public SquareMatrix(int n) {
        super(n, n);
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1;
        }
    }
    public SquareMatrix() {
        super();
        matrix[0][0] = 1;
    }
    public SquareMatrix sum(SquareMatrix matrix) {
        if (this.getN() != matrix.getN())
            throw new MatrixExeptions("Wrong sum parameters");
        SquareMatrix result = new SquareMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.setElement(i, j, this.getElement(i, j) + matrix.getElement(i, j));
            }
        }
        return result;
    }

}
