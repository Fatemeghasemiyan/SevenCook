package com.example.fateme.a7cook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fateme.a7cook.R;
import com.example.fateme.a7cook.data.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Category> categories;

    public CategoryAdapter(List<Category> categories){

        this.categories = categories;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(categoryView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bindCategory(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private ImageView categoryIcon;
        private TextView categoryTitle;
        public CategoryViewHolder(View itemView) {
            super(itemView);
            categoryIcon=itemView.findViewById(R.id.iv_category_icon);
            categoryTitle=itemView.findViewById(R.id.tv_category_title);

        }
        public  void bindCategory(Category category){
            categoryTitle.setText(category.getTitle());
            Picasso.get().load(category.getImg()).into(categoryIcon);
        }
    }
}
