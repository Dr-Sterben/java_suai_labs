package ru.labs.lab03.matrixes;

public class NonSuitableMatrixException extends Exception {
    private String Message;
    public NonSuitableMatrixException(String message) {
        Message = message;
    }
    public String getMessage() {
        return Message;
    }
}