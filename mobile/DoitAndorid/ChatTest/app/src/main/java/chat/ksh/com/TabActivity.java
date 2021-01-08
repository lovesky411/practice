package chat.ksh.com;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.SystemClock;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class TabActivity extends AppCompatActivity {

    private TextView mTextMessage;
    long lastPressed;
    Fragment fragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText("home");
                    fragment = new HomeFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText("friends");
                    fragment = new FriendsFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
//                    mTextMessage.setText("profile");

                    fragment = new ProfileFragment();
                    switchFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.add(R.id.content_fragment, homeFragment);
        fragmentTransaction.commit();
        

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    public void switchFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_fragment, fragment);
        transaction.commit();
    }
    @Override
    public void onBackPressed() {

        if(System.currentTimeMillis() - lastPressed < 1000){
            finish();
        }
    }
}
