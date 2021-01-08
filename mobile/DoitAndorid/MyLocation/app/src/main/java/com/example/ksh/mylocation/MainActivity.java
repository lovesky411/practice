package com.example.ksh.mylocation;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLocationService();
            }
        });
    }

    public void startLocationService() {
        long minTime = 100000;
        float minDistance = 0.0f;
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance,
                new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        Double latitude = location.getLatitude();
                        Double longitude = location.getLongitude();

                        textView.setText("내 위치 : " + latitude + " / " + longitude);

                    }

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {

                    }

                    @Override
                    public void onProviderEnabled(String s) {

                    }

                    @Override
                    public void onProviderDisabled(String s) {

                    }
                });
    }
}
