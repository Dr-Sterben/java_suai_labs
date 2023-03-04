package ru.labs.lab02;

public class VectorV { //вектор nx1
    private int n = 0;
    private int[] vector = null;

    public VectorV(int n) {
        this.n = n;
        vector = new int[n];
    }

    public VectorV() {
        this.n = 1;
        vector = new int[1];
    }
    public void setElement(int i, int v){
        vector[i] = v;
    }

    public VectorV product(Matrix m) { //только на 1x1
        VectorV vector1;
        if (m.getN() != 1) {
            vector1 = new VectorV(1);
        }
        else {
            vector1 = new VectorV(n);
            for (int i = 0; i < n; i++)
                vector1.setElement(i,vector[i]*m.getElement(0, 0));
        }
        return vector1;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
                sb.append(vector[i]);
                sb.append(" ");
            }
            sb.append("\n");
        return sb.toString();
    }
}