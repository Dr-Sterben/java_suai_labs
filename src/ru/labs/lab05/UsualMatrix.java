package ru.labs.lab05;

public class UsualMatrix implements IMatrix {
    private final int rows;
    private final int columns;
    private final double[][] matrix;

    public UsualMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return columns;
    }

    public double getValueAt(int rowIndex, int columnIndex) {
        return matrix[rowIndex][columnIndex];
    }

    public void setValueAt(int rowIndex, int columnIndex, double value) {
        matrix[rowIndex][columnIndex] = value;
    }

    public IMatrix add(IMatrix other) {
        if (other.getRowCount() != rows || other.getColumnCount() != columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        UsualMatrix result = new UsualMatrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double value = getValueAt(i, j) + other.getValueAt(i, j);
                result.setValueAt(i, j, value);
            }
        }

        return result;
    }

    public IMatrix multiply(IMatrix other) {
        if (columns != other.getRowCount()) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix");
        }

        UsualMatrix result = new UsualMatrix(rows, other.getColumnCount());

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.getColumnCount(); j++) {
                double value = 0;
                for (int k = 0; k < columns; k++) {
                    value += getValueAt(i, k) * other.getValueAt(k, j);
                }
                result.setValueAt(i, j, value);
            }
        }

        return result;
    }

    public Boolean equals(IMatrix other) {
        if (other.getRowCount() != rows || other.getColumnCount() != columns) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (getValueAt(i, j) != other.getValueAt(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}