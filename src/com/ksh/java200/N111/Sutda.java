package com.ksh.java200.N111;

import com.ksh.java200.N108.CardUtil;
import com.ksh.java200.N109.Card;
import com.ksh.java200.N109.CardCase;
import com.ksh.java200.N110.CardRule;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Date;
import java.util.Scanner;

public class Sutda {
    CardCase cardCase = new CardCase();
    CardRule rule = new CardRule();
    Card[] cc1 = new Card[CardUtil.SUTDA];
    Card[] cc2 = new Card[CardUtil.SUTDA];

    public Sutda(){
        cardCase.make();
    }
    private void divide(){
        for(int i = 0; i < CardUtil.SUTDA; i++){
            cc1[i] = cardCase.getCard(i);
            cc2[i] = cardCase.getCard(i+CardUtil.SUTDA);
        }
    }

    public void divide2(){
        for(int i = 0, j=0; i < cc1.length; i++, j+=2){
            cc1[i] = cardCase.getCard(j);
            cc2[i] = cardCase.getCard(j+1);
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("~!! Wellcom to CARDGAMEAEWFI! " + new Date());

        System.out.println("START!");

        String ss = "N";
        do {
            cardCase.shuffle();
            divide2();
            int v1 = rule.rule(cc1[0], cc1[1]);
            int v2 = rule.rule(cc2[0], cc2[0]);
            if(v1 > v2) {
                System.out.println(" YOU WIN!");
            }else if(v1 < v2){
                System.out.println("YOOU LOSE");
            }else {
                System.out.println("YOOU SAME");
            }

            cardCase.print();

            ss=scanner.next();
        }while((ss.toUpperCase()).equalsIgnoreCase("Y"));
        System.out.println("GGODYFB VYE!!");
    }

}
