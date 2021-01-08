package com.ksh.java200.N136;

import com.ksh.java200.N127.Java200Math;

import java.util.ArrayList;


// 미완.
public class RSA {
    public static final int START = 200;
    private int p = 11;
    private int q = 7;
    private int n;
    private int phiN;
    private int e;
    private int d;
    public void makePQ(){
        p = (int)(Math.random()*START);
        q = (int)(Math.random()*START);
        while((p==q) || (p<100 || q<100) ||
            (!Java200Math.isPrime(p) || !Java200Math.isPrime(q))){
                p = (int)(Math.random()*START);
                q = (int)(Math.random()*START);
            }
    }

    public void makeN(){
        n = p*q;
    }

    public int getN() {
        return n;
    }

    public void print(){
        System.out.printf("(p,q) = (%d, %d)\n"
                + "(n,phi) = (%d,%d)\n(e,d)=(%d,%d)\n", p,q,n,phiN,e,d
        );
    }

    public void makePHINE(){
        this.phiN=(p-1)*(q-1);
    }

    public int getPhiN(){
        return phiN;
    }

    public void makeE(){
        ArrayList<Integer> es = new ArrayList<Integer>();
        for(int i = 2; i < phiN; i++){
            //if(Java200Math.gcd(phiN, i))/ gcd 는 어디에..?
        }
    }

}
