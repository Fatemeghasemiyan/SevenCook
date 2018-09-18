package com.example.fateme.a7cook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

import com.android.volley.Response;
import com.example.fateme.a7cook.adapters.BannerAdapter;
import com.example.fateme.a7cook.adapters.CategoryAdapter;
import com.example.fateme.a7cook.data.Banner;
import com.example.fateme.a7cook.data.Category;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiService=new ApiService(this);
        setupViews();

//

    }

    private void setupViews() {
        getBanners();
        getCategories();
    }

    private void getCategories() {
        apiService.getCategories(new Response.Listener<List<Category>>() {
            @Override
            public void onResponse(List<Category> response) {
            RecyclerView categoryRecyclerView=findViewById(R.id.rv_main_categories);
            categoryRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
            categoryRecyclerView.setAdapter(new CategoryAdapter(response));


            }
        });
    }

    private void getBanners(){
        apiService.getBanners(new Response.Listener<List<Banner>>() {
            @Override
            public void onResponse(List<Banner> response) {
                RecyclerView recyclerView=findViewById(R.id.rv_main_slider);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                recyclerView.setAdapter(new BannerAdapter(response));
                SnapHelper snapHelper=new PagerSnapHelper();
                snapHelper.attachToRecyclerView(recyclerView);
                }
        });
    }
}
