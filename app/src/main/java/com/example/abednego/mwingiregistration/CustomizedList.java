package com.example.abednego.mwingiregistration;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by abednego on 8/12/17.
 */

public class CustomizedList extends RecyclerView.Adapter<CustomizedList.VIewElements> {

    Context context;
    List<PersonDetails> personDetailsList;

    public CustomizedList(Context g_coContext, List<PersonDetails> g_personDetailsList) {
        this.context = g_coContext;
        this.personDetailsList = g_personDetailsList;
    }

    @Override
    public VIewElements onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.recycler_custom_view, null);
        VIewElements viewElements = new VIewElements(v);


        return viewElements;
    }

    @Override
    public void onBindViewHolder(VIewElements holder, int position) {
        PersonDetails personDetails = personDetailsList.get(position);

        holder.full_names_tv.setText(personDetails.getString_first_name() + " "
                + personDetails.getString_second_name());
        holder.church_name_tv.setText(personDetails.getString_home_church());
    }

    @Override
    public int getItemCount() {
        return personDetailsList.size();
    }

    public class VIewElements extends RecyclerView.ViewHolder {
        AppCompatTextView full_names_tv, church_name_tv;

        public VIewElements(View itemView) {
            super(itemView);
            full_names_tv = itemView.findViewById(R.id.registered_full_names);
            church_name_tv = itemView.findViewById(R.id.registered_home_church);

        }
    }
}
