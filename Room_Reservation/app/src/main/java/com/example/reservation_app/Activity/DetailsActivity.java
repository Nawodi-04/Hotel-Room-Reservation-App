package com.example.reservation_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.reservation_app.Adapter.SimilarAdapter;
import com.example.reservation_app.Domain.ItemsDomain;
import com.example.reservation_app.R;

public class DetailsActivity extends AppCompatActivity {
    private ItemsDomain object;
    private ImageView backBtn, itemImg;
    private TextView priceKgTxt, titleTxt, descriptionTxt, ratingTxt;
    private RatingBar ratingBar;
    private TextView totalTxt;
    private RecyclerView.Adapter similarAdapter;
    private RecyclerView recyclerViewSimilar;
    private Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),checkin.class);
            startActivity(intent);
        });
        
        getBundles();
        initView();
        setVariable();
        initSimilarList();
    }

    private void initSimilarList() {
        recyclerViewSimilar=findViewById(R.id.similarview);
        recyclerViewSimilar.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        similarAdapter=new SimilarAdapter(new Dashboard().getData());
        recyclerViewSimilar.setAdapter(similarAdapter);
    }

    private void setVariable() {
        backBtn.setOnClickListener(view -> finish());
        int drawableResourceId=getResources().getIdentifier(object.getImgPath(),"drawable",DetailsActivity.this.getPackageName());

        Glide.with(DetailsActivity.this)
                .load(drawableResourceId)
                .into(itemImg);

        priceKgTxt.setText(object.getPrice()+"$");
        titleTxt.setText(object.getTitle());
        descriptionTxt.setText(object.getDescription());
        ratingTxt.setText("("+object.getRate()+")");
        ratingBar.setRating((float) object.getRate());
        totalTxt.setText((object.getPrice())+"$");
    }

    private void initView() {
        backBtn=findViewById(R.id.backBtn);
        itemImg=findViewById(R.id.img);
        priceKgTxt=findViewById(R.id.priceKgTxt);
        titleTxt =findViewById(R.id.titleTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        ratingBar=findViewById(R.id.ratingBar);
        ratingTxt=findViewById(R.id.ratingTxt);
        totalTxt=findViewById(R.id.totalTxt);
    }

    public void getBundles() {
        object= (ItemsDomain) getIntent().getSerializableExtra("object");
    }
}