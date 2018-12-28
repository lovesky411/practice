package com.ksh.java200.N155;

public class MyRuns  implements  Runnable{

    @Override
    public void run() {
        show();
    }

    public void show(){
        for (int i = 0; i < 500; i++) {
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
