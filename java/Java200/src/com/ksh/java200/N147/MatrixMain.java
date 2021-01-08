package com.ksh.java200.N147;

import com.ksh.java200.N145.Matrix;

public class MatrixMain {
    public static void main(String[] args){
        double [][] basic = {{2,3,1}, {4,1,-3}, {-1,2,2}};
        double [][] y = {{-4}, {-2}, {2}};
        Matrix A = new Matrix(basic);
        A.print();
        Matrix  Y = new Matrix(y);
        Y.print();
        Matrix A_1 = MatrixUtil.revMatrix(A);
        A_1.print();
        Matrix X = com.ksh.java200.N146.MatrixUtil.mulMatrix(A_1, Y);
        X.print();
    }
}
