package com.ksh.java200.N059;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
* @author ksh
* @version 1.0.0
* @sine 2018-08-12 오후 4:36
* @desc Stream을 이용하여 홀수의 합 구하기
**/
public class ForCondition3 {
    public static void main(String[] args){
        List<Integer> iList = new ArrayList<>();
        int s = 0;

        for (int i = 1; i <= 100; i++){
            iList.add(i);
        }

        s = iList.stream().reduce(0, Integer::sum);
        System.out.println("1~100의 합 : "+ s);
        s=0;

        s = iList.stream().filter(i-> i%2 ==1).reduce(0, Integer::sum);
        System.out.println("1~100 사이 홀수의 합 : " + s);

        s = iList.stream().filter(i->i%2==1).reduce(0, (x,y)->x+y);
        System.out.println("1~100 사이의 홀수의 합 : " +s);

        s = iList.stream().filter( i->i%2 ==1).reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer t, Integer u) {
                return t+u;
            }
        });
        System.out.println("1~100 사이의 홀수의 합 : " +s);

    }
}
