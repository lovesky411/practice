package karamel.dev.studio.doitmission09;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomerItemView extends LinearLayout {

    ImageView imageView;
    TextView nameTv;
    TextView phoneTv;

    public CustomerItemView(Context context) {
        super(context);
        init(context);
    }

    public CustomerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.customer, this, true );
        imageView = findViewById(R.id.imageView);
        nameTv = findViewById(R.id.nameTv);
        phoneTv = findViewById(R.id.phoneTv);
    }

    public void setName(String name, String birth){
        nameTv.setText(name + " / " + birth);
    }

    public void setPhone(String phone){
        phoneTv.setText(phone);
    }

    public void setImageView(int resId){
        imageView.setImageResource(resId);
    }

}
