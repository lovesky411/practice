package com.ksh.java200.N114;

import java.util.Scanner;

public class OddMagicSquareMain {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("홀수 정수 입력");
        OddMagicSquare oddMagicSquare = new OddMagicSquare(n);
        oddMagicSquare.make();
        oddMagicSquare.print();
    }
}
