package com.ksh.java200.N157;

public class CakeEatings {
    public static void main(String[] args){
        CakePlate cake = new CakePlate();
        CakeEater eater = new CakeEater(cake);
        CakeMaker maker = new CakeMaker(cake);
        maker.start();
        eater.start();
    }
}
