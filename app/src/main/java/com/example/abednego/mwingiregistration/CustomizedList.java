package com.example.abednego.mwingiregistration;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by abednego on 8/12/17.
 */

public class CustomizedList extends RecyclerView.Adapter<CustomizedList.VIewElements> {
    @Override
    public VIewElements onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VIewElements holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VIewElements extends RecyclerView.ViewHolder {

        public VIewElements(View itemView) {
            super(itemView);

        }
    }
}
