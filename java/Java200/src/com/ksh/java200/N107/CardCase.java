package com.ksh.java200.N107;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardCase {

    private List<Card> cards = new ArrayList<Card>();

    public CardCase() {
        cards.clear();
    }

    public List<Card> getCards(){
        return cards;
    }

    public int count(){
        return cards.size();
    }

    public Card getCard(int index){
        return cards.get(index);
    }

    public void make(){
        cards.clear();
        int suit = CardUtil.SUIT.length;
        int valu = CardUtil.VALU.length;
        int count = 0;
        while(count!=valu*suit){
            Card card = new Card();
            if(!cards.contains(card)){
                cards.add(card);
                count++;
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public void print(){
        int valu = CardUtil.VALU.length;
        for(int i=0; i<cards.size(); i++){
            Card card = cards.get(i);
            System.out.printf("%s",card.toString());
            if((i+1)%valu ==0){
                System.out.println();
            }
        }
    }

    public void sort(){
        cards.sort(new CardComp());
    }
    public void rsort(){
        cards.sort(new CardRomp());
    }
}