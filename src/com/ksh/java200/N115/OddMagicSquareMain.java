package com.ksh.java200.N115;

import com.ksh.java200.N114.OddMagicSquare;

import java.util.Scanner;

public class OddMagicSquareMain {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("홀수 정수를 입력하세요");
        OddMagicSquare oddMagicSquare = new OddMagicSquare(n);
        oddMagicSquare.make();
        oddMagicSquare.print();
    }
}
