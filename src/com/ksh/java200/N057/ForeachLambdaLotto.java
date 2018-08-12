package com.ksh.java200.N057;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
* @author ksh
* @version 1.0.0
* @sine 2018-08-12 오후 4:32
* @desc foreach와 lambda 형식을 이용하여 List 출력하기
**/
public class ForeachLambdaLotto {

    public static void main(String[] args){
        List<Integer> mmlists = Arrays.asList(1,6,16,22,23,33);
        mmlists.forEach(
                m->{System.out.println(m+"\t");}
        );

        System.out.println();
        Consumer<Integer> comsume = (Integer m) -> {System.out.println(m + "\t");};
        mmlists.forEach(comsume);
    }

}
