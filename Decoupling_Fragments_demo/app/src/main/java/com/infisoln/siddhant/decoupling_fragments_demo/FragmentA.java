package com.infisoln.siddhant.decoupling_fragments_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText editText = view.findViewById(R.id.etText);
        Button btnSubmit = view.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getActivity().findViewById(R.id.container)==null){
                    Intent intent = new Intent(getActivity(),DetailActivity.class);
                    intent.putExtra("Name",editText.getText().toString());
                    startActivity(intent);
                }else{
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    fm.beginTransaction()
                            .replace(R.id.container,new FragmentB(editText.getText().toString()))
                            .commit();
                }


            }
        });


    }

}
