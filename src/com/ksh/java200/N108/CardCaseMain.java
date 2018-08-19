package com.ksh.java200.N108;




public class CardCaseMain {
    public static void main(String[] args){
        CardCase cardCase =  new CardCase();
        cardCase.make();
        cardCase.print();
        System.out.println("---------------------");
        cardCase.shuffle();
        cardCase.print();
        System.out.println("---------------------");
        cardCase.shuffle();
        cardCase.print();
        System.out.println("---------------------");
        cardCase.sort();
        cardCase.print();
        System.out.println("---------------------");
        cardCase.rsort();
        cardCase.print();
        System.out.println("---------------------");
        cardCase.lambdarsort();
        cardCase.print();
        System.out.println("---------------------");
        cardCase.lambdasort();
        cardCase.print();
        System.out.println("---------------------");
    }
}
