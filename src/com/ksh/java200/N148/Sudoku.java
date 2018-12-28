package com.ksh.java200.N148;

import com.ksh.java200.N145.Matrix;
import com.ksh.java200.N146.MatrixUtil;

import java.util.Arrays;

public class Sudoku {
    boolean isShuffle = true;
    double [][] sdoku;
    double [][] basic;
    int n ;
    public Sudoku(int n ){
        this.n = n;
        sdoku = new double[n*n][n*n];
        basic = new double[n][n];
    }

    public Sudoku(){
        this(3);
    }

    private void clear(){
        int m = sdoku.length;
        for (int i = 0; i < m; i++) {
            Arrays.fill(sdoku[i], 0);
        }
    }

    public boolean isShuffle(){
        return isShuffle;
    }

    public void setShuffle(boolean isShuffle){
        this.isShuffle = isShuffle;
    }

    public void init(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                basic[i][j] = i*n+ j+1;
                sdoku[i][j] = basic[i][j];
            }
        }
    }

    public void shuffle(){
        if(isShuffle()){
//            Matrix msdo = MatrixUtil.to
        }
    }

}
