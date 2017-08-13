package com.example.abednego.mwingiregistration;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class List extends Fragment {
    LocalDB localDB;
    AppCompatButton btn_show_list;
    RecyclerView register_recycler_list;
    LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        localDB = new LocalDB(getContext());
        View view = inflater.inflate(R.layout.fragment_list, null);
        xml_elements(view);

        btn_show_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor values = localDB.get_all_data();
                StringBuffer stringBuffer = new StringBuffer();
                while (values.moveToNext()) {

                    Toast.makeText(getContext(), values.getString(1) + " " + values.getString(2), Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

    private void xml_elements(View view) {
        btn_show_list = view.findViewById(R.id.btn_show_list);
        register_recycler_list = view.findViewById(R.id.registered_recy_list);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        register_recycler_list.setLayoutManager(linearLayoutManager);
        register_recycler_list.setHasFixedSize(true);
    }


}
