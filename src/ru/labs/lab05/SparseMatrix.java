package ru.labs.lab05;

import java.util.*;
public class SparseMatrix implements IMatrix {
    private final int rows;
    private final int columns;
    private final LinkedList<SparseMatrixElement>[] matrix;

    public SparseMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new LinkedList[rows];

        for (int i = 0; i < rows; i++) {
            matrix[i] = new LinkedList<>();
        }
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return columns;
    }

    public double getValueAt(int rowIndex, int columnIndex) {
        for (SparseMatrixElement element : matrix[rowIndex]) {
            if (element.columnIndex == columnIndex) {
                return element.value;
            }
        }
        return 0;
    }

    public void setValueAt(int rowIndex, int columnIndex, double value) {
        if (value == 0) {
            removeElement(rowIndex, columnIndex);
        } else {
            setElement(rowIndex, columnIndex, value);
        }
    }

    private void setElement(int rowIndex, int columnIndex, double value) {
        for (SparseMatrixElement element : matrix[rowIndex]) {
            if (element.columnIndex == columnIndex) {
                element.value = value;
                return;
            }
        }
        matrix[rowIndex].add(new SparseMatrixElement(columnIndex, value));
    }

    private void removeElement(int rowIndex, int columnIndex) {
        Iterator<SparseMatrixElement> iterator = matrix[rowIndex].iterator();
        while (iterator.hasNext()) {
            SparseMatrixElement element = iterator.next();
            if (element.columnIndex == columnIndex) {
                iterator.remove();
                return;
            }
        }
    }

    public IMatrix add(IMatrix other) {
        if (other.getRowCount() != rows || other.getColumnCount() != columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        SparseMatrix result = new SparseMatrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (SparseMatrixElement element : matrix[i]) {
                double value = element.value + other.getValueAt(i, element.columnIndex);
                result.setElement(i, element.columnIndex, value);
            }
            for (int j = 0; j < columns; j++) {
                double value = other.getValueAt(i, j);
                if (getValueAt(i, j) == 0 && value != 0) {
                    result.setElement(i, j, value);
                }
            }
        }

        return result;
    }

    public IMatrix multiply(IMatrix other) {
        if (columns != other.getRowCount()) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix");
        }

        SparseMatrix result = new SparseMatrix(rows, other.getColumnCount());

        for (int i = 0; i < rows; i++) {
            for (SparseMatrixElement element : matrix[i]) {
                for (int j = 0; j < other.getColumnCount(); j++) {
                    double value = element.value * other.getValueAt(element.columnIndex, j);
                    result.setElement(i, j, result.getValueAt(i, j) + value);
                }
            }
        }

        return result;
    }

    public Boolean equals(IMatrix other) {
        if (other.getRowCount() != rows || other.getColumnCount() != columns) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (SparseMatrixElement element : matrix[i]) {
                if (element.value != other.getValueAt(i, element.columnIndex)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static class SparseMatrixElement {
        int columnIndex;
        double value;

        SparseMatrixElement(int columnIndex, double value) {
            this.columnIndex = columnIndex;
            this.value = value;
        }
    }
}
