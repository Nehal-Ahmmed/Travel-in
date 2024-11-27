package com.example.travelin.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.travelin.R;
import com.example.travelin.domains.popularDomain;

public class DetailActivity extends AppCompatActivity {

    private TextView titleTxtt,locationTxt,scoreTxtt,bedTxt,guideTxt,wifiTxt,descriptionTxt,priceTxt;
    private ImageView picImgg,backbtn;
    private popularDomain item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        initView();
        setVariable();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setVariable() {
        item= (popularDomain) getIntent().getSerializableExtra("object");
        titleTxtt.setText(item.getTitle());
        scoreTxtt.setText((int) item.getScore()+"");
        locationTxt.setText(item.getLocation());
    bedTxt.setText(item.getBed()+" Bed");
       descriptionTxt.setText(item.getDescription());
     priceTxt.setText(item.getPrice()+"$");

        if(item.isGuide()){
            guideTxt.setText("Guide");
        } else{
            guideTxt.setText("No Guide");
        }

        if(item.isWifi()){
            wifiTxt.setText("Wifi");
        } else{
            wifiTxt.setText("No wifi");
        }

        int drawableRes=getResources().getIdentifier(item.getPic(),"drawable",getPackageName());

        Glide.with(this)
                .load(drawableRes)
                .into(picImgg);

        backbtn.setOnClickListener(view -> finish());

    }

    private void initView() {

        titleTxtt=findViewById(R.id.titleTxtt);
        locationTxt=findViewById(R.id.locationTxt);
        scoreTxtt=findViewById(R.id.scoreTxtt);
        bedTxt=findViewById(R.id.bedTxt);
        guideTxt=findViewById(R.id.guideTxt);
        wifiTxt=findViewById(R.id.wifiTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        priceTxt=findViewById(R.id.priceTxt);
        picImgg=findViewById(R.id.picImgg);
        backbtn=findViewById(R.id.backbtn);

    }
}