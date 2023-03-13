package ru.labs.lab05_dop;

public class Usual implements AbstractMatrix {
    private final int rows;
    private final int columns;
    private final int[][] matrix;

    public Usual(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return columns;
    }

    public int getElement(int rowIndex, int columnIndex) {
        return matrix[rowIndex][columnIndex];
    }

    public void setElement(int rowIndex, int columnIndex, int value) {
        matrix[rowIndex][columnIndex] = value;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.append(matrix[i][j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
