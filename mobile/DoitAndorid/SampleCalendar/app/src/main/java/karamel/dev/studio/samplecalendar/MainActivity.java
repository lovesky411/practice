package karamel.dev.studio.samplecalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView monthView;
    MonthAdapter adapter;
    TextView monthText;
    int curYear;
    int curMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthView = findViewById(R.id.monthView);
        monthText = findViewById(R.id.monthText);
        adapter = new MonthAdapter(this);
        monthView.setAdapter(adapter);

        monthView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MonthItem curItem = (MonthItem) adapter.getItem(position);
                int day = curItem.getDayValue();

            }
        });

        setMonthText();

        Button monthPrevious = findViewById(R.id.monthPrevious);
        monthPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setPreviousMonth();
                adapter.notifyDataSetChanged();

                setMonthText();
            }
        });

        Button monthNext = findViewById(R.id.monthNext);
        monthNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setNextMonth();
                adapter.notifyDataSetChanged();

                setMonthText();
            }
        });
    }

    private void setMonthText() {
        curYear = adapter.getCurYear();
        curMonth = adapter.getCurMonth();

        monthText.setText(curYear + " / " + curMonth +1);
    }
}
