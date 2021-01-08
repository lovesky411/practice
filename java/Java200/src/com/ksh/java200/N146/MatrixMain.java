package com.ksh.java200.N146;

import com.ksh.java200.N145.Matrix;

import javax.swing.text.MutableAttributeSet;

public class MatrixMain {

    public static void main(String[] args){
        double [][] basic = {{1,2,3}, {2,3,4}, {5,2,6}};
        Matrix s0 = new Matrix(basic);
        s0.print();

        double [][] x2 = {{1,1,0}, {0,3,4}, {5,0,6}};
        double [][] x1 = {{0,1,0}, {0,3,1}, {1,0,6}};

        Matrix m2 = new Matrix(x2);
        Matrix m3 = new Matrix(x1);

        Matrix s1 = MatrixUtil.mulMatrix(m2, s0);
        s1.print();

        Matrix s2 = MatrixUtil.diffMatric(m3,s0);
        s2.print();

        Matrix s3 = MatrixUtil.addMatrix(s0,m2);
        s3.print();
    }
}
