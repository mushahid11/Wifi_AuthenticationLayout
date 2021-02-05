package com.example.wifiauthentication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class ApplyFragment extends Fragment {
    public static SharedPreferences preferences;

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    public  List<String> moviesList;
    public ApplyFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate( R.layout.fragment_apply, container, false );
        preferences = requireActivity().getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        TextView textView = (TextView) view.findViewById( R.id.date );
        Spannable word = new SpannableString( "21.9" );

        word.setSpan( new ForegroundColorSpan( Color.RED ), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE );
        textView.setText( word );
        Spannable word1 = new SpannableString( "/" );
        //word1.setSpan( new ForegroundColorSpan( Color.BLUE), 0, word1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE );
        textView.append( word1 );
        Spannable word2 = new SpannableString( "23:9" );
        word2.setSpan( new ForegroundColorSpan( Color.BLACK), 0, word2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE );
        textView.append( word2 );



        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("JUN");
        animalNames.add("|");
        animalNames.add("JUL");
        animalNames.add("|");
        animalNames.add("AUG");
        animalNames.add("|");
        animalNames.add("SEP");
        animalNames.add("|");
        animalNames.add("OCT");
        animalNames.add("|");
        animalNames.add("NOV");
        animalNames.add("|");
        animalNames.add("DEC");


        // set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerVieww);
        //recyclerView.setLayoutManager(new LinearLayoutManager(ApplyFragment.this));
     RecyclerAdapter   adapter = new RecyclerAdapter(this, animalNames);
        recyclerView.setAdapter(adapter);



        return view;
    }
}