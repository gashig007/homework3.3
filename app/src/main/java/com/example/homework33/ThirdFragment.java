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

public class ThirdFragment extends Fragment {
    private TextView third_textview;
    private Button third_button;
    String string;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        string = getArguments().getString("text2");

        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        third_textview = view.findViewById(R.id.tv_third);
        third_button = view.findViewById(R.id.btn_third);

        third_textview.setText(string);
        third_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle1 = new Bundle();
                bundle1.putString("text3", third_textview.getText().toString());
                Fragment fragment = new FourthFragment();
                fragment.setArguments(bundle1);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.first_container,
                        fragment).addToBackStack(null).commit();
            }
        });
    }
}