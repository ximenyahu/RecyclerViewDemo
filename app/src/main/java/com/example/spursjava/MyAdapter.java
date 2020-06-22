package com.example.spursjava;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.InnerViewHolder> implements Filterable {
    ArrayList<Model> mModels, mFilterList;
    CustomFilter mCustomFilter;
    private Context mContext;

    public MyAdapter(Context context, ArrayList<Model> models) {
        mContext = context;
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
    public void onBindViewHolder(@NonNull InnerViewHolder holder, final int position) {
        holder.onBind(mModels.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AnotherActivity.class);
                intent.putExtra("title", mModels.get(position).getTitle());
                intent.putExtra("description", mModels.get(position).getDescription());
                intent.putExtra("image", mModels.get(position).getImage());
                mContext.startActivity(intent);
            }
        });
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
        private final ImageView mExpand;
        private final RelativeLayout mExpandLayout;
        private final TextView mExpandText;

        public InnerViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.row_image_view);
            mTitle = itemView.findViewById(R.id.row_title);
            mDescription = itemView.findViewById(R.id.row_description);
            mExpand = itemView.findViewById(R.id.row_expand);
            mExpandLayout = itemView.findViewById(R.id.row_expand_layout);
            mExpandText = itemView.findViewById(R.id.row_expand_text);
        }

        public void onBind(final Model model) {
            mImageView.setImageResource(model.getImage());
            mTitle.setText(model.getTitle());
            mDescription.setText(model.getDescription());
            mExpandLayout.setVisibility(model.isExpand() ? View.VISIBLE : View.GONE);
            mExpandText.setText(model.getProfile());
            mExpand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    model.setExpand(!model.isExpand());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
