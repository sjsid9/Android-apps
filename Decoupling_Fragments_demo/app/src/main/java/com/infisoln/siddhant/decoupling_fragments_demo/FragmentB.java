package com.infisoln.siddhant.decoupling_fragments_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    String name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static FragmentB newInstance(String input) {
        Bundle args = new Bundle();
        args.putString("Name", input);
        FragmentB fragment = new FragmentB();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Intent intent = getActivity().getIntent();
        TextView textView = view.findViewById(R.id.tvDetailText);
        if (intent.hasExtra("Name")) {
            String name = intent.getStringExtra("Name");
            textView.setText(name);
        } else {
            Bundle bundle = getArguments();
            textView.setText(bundle.getString("Name"));
        }
    }
}
