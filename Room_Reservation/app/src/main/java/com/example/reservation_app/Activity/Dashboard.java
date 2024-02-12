package com.example.reservation_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reservation_app.Adapter.CategoryAdapter;
import com.example.reservation_app.Adapter.PopularRoomAdapter;
import com.example.reservation_app.Domain.ItemsDomain;
import com.example.reservation_app.Domain.catagoryDomain;
import com.example.reservation_app.R;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    private RecyclerView.Adapter catAdapter, bestDealAdapter;
    private RecyclerView recyclerViewCat, recyclerViewBestDeal;

    ImageView imageView6 , imageView7, imageView8, imageView9, imageView10;
    TextView textView13,textView14,textView16,textView17;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imageView9  = findViewById(R.id.imageView9);
        imageView6 = findViewById(R.id.imageView6);
        textView13 = findViewById(R.id.textView13);
        textView16 = findViewById(R.id.textView16);
        button =findViewById(R.id.button);

        imageView9.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),About.class);
            startActivity(intent);
        });

        textView16.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),About.class);
            startActivity(intent);
        });

        imageView6.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),HomePage.class);
            startActivity(intent);
        });

        textView13.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),HomePage.class);
            startActivity(intent);
        });

        button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
            startActivity(intent);
        });


        initRecyclerviewCat();
        initRecyclerViewBestDeal();
        
    }

    private void initRecyclerviewCat() {
        ArrayList<catagoryDomain> items=new ArrayList<>();
        items.add(new catagoryDomain("suitee", "Suite"));
        items.add(new catagoryDomain("cabanaa", "Cabana"));
        items.add(new catagoryDomain("dulexroomm", "Dulex Room"));
        items.add(new catagoryDomain("twiinroom", "Twin Room"));
        items.add(new catagoryDomain("familyyroom", "Family Room"));
        items.add(new catagoryDomain("kiingroom", "King Room"));

        recyclerViewCat=findViewById(R.id.catView);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        catAdapter=new CategoryAdapter(items);
        recyclerViewCat.setAdapter(catAdapter);

    }
    private  void initRecyclerViewBestDeal(){
       recyclerViewBestDeal=findViewById(R.id.bestView);
       recyclerViewBestDeal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

       bestDealAdapter=new PopularRoomAdapter(getData());
       recyclerViewBestDeal.setAdapter(bestDealAdapter);
    }
    public ArrayList<ItemsDomain> getData(){
        ArrayList<ItemsDomain> items = new ArrayList<>();
        items.add(new ItemsDomain("bluesuite","Blue Suite",90,"With spacious living and dining spaces, this suite offers a lifestyle of rest and pleasure. Step onto your private terrace and admire the tranquil ripples of the Beira Lake during the day and the undisturbed beauty of a starry sky at night.",4));
        items.add(new ItemsDomain("orangesuite","Orange Suite",90,"With spacious living and dining spaces, this suite offers a lifestyle of rest and pleasure. Step onto your private terrace and admire the tranquil ripples of the Beira Lake during the day and the undisturbed beauty of a starry sky at night.",3.2));
        items.add(new ItemsDomain("naturecabana","Nature Cabana",100,"With spacious living and dining spaces, this suite offers a lifestyle of rest and pleasure. Step onto your private terrace and admire the tranquil ripples of the Beira Lake during the day and the undisturbed beauty of a starry sky at night",5));
        items.add(new ItemsDomain("standarddulex","Standard Dulex",75,"With spacious living and dining spaces, this suite offers a lifestyle of rest and pleasure. Step onto your private terrace and admire the tranquil ripples of the Beira Lake during the day and the undisturbed beauty of a starry sky at night",3));
        items.add(new ItemsDomain("woodcaban","Wood Cabana",120,"With spacious living and dining spaces, this suite offers a lifestyle of rest and pleasure. Step onto your private terrace and admire the tranquil ripples of the Beira Lake during the day and the undisturbed beauty of a starry sky at night",5));
        items.add(new ItemsDomain("whitesuite","White Suite",85,"With spacious living and dining spaces, this suite offers a lifestyle of rest and pleasure. Step onto your private terrace and admire the tranquil ripples of the Beira Lake during the day and the undisturbed beauty of a starry sky at night",3));
        items.add(new ItemsDomain("balcanyking","Balcany King",80,"With spacious living and dining spaces, this suite offers a lifestyle of rest and pleasure. Step onto your private terrace and admire the tranquil ripples of the Beira Lake during the day and the undisturbed beauty of a starry sky at night",4));
        items.add(new ItemsDomain("balcanytwin","Balcany Twin",98,"With spacious living and dining spaces, this suite offers a lifestyle of rest and pleasure. Step onto your private terrace and admire the tranquil ripples of the Beira Lake during the day and the undisturbed beauty of a starry sky at night",2));
        return items;
    }
}