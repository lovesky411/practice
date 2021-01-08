package com.ksh.java200.N110;

import com.ksh.java200.N109.Card;
import com.ksh.java200.N109.CardCase;

public class CardRuleMain {
    public static void main(String[] args){
        CardCase cardCase = new CardCase();
        cardCase.make();
        CardRule rule = new CardRule();

        for(int i =0; i< 5; i++){
            System.out.println("=====================");
            cardCase.shuffle();
            cardCase.print();
            int a = (int) rule.rule(cardCase.getCard(0), cardCase.getCard(2));
            int b = (int) rule.rule(cardCase.getCard(1),cardCase.getCard(3));
            System.out.println(cardCase.getCard(0) + " " + cardCase.getCard(2) + " " + a);
            System.out.println(cardCase.getCard(1) + " " + cardCase.getCard(3) + " " + b);
        }

    }
}
