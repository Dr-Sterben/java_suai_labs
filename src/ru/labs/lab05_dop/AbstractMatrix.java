package ru.labs.lab05_dop;

public interface AbstractMatrix {
    int getRowCount();
    int getColumnCount();
    int getElement(int rowIndex, int columnIndex);
    void setElement(int rowIndex, int columnIndex, int value);
    default Usual sum(AbstractMatrix other) {
        if (other.getRowCount() != getRowCount() || other.getColumnCount() != getColumnCount()) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        Usual result = new Usual(getRowCount(), getColumnCount());
        for (int i = 0; i < getRowCount(); i++) {
            for (int j = 0; j < getColumnCount(); j++) {
                int value = getElement(i, j) + other.getElement(i, j);
                result.setElement(i, j, value);
            }
        }
        return result;
    };
    default Usual product(AbstractMatrix other) {
        if (getColumnCount() != other.getRowCount()) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix");
        }
        Usual result = new Usual(getRowCount(), other.getColumnCount());
        for (int i = 0; i < getRowCount(); i++) {
            for (int j = 0; j < other.getColumnCount(); j++) {
                int value = 0;
                for (int k = 0; k < getColumnCount(); k++) {
                    value += getElement(i, k) * other.getElement(k, j);
                }
                result.setElement(i, j, value);
            }
        }
        return result;
    };
    String toString();
}
