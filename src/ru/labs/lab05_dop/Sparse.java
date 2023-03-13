package ru.labs.lab05_dop;

import ru.labs.lab05.SparseMatrix;

import java.util.*;

import java.util.LinkedList;

public class Sparse implements AbstractMatrix {
    private final int rows;
    private final int columns;
    private final LinkedList<Sparse.SparseElement>[] matrix;
    public Sparse(int rows, int columns) {
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
    public int getElement(int rowIndex, int columnIndex) {
        for (Sparse.SparseElement element : matrix[rowIndex]) {
            if (element.columnIndex == columnIndex) {
                return element.value;
            }
        }
        return 0;
    }
    public void setElement(int rowIndex, int columnIndex, int value) {
        for (Sparse.SparseElement element : matrix[rowIndex]) {
            if (element.columnIndex == columnIndex) {
                element.value = value;
                return;
            }
        }
        matrix[rowIndex].add(new Sparse.SparseElement(columnIndex, value));
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.append(getElement(i, j)).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    private static class SparseElement {
        int columnIndex;
        int value;

        SparseElement(int columnIndex, int value) {
            this.columnIndex = columnIndex;
            this.value = value;
        }
    }
}
