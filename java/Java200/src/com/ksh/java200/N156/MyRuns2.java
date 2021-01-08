package com.ksh.java200.N156;

public class MyRuns2 implements Runnable {

    private int i = 0;
    @Override
    public void run() {
        show();
    }

    public synchronized void show(){
        for (; i < 500; i++) {
            if ((Thread.currentThread().getName().equalsIgnoreCase("a"))) {

                System.out.print("A");
            }else if ((Thread.currentThread().getName().equalsIgnoreCase("b"))) {

                System.out.print("B");
            }else if ((Thread.currentThread().getName().equalsIgnoreCase("c"))) {

                System.out.print("C");
            }else {
                System.out.print("["+Thread.currentThread().getName()+i+"]");
            }


        }
    }
}
