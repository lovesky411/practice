package karamel.dev.studio.doitmission09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText birEditText;
    EditText phEditText;
    ListView listView;
    Button adButton;

    CustomerAdapter adapter;

    class CustomerAdapter extends BaseAdapter {

        ArrayList<Customer> items = new ArrayList<Customer>();

        @Override
        public int getCount() {
            return items.size();
        }


        public void addItem(Customer item){ items.add(item);}

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            CustomerItemView view = new CustomerItemView(getApplicationContext());
            Customer item = items.get(position);
            view.setName(item.getName(), item.getBirth());
            view.setPhone(item.getPhone());
            view.setImageView(item.getResId());


            return view;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.customerListView);
        birEditText = findViewById(R.id.birthEditText);
        nameEditText = findViewById(R.id.nameEditText);
        phEditText = findViewById(R.id.phoneEditText);
        adButton = findViewById(R.id.addButton);

        adapter = new CustomerAdapter();

        listView.setAdapter(adapter);

        adButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Customer customer = new Customer();
                    customer.setName(nameEditText.getText().toString());
                    customer.setBirth(birEditText.getText().toString());
                    customer.setPhone(phEditText.getText().toString());
                    adapter.addItem(customer);
                    adapter.notifyDataSetChanged();
                }
        });
    }
}
