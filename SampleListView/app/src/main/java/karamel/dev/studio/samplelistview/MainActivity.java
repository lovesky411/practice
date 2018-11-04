package karamel.dev.studio.samplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    ListView listView;
    SingerAdapter adapter;

    class SingerAdapter extends BaseAdapter{

        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
        public void addItem(SingerItem item){
            items.add(item);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            SingerItemView view = new SingerItemView(getApplicationContext());
            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setAge(item.getAge());
            view.setMobille(item.getMobile());
            view.setImageView(item.getResId());

            return view;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        adapter = new SingerAdapter();

        adapter.addItem(new SingerItem("소녀시대", "01023123", 20, R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("소1녀시대", "010293123", 20, R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("소녀시2대", "09102368123", 120, R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("소녀시3대", "010231123", 420, R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("소녀4시대", "0102351123", 520, R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("5소녀시대", "010231223", 210, R.drawable.ic_launcher_background));
        adapter.addItem(new SingerItem("소녀6시대", "010213123", 220, R.drawable.ic_launcher_background));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SingerItem item = (SingerItem) adapter.getItem(i);
            }
        });

    }


}
