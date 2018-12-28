package com.ksh.java200.N147;

import com.ksh.java200.N145.Matrix;

public class MatrixUtil {
    public static Matrix revMatrix(Matrix a ){
        double [][] matricex = a.getMatrix();
        double [][] matrices = new double[matricex.length][matricex[0].length*2];

        for (int i = 0; i < matricex.length; i++) {
            for (int j = 0; j < matricex[i].length; j++) {
                matrices[i][j] = matricex[i][j];
            }
        }

        for (int i = 0; i < matricex.length; i++) {
            matrices[i][i+matricex[i].length] = 1.0;
        }

        int row = matrices.length;
        int col = matrices[0].length;
        for (int k = 0; k < row; k++) {
            double max = 0.0;
            int pivotRow = k;
            for (int j = k; j < row;     j++) {
                double tempMAx = Math.abs(matrices[j][j]);
                if(max < tempMAx){
                    max = tempMAx;
                    pivotRow = j;
                }

            }
            if(k!= pivotRow){
                for (int j = 0; j < col; j++) {
                    double temp = matrices[k][j];
                    matrices[k][j] = matrices[pivotRow][j];
                    matrices[pivotRow][j] = temp;
                }
            }
            
            double pivot = matrices[k][k];
            for (int j = k; j < col; j++) {
                matrices[k][j] /= pivot;
                
            }
            for (int j = 0; j < row; j++) {
                if(j!=k){
                    double delta = matrices[j][k];
                    for (int i = k; i <col ; i++) {
                        matrices[j][i] -= delta*matrices[k][i];
                    }
                }
            }
        }


        double[][] results = new double[matricex.length][matricex.length];
        for (int i = 0; i < matricex.length; i++) {
            for (int j = 0; j < matricex[i].length; j++) {
                results[i][j] = matrices[i][j+matricex[i].length];
            }
        }
        return new Matrix(results);
    }
}
