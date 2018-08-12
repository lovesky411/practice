package com.ksh.java200.N60;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author ksh
* @version 1.0.0
* @sine 2018-08-12 오후 4:52
* @desc Stream과 map을 이용하여 홀수에 대한 제곱의 합 구하기
**/
public class ForLambdaCondition {
   public static void main(String[] args){
       List<Integer> ilist = new ArrayList<>();
       int s=0;
       for(int i = 1; i <= 10; i++){
           ilist.add(i);
       }

//       stream filter map collect
       ilist = ilist.stream()
               .filter(i->i%2==1)
               .map(i->i*i)
               .collect(Collectors.toList());
       ilist.forEach(i->{System.out.println(i+"\t");});
       System.out.println();
       //stream reduce

       s = ilist.stream().reduce(0, Integer::sum);
       System.out.println("1~10 사이의 홀수에 대한 제곱합 : " + s);
   }

}
