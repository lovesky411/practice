package com.ksh.java200.N158;

import java.io.Serializable;
import java.rmi.server.UID;

public class Student implements Cloneable, Serializable {
    private static final long serialVersionUID = 12234214234L;
    private String name;
    private int age;
    private String addr;

    public Student(String name, int age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }

    public Object clone(){
        try{
            return super.clone();
        }catch (CloneNotSupportedException e){
            return this;
        }
    }

    public boolean equals(Object obj){
        boolean isE = false;
        Student temp = (Student)obj;
        if(temp.getName().equals(name) && temp.getAge() == age
            && temp.getAddr().equals(addr)){
            isE = true;
        }
        return isE;
    }

    public int hashCode(){
        int temp = 0;
        temp = name.hashCode() + addr.hashCode()+age + 37;
        return temp;
    }
}
