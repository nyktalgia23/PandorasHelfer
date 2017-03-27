package com.apocalypticarts.pandorashelfer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventarFragment extends Fragment {

    private Button mButtonSendData;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference testRef = database.getReference().child("messages");
    DatabaseReference testRef2 = database.getReference("testmessage");

    public InventarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventar, container, false);


        mButtonSendData = (Button) view.findViewById(R.id.buttonSendData);

        mButtonSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentDateTimeString = DateFormat.getTimeInstance().format(new java.util.Date());



                testRef.setValue(currentDateTimeString);
                testRef2.setValue(currentDateTimeString);
            }
        });


        return view;
    }

}
