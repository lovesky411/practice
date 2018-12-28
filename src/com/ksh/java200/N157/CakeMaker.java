package com.ksh.java200.N157;

public class CakeMaker extends  Thread{
    private CakePlate cake;
    public CakeMaker(CakePlate cake){
        setCakePlate(cake);
    }

    private void setCakePlate(CakePlate cake) {
        this.cake = cake;
    }

    public CakePlate getCakePlate() {
        return cake;
    }

    public void run(){
        for (int i = 0; i < 50; i++) {
            cake.makeBread();
        }
    }
}
