package ru.labs.lab03;

public class SquareMatrix extends Matrix{
    public SquareMatrix(int n) {
        super(n, n);
    }
    public SquareMatrix() {
        super();
    }
    public SquareMatrix sum(SquareMatrix matrix) {
        SquareMatrix result = new SquareMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.setElement(i, j, this.getElement(i, j) + matrix.getElement(i, j));
            }
        }
        return result;
    }

}
