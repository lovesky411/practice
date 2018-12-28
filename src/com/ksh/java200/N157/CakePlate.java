package com.ksh.java200.N157;

public class CakePlate {
    private int breadCount =0;
    public CakePlate(){
    }
    public synchronized void makeBread(){
        if(breadCount >=10){
            try{
                System.out.println("빵이 남아");
                wait();
            }catch (InterruptedException ire){}
        }

        breadCount++;
        System.out.println("빵을 1개 더 만들자 총 " + breadCount + " 개");
        this.notifyAll();
    }
    public  synchronized void eatBread(){
        if(breadCount < 1){
            try{
                System.out.println("빵이 없어!!!");
                wait();
            }catch (InterruptedException re){}
        }
        breadCount--;
        System.out.println("빵 1개 묵음 총 " + breadCount + " 개" );
        this.notifyAll();
    }
}
