package ru.labs.lab03.matrixes;

public class MatrixExeptions extends RuntimeException{
    private String Message;
    public MatrixExeptions(String message) {
        Message = message;
    }
    public String getMessage() {
        return Message;
    }

}
