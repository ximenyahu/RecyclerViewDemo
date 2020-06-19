package com.example.spursjava;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {
    private static final String TAG = "CustomFilter";

    private ArrayList<Model> mFilterList;
    private MyAdapter mMyAdapter;

    public CustomFilter(ArrayList<Model> filterList, MyAdapter myAdapter) {
        mFilterList = filterList;
        mMyAdapter = myAdapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults = new FilterResults();
        if (constraint != null && constraint.length() > 0) {
            constraint = constraint.toString().toUpperCase();
            ArrayList<Model> filterModels = new ArrayList<>();
            for (int i = 0; i < mFilterList.size(); i++) {
                if (mFilterList.get(i).getTitle().toUpperCase().contains(constraint)) {
                    filterModels.add(mFilterList.get(i));
                }
            }
            filterResults.count = filterModels.size();
            filterResults.values = filterModels;
        } else {
            filterResults.count = mFilterList.size();
            filterResults.values = mFilterList;
        }
        return filterResults;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        mMyAdapter.mModels = (ArrayList<Model>) results.values;
        mMyAdapter.notifyDataSetChanged();
    }
}
