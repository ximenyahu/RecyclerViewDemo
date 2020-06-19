package com.example.spursjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.InnerViewHolder> implements Filterable {
    ArrayList<Model> mModels, mFilterList;
    CustomFilter mCustomFilter;

    public MyAdapter(ArrayList<Model> models) {
        this.mModels = models;
        this.mFilterList = models;
    }

    @NonNull
    @Override
    public InnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new InnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerViewHolder holder, int position) {
        holder.onBind(mModels.get(position));
    }

    @Override
    public int getItemCount() {
        return mModels.size();
    }

    @Override
    public Filter getFilter() {
        if (mCustomFilter == null) {
            mCustomFilter = new CustomFilter(mModels, this);
        }
        return mCustomFilter;
    }

    public class InnerViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImageView;
        private final TextView mTitle;
        private final TextView mDescription;

        public InnerViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.row_image_view);
            mTitle = itemView.findViewById(R.id.row_title);
            mDescription = itemView.findViewById(R.id.row_description);
        }

        public void onBind(Model model) {
            mImageView.setImageResource(model.getImage());
            mTitle.setText(model.getTitle());
            mDescription.setText(model.getDescription());
        }

    }
}
