package karamel.dev.studio.doitmission08;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    EditText edtUrl;

    Button btnGo, btnSlide;
    WebView webView;

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUrl = findViewById(R.id.edtUrl);
        btnGo = findViewById(R.id.btnGo);
        btnSlide = findViewById(R.id.button);
        webView = findViewById(R.id.webView);

        final LinearLayout ll = findViewById(R.id.innerLayout);

        final WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient());


        btnSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll.setVisibility(View.VISIBLE);
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(edtUrl.getText().toString());
            }
        });


    }
}
