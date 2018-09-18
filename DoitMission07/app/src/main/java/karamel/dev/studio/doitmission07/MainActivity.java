package karamel.dev.studio.doitmission07;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");

    Button btn1, btn2 ;

    Date selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editText);
        etAge = findViewById(R.id.editText2);

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String birth = btn1.getText().toString();

                String msg = "이름 : " + name + " /  나이 : " + age + " /  생년 : " + birth;

                Toast.makeText(getApplicationContext(), msg ,Toast.LENGTH_LONG).show();
            }
        });

        Date curDate = new Date();
        setSelectedDate(curDate);
    }

    private void showDatePicker(){
        String birthDate = btn1.getText().toString();

        Calendar calendar = Calendar.getInstance();
        Date curBirthDate = new Date();
        try {
            curBirthDate = dateFormat.parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar.setTime(curBirthDate);

        int curYear = calendar.get(Calendar.YEAR);
        int curMonth = calendar.get(Calendar.MONTH);
        int curDay = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog dialog = new DatePickerDialog(this, birthDateSetListener, curYear, curMonth, curDay);
        dialog.show();

    }

    private DatePickerDialog.OnDateSetListener birthDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            Calendar selectedCalendar = Calendar.getInstance();
            selectedCalendar.set(year, month, day);

            Date curDate = selectedCalendar.getTime();
            setSelectedDate(curDate);
        }
    };

    private void setSelectedDate(Date curDate) {
        selectedDate = curDate;
        String selectedDateStr = dateFormat.format(curDate);
        btn1.setText(selectedDateStr);
    }
}
