package com.ksh.java200.N010;

public class TypeTest {

    public static void main(String[] args){

        byte ba = 10;
        byte bb = 20;
        byte bc = 10 + 20;
        byte be = (byte) (ba+bb);
        System.out.println("01 : " + bc);
        System.out.println("02 : " + be );

        short sa = 30;
        short sb = 50;
        short sc = 30+50;

        short se =(short)(sa+sb);
        System.out.println("03 : " + sc);
        System.out.println("04 : " + se);

        int ia = 20;
        int ib = 30;
        int ic = 20 + 30;
        int id = ic+sa;
        System.out.println("05 : " + ic);

        long la = 40l;
        long lb = 50L;
        long lba = 50+Integer.MAX_VALUE;
        long lbb = 50L+Integer.MAX_VALUE;
        long lc = la+lb;
        System.out.println("06 : " +lba);
        System.out.println("07 : " +lbb);
        System.out.println("08 : " + lc);

        float fa= 45.0f;
        float fb = 46.67F;
        float fd = 30;
        float fe = fa+fb;

        double da = 12;
        double db = 45+Float.MAX_VALUE;
        double dc = da+db;
        System.out.println("09 : "+ dc );



    }


}
