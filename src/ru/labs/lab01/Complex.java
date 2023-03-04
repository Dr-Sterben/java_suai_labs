package ru.labs.lab01;

public class Complex {
    private int real = 0;
    private int img = 0;

    public Complex(int a, int b){this.real = a; this.img = b;}
    public Complex(int a){this(a,0);}
    public Complex(){this(0,0);}
    public int getReal(){return real;}
    public int getImg(){return img;}
    public void add(int a, int b){
        real += a;
        img += b;
    }
    public void add(Complex a){
        real += a.getReal();
        img += a.getImg();
    }
    public void mult(int a, int b){
        int tmp = real;
        real = real*a - img*b;
        img = img*a + tmp*b;
    }
    public void mult(Complex a){
        int tmp = real;
        real = real*a.getReal() - img*a.getImg();
        img = img*a.getReal() + tmp*a.getImg();
    }

    public String toString(){
        return "" + real + "+" + img + "i";
    }
}
