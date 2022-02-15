package com.example.homework33;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FourthFragment extends Fragment {
    private TextView fourth_textview;
    private Button fourth_button;
    String string;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        string = getArguments().getString("text3");
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fourth_textview = view.findViewById(R.id.tv_fourth);
        fourth_button = view.findViewById(R.id.btn_fourth);

        fourth_textview.setText(string);

        fourth_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle1 = new Bundle();
                bundle1.putString("text4", fourth_textview.getText().toString());
                Fragment fragment = new FifthFragment();
                fragment.setArguments(bundle1);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.first_container,
                        fragment).addToBackStack("").commit();
            }
        });
    }
}