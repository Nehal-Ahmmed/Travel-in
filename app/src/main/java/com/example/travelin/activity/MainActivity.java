package com.example.travelin.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelin.Adapters.category_adapter;
import com.example.travelin.Adapters.popularAdapter;
import com.example.travelin.R;
import com.example.travelin.domains.categoryDomain;
import com.example.travelin.domains.popularDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular, adapterCategory;
    private RecyclerView recyclerViewPopular, recyclerViewCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initRecyclerView();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initRecyclerView() {

        ArrayList<popularDomain> items=new ArrayList<>();

        items.add(new popularDomain("Mar caible, avenida Lago","This 1 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings.","Miami Beach",1,true,4.5,"pic1",false,1000));
        items.add(new popularDomain("Passo Rolle, TN","This 2 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings.","Hawaii Beach",2,true,4.8,"pic2",true,2500));
        items.add(new popularDomain("Mar caible, avenida Lago","This 3 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings.","Miami Beach",3,true,5.0,"pic3",true,5000));

        recyclerViewPopular=findViewById(R.id.view_pop);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterPopular=new popularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);

        ArrayList<categoryDomain> catslist=new ArrayList<>();

        catslist.add(new categoryDomain("cat1","Beaches"));
        catslist.add(new categoryDomain("cat2","Camps"));
        catslist.add(new categoryDomain("cat3","Forest"));
        catslist.add(new categoryDomain("cat4","Desert"));
        catslist.add(new categoryDomain("cat5","Mountain"));

        recyclerViewCategory=findViewById(R.id.view_cat);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterCategory=new category_adapter(catslist);
        recyclerViewCategory.setAdapter(adapterCategory);

    }
}