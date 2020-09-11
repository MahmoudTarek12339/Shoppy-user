package com.example.shoppy_user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProdDetailsActivity extends AppCompatActivity {
    TextView name,price;
    ImageView img;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_details);
        id();
        setValues();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProdDetailsActivity.this,SubmitActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setValues() {
        Intent i=getIntent();
        name.setText(i.getStringExtra("Name"));
        price.setText(i.getStringExtra("Price"));
        Picasso.with(this).load(i.getStringExtra("Image")).placeholder(R.mipmap.ic_launcher).fit().into(img);
    }

    private void id(){
        name=findViewById(R.id.prod_name);
        price=findViewById(R.id.prod_price);
        img=findViewById(R.id.prod_img);
        btn=findViewById(R.id.Cart_btn);
    }
}