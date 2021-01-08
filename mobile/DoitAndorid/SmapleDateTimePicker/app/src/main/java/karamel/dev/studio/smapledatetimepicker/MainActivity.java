package karamel.dev.studio.smapledatetimepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");

    TextView textView;
    DateTimePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        picker = findViewById(R.id.picker);


        picker.setOnDateTimeChangedListener(
                new DateTimePicker.OnDateTimeChangedListener() {
                    @Override
                    public void onDateTimeChanged(DateTimePicker view, int year, int monthOfYear, int dayOfyear, int hourOfDay, int minute) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfyear, hourOfDay, minute);

                        textView.setText(dateFormat.format(calendar.getTime()));
                    }
                }
        );

        Calendar calendar = Calendar.getInstance();
        calendar.set(picker.getYear(), picker.getMonth(), picker.getDayOfMonth(), picker.getCurrentHour(), picker.getCurrentMinute() );
        textView.setText(dateFormat.format(calendar.getTime()));
    }
}
