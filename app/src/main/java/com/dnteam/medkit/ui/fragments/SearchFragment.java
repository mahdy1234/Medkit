package com.dnteam.medkit.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dnteam.medkit.R;
import com.dnteam.medkit.ui.activities.BookHomeVisitActivity;
import com.dnteam.medkit.ui.activities.HomeActivity;
import com.dnteam.medkit.util.NavigationControl;

public class SearchFragment extends Fragment {
    Button button;
    View view;
    Button bookHomeVisitButton;
    Button pharmacyButton;
    Button offersButton;

    public SearchFragment() {
        // Required empty public constructor
    }


    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        initComponents();
        initListeners();

        return view;
    }

    private void initComponents() {

        bookHomeVisitButton = view.findViewById(R.id.book_home_visit_button);
        pharmacyButton = view.findViewById(R.id.pharmacy_button);
        offersButton = view.findViewById(R.id.offers_button);
    }

    private void initListeners() {



        offersButton.setOnClickListener((cl) -> {
            NavigationControl.getHomePageBottomNav(getActivity()).setSelectedItemId(R.id.offers);
            NavigationControl.getHomePageNavController(getActivity()).navigate(R.id.offers_fragment);
        });
        bookHomeVisitButton.setOnClickListener((cl) -> {
            Intent i = new Intent(getContext(), BookHomeVisitActivity.class);
            startActivity(i);
        });
        pharmacyButton.setOnClickListener((cl) -> {
            NavigationControl.getHomePageBottomNav(getActivity()).setSelectedItemId(R.id.pharmacy);
            NavigationControl.getHomePageNavController(getActivity()).navigate(R.id.pharmacy_fragment);
        });

    }


}