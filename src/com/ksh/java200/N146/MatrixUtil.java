package com.ksh.java200.N146;

import com.ksh.java200.N145.Matrix;
import com.ksh.java200.N145.MatrixMain;

public class MatrixUtil {
    public static Matrix addMatrix(Matrix a, Matrix b){
        int m = a.getMatrix().length;
        int n = a.getMatrix()[0].length;
        double[][] c = new double[m][n];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a.getMatrix()[i][j]+b.getMatrix()[i][j];
            }

        }

        return new Matrix(c);
    }

    public static Matrix diffMatric(Matrix a , Matrix b){
        int m = a.getMatrix().length;
        int n = a.getMatrix()[0].length;
        double [][] c = new double[m][n];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a.getMatrix()[i][j]-b.getMatrix()[i][j];
            }
        }
        return new Matrix(c);
    }
    public static Matrix mulMatrix(Matrix a, Matrix b){
        int m = a.getMatrix().length;
        int n = a.getMatrix()[0].length;
        int p = b.getMatrix()[0].length;
        double[][] c = new double[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] = a.getMatrix()[i][j]*b.getMatrix()[i][j];
                }

            }
        }

        return new Matrix(c);
    }
}
