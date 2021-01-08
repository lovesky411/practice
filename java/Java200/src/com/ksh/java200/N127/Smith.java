package com.ksh.java200.N127;

public class Smith {

    public static void printSmith(int t1, int t2){
        for(int i = t1; i<t2; i++){
            if(!Java200Math.isPrime(i)
                && Java200Math.sumEach(i) == Java200Math.sumSmith(i)){
                System.out.printf("%d는 스미스 수 ", i);
                System.out.println();
//                Java200Math.printPrimeDivide(i); N123 참조
            }
        }
    }

    public static void main(String[] args){
        printSmith(10000, 20000);
    }
}
