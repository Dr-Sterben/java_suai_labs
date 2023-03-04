package ru.labs.lab02;

public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(2);
        Matrix m2 = m1;
        m1.setElement(0, 0, 1);
        m1.setElement(0, 1, 1);
        m1.setElement(1, 0, 1);
        m1.setElement(1, 1, 0);
        System.out.println(m1);
        for (int i = 0; i < 9; i++){
            m1 = m1.product(m2);
            System.out.println(m1);
        }
        String st = m1.toString();
        System.out.println(st);

        VectorV vV = new VectorV(3);
        for (int i = 0; i < 3; i++)
            vV.setElement(i, i+1);
        Matrix mV = new Matrix(1);
        mV.setElement(0, 0, 2);
        VectorV vVR = vV.product(mV);
        System.out.println(vVR);

        VectorH vH = new VectorH(3);
        for (int i = 0; i < 3; i++)
            vH.setElement(i, i+1);
        Matrix mH = new Matrix(3);
        int tm = 1;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++){
                mH.setElement(i, j, tm++);
            }
        System.out.println(vH);
        System.out.println(mH);
        VectorH vHR = vH.product(mH);
        System.out.println(vHR);
    }
}
//класс вектор с умножением на матр