package karamel.dev.studio.doitmission_03;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView sc1, sc2;
    ImageView iv1, iv2;
    Button btn1, btn2;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sc1 = findViewById(R.id.sc1);
        sc2 = findViewById(R.id.sc2);

        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        sc1.setHorizontalScrollBarEnabled(true);
        sc2.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.dc1);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        iv1.setImageDrawable(bitmap);


        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv1.setImageDrawable(bitmap);
                iv2.clearAnimation();
            }
        });
        btn2 = findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv2.setImageDrawable(bitmap);
                iv1.clearAnimation();
            }
        });
    }




}
