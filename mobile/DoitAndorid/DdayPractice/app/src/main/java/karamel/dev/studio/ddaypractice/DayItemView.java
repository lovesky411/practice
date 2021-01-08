package karamel.dev.studio.ddaypractice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DayItemView extends LinearLayout {

    TextView dDayTV;
    TextView startDayTv;
    TextView dayMemoTv;

    public DayItemView(Context context) {
        super(context);
        init(context);
    }

    public DayItemView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.day_item, this, true);

        dDayTV = findViewById(R.id.dday_textView);
        startDayTv = findViewById(R.id.startDay_textView);
        dayMemoTv = findViewById(R.id.dayMemo_textView);


    }


    public void setDdayTV(String dday) {
        dDayTV.setText(dday);
    }



    public void setStartDayTv(String startDay) {
        startDayTv.setText(startDay);
    }

    public void setDayMemoTv(String dayMemo) {
        dayMemoTv.setText(dayMemo);
    }
}
