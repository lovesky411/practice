package com.ksh.java200.N155;

public class MyRunsMain {
    public static void main(String[] args){
        MyRuns mr1 = new MyRuns();
        Thread t1 = new Thread(mr1, "a");
        Thread t2 = new Thread(mr1, "b");
        Thread t3 = new Thread(mr1, "c");

        t1.start();
        t2.start();
        t3.start();

    }
}
