package dilshod.iskandarov.iphone_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView txt;
    Button btn;
    int click = 0;
    Spinner spinner;
    EditText userName;
    ImageView img_tovar;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;
    HashMap goodsMap;
    String goodsName;
    int price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        oncreateSpinner();
        oncreateHashMap();

    }
    void init(){
        userName = findViewById(R.id.nameEditText);
        btn = findViewById(R.id.button);
        txt = findViewById(R.id.number);
        img_tovar = findViewById(R.id.img_tovar);
        spinner = findViewById(R.id.spinner);

    }
    void oncreateSpinner(){
        spinner.setOnItemSelectedListener(this);
        arrayList = new ArrayList();
        arrayList.add("iPhone");
        arrayList.add("iPad");
        arrayList.add("iMac");

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }


    void oncreateHashMap(){
        goodsMap = new HashMap();
        goodsMap.put("iPhone", 300);
        goodsMap.put("iPad", 500);
        goodsMap.put("iMac", 2000);
    }
    public void plus(View view) {
        click++;
        txt.setText(String.valueOf(click));
        TextView priceText = findViewById(R.id.price_txt);
        priceText.setText("" + click * price);

    }
    public void minus(View view) {
        if(click > 0){
            click--;
            txt.setText(String.valueOf(click));
            Toast.makeText(this, "Minus", Toast.LENGTH_SHORT).show();
        }
        TextView priceText = findViewById(R.id.price_txt);
        priceText.setText("" + click * price);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price = (int)goodsMap.get(goodsName);
        TextView priceText = findViewById(R.id.price_txt);
        priceText.setText("" + click * price);
        switch (goodsName){
            case "iPhone":
                img_tovar.setImageResource(R.drawable.iphone);
                break;
            case "iPad":
                img_tovar.setImageResource(R.drawable.ipad);
                break;
            case "iMac":
                img_tovar.setImageResource(R.drawable.imac);
                break;
            default:
                img_tovar.setImageResource(R.drawable.iphone);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void add_to_card(View view) {
        Order order = new Order();
        order.user_Name = userName.getText().toString();
        order.goods_Name = goodsName;
        order.click = click;
        order.order_price = click * price;
        Intent i = new Intent(MainActivity.this,OrderActivity.class);
        i.putExtra("order_name_for_intent", order.user_Name);
        i.putExtra("order_for_intent", order.goods_Name);
        i.putExtra("order_click_for_intent", order.click);
        i.putExtra("order_price_for_intent", order.order_price);
        startActivity(i);


    }
}















