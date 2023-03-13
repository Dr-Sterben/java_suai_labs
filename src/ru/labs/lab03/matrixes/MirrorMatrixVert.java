package ru.labs.lab03.matrixes;

public class MirrorMatrixVert {
    protected int n = 0;
    protected int m = 0;
    protected int[][] matrix = null;
    public MirrorMatrixVert(int n, int m){
        this.n = n;
        this.m = m;
        matrix = new int[n][m/2 + m%2];
    }
    public MirrorMatrixVert(int n){
        this(n, n);
    }
    public MirrorMatrixVert(){
        this(1, 1);
    }
    public int getN(){
        return n;
    }
    public int getM(){
        return m;
    }
    public void setElement(int i, int j, int value) throws BadRangeMatrixException {
        if (i >= n || j >= m) {
            throw new BadRangeMatrixException("Bad range");
        }
        if (j >= m/2) {
            matrix[i][m - j - 1] = value;
        } else {
            matrix[i][j] = value;
        }
    }
    public int getElement(int i, int j) throws BadRangeMatrixException {
        if (i >= n || j >= m) {
            throw new BadRangeMatrixException("Bad range");
        }
        if (j >= m/2) {
            return matrix[i][m - j - 1];
        } else {
            return matrix[i][j];
        }
    }
    public MirrorMatrixVert sum(MirrorMatrixVert matrix) throws NonSuitableMatrixException, BadRangeMatrixException {
        if (this.n != matrix.getN() || this.m != matrix.getM()) {
            throw new NonSuitableMatrixException("Wrong sum parameters");
        }
        MirrorMatrixVert result = new MirrorMatrixVert(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.setElement(i, j, this.getElement(i, j) + matrix.getElement(i, j));
            }
        }
        return result;
    }
    public MirrorMatrixVert product(MirrorMatrixVert m2) throws NonSuitableMatrixException, BadRangeMatrixException {
        if (this.m != m2.getN()) {
            throw new NonSuitableMatrixException("Wrong product parameters");
        }
        MirrorMatrixVert result = new MirrorMatrixVert(this.n, m2.getM());
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < m2.getM(); j++) {
                int sum = 0;
                for (int k = 0; k < this.m; k++) {
                    sum += this.getElement(i, k) * m2.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }
    public String toString() {
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                try {
                    result += this.getElement(i, j) + " ";
                } catch (BadRangeMatrixException e) {
                    e.printStackTrace();
                }
            }
            result += "\n";
        }
        return result;
    }
}
