package karamel.dev.studio.ddaypractice;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    DayAdapter dayAdapter;
    Button addBtn;

    DatePickerDialog dialog;


    // 오늘 날짜
    private int todayYear;
    private int todayMonth;
    private int todayDay;


    // D-DAY  날짜
    private int dDayYear = 1;
    private int dDayMonth = 1;
    private int dDayDay = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn = findViewById(R.id.addBtn);
        listView = findViewById(R.id.listView);

        listView.setAdapter(dayAdapter);
        dialog = new DatePickerDialog(this, listener, 2018, 0, 01);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        Calendar calendar = Calendar.getInstance();
        todayYear = calendar.get(Calendar.YEAR);
        todayMonth = calendar.get(Calendar.MONTH);
        todayDay = calendar.get(Calendar.DAY_OF_MONTH);



    }

    private String dDayCalc(){

        return null;
    }

    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Toast.makeText(getApplicationContext(), year + "년" + month + "월" + dayOfMonth +"일", Toast.LENGTH_SHORT).show();


        }
    };

    class DayAdapter extends BaseAdapter{

        ArrayList<DayItem> item = new ArrayList<DayItem>();

        @Override
        public int getCount() {
            return item.size();
        }

        public void addItem(DayItem dayItem){
            item.add(dayItem);
        }

        public void removeItem(int position){
            item.remove(position);
        }
        @Override
        public Object getItem(int position) {
            return item.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            DayItemView view = new DayItemView(getApplicationContext());
            DayItem  day =  item.get(position);
            view.setDdayTV(day.getdDay());
            view.setStartDayTv(day.getStartDay());
            view.setDayMemoTv(day.getDayMemo());

            return view;
        }
    }


}
