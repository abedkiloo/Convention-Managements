package com.example.abednego.mwingiregistration;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RegisteredList extends Fragment {
    LocalDB localDB;
    AppCompatButton btn_show_list;
    RecyclerView register_recycler_list;
    LinearLayoutManager linearLayoutManager;
    TextInputEditText searching_user;
    List<PersonDetails> personDetailsList;
    CustomizedList customizedList;
    PersonDetails personDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        localDB = new LocalDB(getContext());
        View view = inflater.inflate(R.layout.fragment_registered_list, null);
        xml_elements(view);

        personDetailsList = new ArrayList<>();
        customizedList = new CustomizedList(getContext(), personDetailsList);
        register_recycler_list.setAdapter(customizedList);


//        btn_show_list.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cursor values = localDB.get_all_data();
//                StringBuffer stringBuffer = new StringBuffer();
//                while (values.moveToNext()) {
//
//                    Toast.makeText(getContext(), values.getString(1) + " " + values.getString(2), Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });

        populate_list();

        searching_user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (charSequence.length() < 0) {
//                    populate_list();
//                }
                searching_list(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }

    private void searching_list(String s) {
        List<PersonDetails> temp = new ArrayList<>();
        for (PersonDetails detas : personDetailsList) {

            if (detas.getString_second_name().toLowerCase().contains(s)) {
                temp.add(detas);
            }

        }
        customizedList.update_list(temp);


    }

    private void populate_list() {

        Cursor values = localDB.get_all_data();

        while (values.moveToNext()) {

            personDetails = new PersonDetails();
            personDetails.setString_first_name(values.getString(values.getColumnIndex("First_Name")));
            personDetails.setString_second_name(values.getString(values.getColumnIndex("Second_Name")));
            personDetails.setString_home_church(values.getString(values.getColumnIndex("Home_Church")));
            personDetails.setString_border_state(values.getString(values.getColumnIndex("Border_state")));

            personDetailsList.add(personDetails);

        }
        customizedList.notifyDataSetChanged();


    }

    private void xml_elements(View view) {
//        btn_show_list = view.findViewById(R.id.btn_show_list);
        register_recycler_list = view.findViewById(R.id.registered_recy_list);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        register_recycler_list.setLayoutManager(linearLayoutManager);
        register_recycler_list.setHasFixedSize(true);

        searching_user = view.findViewById(R.id.edit_search_criteria);


    }


}
