package ru.labs.lab05;
public interface IMatrix {
    int getRowCount();
    int getColumnCount();
    double getValueAt(int rowIndex, int columnIndex);
    void setValueAt(int rowIndex, int columnIndex, double value);
    IMatrix add(IMatrix other);
    IMatrix multiply(IMatrix other);
    Boolean equals(IMatrix other);
}
