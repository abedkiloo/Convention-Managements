package com.example.abednego.mwingiregistration.fragments;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.abednego.mwingiregistration.R;
import com.example.abednego.mwingiregistration.database.LocalDB;

public class Register extends Fragment {
    LocalDB localDB;
    TextInputEditText edit_first_name, edit_second_name, edit_home_church, edit_amount_paid;
    RadioGroup gender_radio_group, border_radio_group;
    String string_first_name, string_second_name, string_home_church,
            string_amount_paid, string_gender, string_border_state, string_age_group;

    AppCompatButton btn_register;
    CheckBox below_18, above_18;
    FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, null);

        fragmentManager=getActivity().getSupportFragmentManager();

        localDB = new LocalDB(getContext());
        xml_elements(view);

        gender_radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                View view1 = radioGroup.findViewById(i);
                string_gender = ((RadioButton) view1).getText().toString();
//                Toast.makeText(getContext(), ((RadioButton) view1).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        border_radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                View view2 = radioGroup.findViewById(i);
                string_border_state = ((RadioButton) view2).getText().toString();

            }
        });

        below_18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                Toast.makeText(getContext(),compoundButton.getText(), Toast.LENGTH_SHORT).show();
                string_age_group = compoundButton.getText().toString();
                above_18.setChecked(false);
            }
        });
        above_18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                Toast.makeText(getContext(),compoundButton.getText(), Toast.LENGTH_SHORT).show();
                string_age_group = compoundButton.getText().toString();
                below_18.setChecked(false);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                string_first_name = edit_first_name.getText().toString();
                string_second_name = edit_second_name.getText().toString();
                string_home_church = edit_home_church.getText().toString();
                string_amount_paid = edit_amount_paid.getText().toString();

                Boolean result = localDB.insert_values(string_first_name, string_second_name, string_gender,
                        string_age_group, string_home_church, string_border_state, string_amount_paid);
                if (result) {
                    Toast.makeText(getContext(), "Registered " + string_first_name + " " + string_second_name, Toast.LENGTH_SHORT).show();
                    edit_first_name.setText("");
                    edit_second_name.setText("");
                    edit_home_church.setText("");
                    edit_amount_paid.setText("");

                    fragmentManager.beginTransaction().replace(R.id.content,new RegisteredList()).commit();

                } else {
                    Toast.makeText(getContext(), string_first_name + " " + string_second_name + " not registered", Toast.LENGTH_SHORT).show();

                }
            }
        });

        return view;
    }

    private void xml_elements(View view) {
        edit_first_name = view.findViewById(R.id.edit_first_name);
        edit_second_name = view.findViewById(R.id.edit_second_name);
        edit_home_church = view.findViewById(R.id.edit_fhome_church);
        edit_amount_paid = view.findViewById(R.id.edit_amount_paid);
        gender_radio_group = view.findViewById(R.id.layout_radio_gender);
        border_radio_group = view.findViewById(R.id.layout_radio_border_state);

        btn_register = view.findViewById(R.id.btnRegister);

        below_18 = view.findViewById(R.id.check_below_18);
        above_18 = view.findViewById(R.id.check_above_18);
    }


}
