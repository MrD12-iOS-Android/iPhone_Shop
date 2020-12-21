package dilshod.iskandarov.iphone_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent order_i = getIntent();

        String userName = order_i.getStringExtra("order_name_for_intent");
        TextView order_txt = findViewById(R.id.order_textView);

        String goodsName = order_i.getStringExtra("order_for_intent");
        int click = order_i.getIntExtra("order_click_for_intent", 0);
        int price = order_i.getIntExtra("order_price_for_intent",0);

        order_txt.setText(
                        "Customer Name:  " + userName +"\n" +
                        "Goods Name:  " + goodsName + "\n" +
                        "Quantity:  " + click + "\n" +
                        "Price:  " + price);
        order_txt.setTextColor(Color.parseColor("#FFA100"));
    }
}