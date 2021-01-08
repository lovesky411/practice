package com.ksh.java200.N103;

public class Card {

    private String cardVal;

    public String getCardVal() {
        return cardVal;
    }

    public Card(){
        this("H2");
    }

    public Card(String s){
        this.cardVal = s;
    }

    public Card(Card card){
        this(card.getCardVal());
    }

    @Override
    public String toString() {
        return "[" + cardVal + "]";
    }
}
