package com.example.armint.testtutor;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class OptionsViewFrag extends Fragment {

    // Variables for attempted ListView options ListView population.
    /*
    private ArrayAdapter<String> optionsAdapter;
    private ArrayList<String> options;
    private ListView lv; */

    //Required ctor.
    public OptionsViewFrag() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // At this current moment, this code does not break anything, but it also does it do its
        // required function of populating the options ListView. I tried to understand and implement
        // this based off of other ListView but didn't quite get it. I must now move onto other things,
        // we can discuss on this week.
        /*
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_options_view, null);

        lv = (ListView)view.findViewById(R.id.optionList);
        options = new ArrayList<String>();
        options.add("Invite Friends");
        options.add("Report a problem");
        options.add("Edit Profile");
        options.add("Change Password");
        options.add("Logout");

        optionsAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, options);

        lv.setAdapter(optionsAdapter); */

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_options_view, container, false);
    }
}
