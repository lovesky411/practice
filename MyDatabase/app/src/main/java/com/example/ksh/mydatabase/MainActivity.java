package com.example.ksh.mydatabase;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;

    EditText editText3;
    EditText editText4;
    EditText editText5;

    TextView textView;
    TextView textView2;
    SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        textView = (TextView) findViewById(R.id.textView);


        Button button  = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String databaseName  = editText.getText().toString();
                openDatabase(databaseName);
            }
        });

        Button button2  = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName  = editText2.getText().toString();
                createTable(tableName);
            }
        });

        Button button3  = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name  = editText3.getText().toString();
                String ageStr  = editText4.getText().toString();
                String mobile  = editText5.getText().toString();

                int age = -1;
                try{
                    age = Integer.parseInt(ageStr);
                }catch(Exception e){
                    insertData(name, age, mobile);
                }

            }
        });

        Button button4  = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectData();
            }
        });



    }



    public void openDatabase(String databaseName){
        println("openDatabase 호출됨.");
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);

        if(database != null){
            println("database 오픈됨.");
        }
    }

    public void createTable(String tableName){
        println("createTable 호출됨.");
        if(database != null){
            String sql = "create table " + tableName + "(_id integer PRIMARY KEY autoincrement, name text, age integer, mobile text) ";
            database.execSQL(sql);

            println(" 테이블 생성됨.");
        }else{
            println("먼저 데이터베이스를 오픈하세요.");
        }
    }

    public void insertData(String name, int age, String mobile){
        println("InsertData 호출됨!");

        if(database != null){
            String sql = "insert into customer (name, age, mobile) values (? , ? , ?)";

            Object[] params = {name, age, mobile};


            database.execSQL(sql, params);

            println("데이터 추가함");
        }else{
            println("데이터 오픈필요");
        }

    }

    public void selectData(){
        println("selectData 호출됨");

        if(database !=  null) {
            String sql = "SELECT name, age, mobile from customer";
            Cursor cursor = database.rawQuery(sql, null);
            println("조회된 데이터 갯수 " + cursor.getCount());

            while(cursor.moveToNext()){
                String name = cursor.getString(0);
                int age = cursor.getInt(1);
                String mobile = cursor.getString(2);

                println(">> " + name + " , " + age + " ., " + mobile);
           }

           cursor.close();
        }
    }

    public void println(String data){
        textView.append(data + "\n");
    }
}
