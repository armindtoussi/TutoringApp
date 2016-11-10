package com.example.armint.testtutor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.ListFragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * This class is the fragments that will contain "matches"
 * as a list fragment activity, which is nested into the UserView
 * activity that frames it.
 *
 * This is the first tab and will contain the matches for the user or student that
 * needs help, matched to a tutor.
 */
public class TutorViewFrag extends ListFragment {
    protected String[] people = {"Armin Toussi", "Brandon Gillespie", "Justin Chun", "D'arcy Smith",
            "Albert Chen", "Joanne idunno", "Jen whateva!", "Johno robo",
            "Alex Smith", "Dave Meowmoth", "Logan Borean", "Iksoo KoreaTown",
            "Another Person", "Some Other Person",
            "Whatever", "tired", "right", "now",
            "shit"};
    // we'll need to limit the amount of characters that we're tkaing in .
    protected String[] descrip = {"Armin's a pretty sweet person, learn from him.",
            "Brandon's a pretty sweet person, learn from him.",
            "Justin's a pretty sweet person, learn from him.",
            "D'arcy's a pretty sweet person, learn from him.",
            "Albert's a pretty sweet person, learn from him.",
            "Joanne's a pretty sweet person, learn from him.",
            "Jen's a pretty sweet person, learn from him.",
            "Johno's a pretty sweet person, learn from him.",
            "Alex's a pretty sweet person, learn from him.",
            "Dave's a pretty sweet person, learn from him.",
            "Logan's a pretty sweet person, learn from him.",
            "Iksoo's a pretty sweet person, learn from him.",
            "Another's a pretty sweet person, learn from him.",
            "Some's a pretty sweet person, learn from him.",
            "Whatever's a pretty sweet person, learn from him.",
            "Tired's a pretty sweet person, learn from him.",
            "Right's a pretty sweet person, learn from him.",
            "Now's a pretty sweet person, learn from him.",
            "Shit's a pretty sweet person, learn from him."};

    //required ctor.
    public TutorViewFrag() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TutorArrayAdapter adapter = new TutorArrayAdapter(getActivity(), 0, people, descrip);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(listHandler);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tutor_view, container, false);
    }

    //adpater for the listview. detects clicks and sich
    private AdapterView.OnItemClickListener listHandler = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        }
    };
}

