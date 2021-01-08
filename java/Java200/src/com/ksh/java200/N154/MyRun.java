package com.ksh.java200.N154;

public class MyRun implements Runnable {

    @Override
    public void run() {
        show();
    }

    public void show(){
        for (int i = 0; i < 500; i++) {
            System.out.print("S");
        }
    }
}
