package com.ksh.java200.N103;

public class CardMain {
    public static void main(String[] args){
        String csuit1 = "H", cvalu1="6";
        String csuit2 = "H", cvalu2="3";

        Card c1 = new Card("H6");
        Card c2 = new Card(csuit1 + cvalu1);
        Card c3 = new Card();
        Card c4 = new Card(csuit2 + cvalu2);
        System.out.printf("%s,%s,%s,%s\n", c1,c2,c3,c4);
        System.out.println(c1.equals(c2));
        System.out.println(c1.getCardVal().equals(c2.getCardVal()));

    }
}
