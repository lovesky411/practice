package com.ksh.java200.N158;

import java.io.IOException;
import java.util.Vector;

public class ObjectStudentWriteMain {
    public static void main(String[] args){
        ObjectStudentRWG<Student> osw = new ObjectStudentRWG<>();
        Vector<Student> v = new Vector<>();
        v.add(new Student("홍길동", 17, "한양"));
        v.add(new Student("홍2길동", 217, "한1양"));
        v.add(new Student("홍4길동", 157, "5한양"));
        v.add(new Student("홍길5동", 127, "한2양"));
        v.add(new Student("홍길112동", 167, "한양87"));

        try{
        osw.write("d\\stu.obj", v);
    }catch (IOException e){
        System.out.println(e);
    }

    }
}

