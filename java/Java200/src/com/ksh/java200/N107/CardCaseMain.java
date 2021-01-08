package com.ksh.java200.N107;



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
    }
}
