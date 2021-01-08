package com.ksh.java200.N158;

import java.io.*;
import java.util.Vector;

public class ObjectStudentRWG<T> {
    public int write(String fname, Vector<T> v) throws IOException {
        int objectNumber = 0;
        try{
            FileOutputStream fos = new FileOutputStream(fname);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            objectNumber = v.size();
            oos.writeInt(objectNumber);
            System.out.println(objectNumber+"개의 DATA 입력됨");
            for (int i = 0; i < objectNumber; i++) {
                oos.writeInt(i);
                oos.writeObject(v.get(i));
                oos.flush();
                System.out.println(i+"번쨰의 DATA 입력");
            }
            oos.close();
            fos.close();


        }catch (FileNotFoundException e){
            System.out.println("파일 이름 확인");
        }catch (Exception ee){
            throw new IOException("타입 이상.."+ee);
        }
        return objectNumber;
    }

    public void read(String fname) throws IOException{
        try{
            FileInputStream fis = new FileInputStream(fname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            int objectNumber = ois.readInt();
            System.out.println(objectNumber +" 개의 DATA 읽음");
            for (int i = 0; i < objectNumber; i++) {
                try{
                    System.out.print(ois.readInt()+"번째 :");
                    System.out.println(ois.readObject());
                }catch (ClassNotFoundException e1){
                    System.out.println("Wrong Type!");
                }
            }
            ois.close();
            fis.close();
        }catch (FileNotFoundException e){

        }catch (Exception ee){

        }
    }
}
