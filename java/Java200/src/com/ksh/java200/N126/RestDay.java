package com.ksh.java200.N126;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
* Calendar를 이용하여 휴일 구하기
* */
public class RestDay {

    public static boolean isRest(Calendar tod){
        boolean isRest = false;
        if(tod.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || tod.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            isRest = true;
        }
        return isRest;
    }

    public static String toYMD(Calendar dd){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(dd.getTime());
    }

    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for(int i = 1; i <= lastDay; i++){
            cal.set(Calendar.DAY_OF_MONTH, i);
            if(isRest(cal)){
                System.out.println(toYMD(cal)+ "is REst DAY");
            }
        }
    }
}
