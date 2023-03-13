package ru.labs.lab03.matrixes;

public class BadRangeMatrixException extends Exception {
    private String Message;
    public BadRangeMatrixException(String message) {
        Message = message;
    }
    public String getMessage() {
        return Message;
    }
}