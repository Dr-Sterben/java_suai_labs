package ru.labs.lab02;

public class VectorH { //вектор 1*n
    private int n = 0;
    private int[] vector = null;

    public VectorH(int n) {
        this.n = n;
        vector = new int[n];
    }

    public VectorH() {
        this.n = 1;
        vector = new int[1];
    }
    public void setElement(int i, int v){
        vector[i] = v;
    }
    public int getElement(int i){
        return vector[i];
    }
    public VectorH product(Matrix m) {
        VectorH vv;
        if (m.getN() != n) {
            vv = new VectorH(1);
            vv.setElement(0, -1);
        }
        else {
            vv = new VectorH(n);
            for (int i = 0; i < n; i++){
                int sum = 0;
                for (int j = 0; j < n;j++)
                    sum += vector[j]*m.getElement(j, i);
                vv.setElement(i, sum);
            }
        }
        return vv;
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
    public void reset(){
        for (int i = 0; i < n; i++)
            vector[i] = 0;
    }
}
