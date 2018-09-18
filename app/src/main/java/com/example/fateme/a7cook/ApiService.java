package com.example.fateme.a7cook;

import android.app.DownloadManager;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.Volley;
import com.example.fateme.a7cook.data.Banner;
import com.example.fateme.a7cook.data.Category;
import com.example.fateme.a7cook.data.Recipe;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Method;
import java.util.List;

public class ApiService {

private Context context;

public ApiService(Context context){

    this.context=context;
}
    public void getRecipes(Response.Listener<List<Recipe>> bannerListener){
       GsonRequest<List<Recipe>> recipeGsonRequest= new GsonRequest<>(Request.Method.GET,
               "https://api.myjson.com/bins/n7bxs",
               new TypeToken<List<Recipe>>() {
               }.getType(),
               bannerListener,
               new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {

                   }
               }
       );
        Volley.newRequestQueue(context).add(recipeGsonRequest);
    }

    public void getCategories(Response.Listener<List<Category>> categoryListener){
        GsonRequest<List<Category>> categortGsonRequest= new GsonRequest<>(Request.Method.GET,
                "https://api.myjson.com/bins/n7bxs",
                new TypeToken<List<Category>>() {
                }.getType(),
                categoryListener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        Volley.newRequestQueue(context).add(categortGsonRequest);
    }

    public void getBanners(Response.Listener<List<Banner>> bannerListener){
        GsonRequest<List<Banner>> bannerGsonRequest= new GsonRequest<>(Request.Method.GET,
                "https://api.myjson.com/bins/110sw0",
                new TypeToken<List<Banner>>() {
                }.getType(),
                bannerListener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        Volley.newRequestQueue(context).add(bannerGsonRequest);
    }
}
