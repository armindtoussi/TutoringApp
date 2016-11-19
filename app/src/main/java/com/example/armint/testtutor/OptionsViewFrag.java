package com.example.armint.testtutor;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class OptionsViewFrag extends ListFragment {

    // Variables for attempted ListView options ListView population.

    private ArrayAdapter<String> optionsAdapter;
    private ArrayList<String> options;

    //Required ctor.
    public OptionsViewFrag() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        options = new ArrayList<String>();
        options.add("Report a problem");
        options.add("Edit Profile");
        options.add("Change Password");
        options.add("Logout");

        optionsAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, options);

        setListAdapter(optionsAdapter);
        getListView().setOnItemClickListener(listHandler);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_options_view, container, false);
    }

    private AdapterView.OnItemClickListener listHandler = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();

            switch (position) {
                case 0:
                    reportProblem();
                    break;
                case 2:
                    changePassword();
                    break;
                case 3:
                    getActivity().finish();
                    break;
            }
        }
    };

    private void changePassword() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_changepassword_view);

        Button cancelButton = (Button) dialog.findViewById(R.id.changePasswordCancel);
        Button enterButton  = (Button) dialog.findViewById(R.id.changePasswordEnter);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width   = WindowManager.LayoutParams.MATCH_PARENT;

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

    private void reportProblem() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_reportproblem_view);

        Button cancelButton = (Button) dialog.findViewById(R.id.reportProblemCancel);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width  = WindowManager.LayoutParams.MATCH_PARENT;

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.getWindow().setAttributes(lp);

    }
}
