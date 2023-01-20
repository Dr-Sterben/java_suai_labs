package ru.labs.lab01;

public class Int {
    private int n = 0;

    public Int(int n) {
        this.n = n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int get() {
        return n;
    }

    public void increment() {
        n++;
    }

    public void decrement() {
        n--;
    }

    public void add(int n) {
        this.n += n;
    }

    public void subtract(int n) {
        this.n -= n;
    }

    public String toString() {
        //return Integer.toString(n);
        return "" + n;
    }
}