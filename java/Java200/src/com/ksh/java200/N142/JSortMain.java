package com.ksh.java200.N142;


import java.util.Random;

public class JSortMain {
    
    
    public static void main(String[] args){
        int[] m = new int[100];
        int[] n = new int[m.length];
        System.out.println(m.length);
        Random random = new Random();
        for (int i = 0; i < m.length; i++) {
            int rand = random.nextInt(1000);
            m[i] = rand;
        }

        System.arraycopy(m, 0, n, 0,m.length);
        JSort.print(n);
        long a = System.nanoTime();
        JSort.QuickSort(n);
        long b = System.nanoTime();
        System.out.println((b-a)+"nano sec");
        JSort.print(n);
     }
    
    
}
