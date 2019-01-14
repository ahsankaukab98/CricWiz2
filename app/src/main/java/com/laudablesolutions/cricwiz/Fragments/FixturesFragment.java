package com.laudablesolutions.cricwiz.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laudablesolutions.cricwiz.Adapters.FixturesRecyclerAdapter;
import com.laudablesolutions.cricwiz.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FixturesFragment extends Fragment {

    @BindView(R.id.rv_fixture_matches)
    RecyclerView fixturesRecyclerView;

    private FixturesRecyclerAdapter fixturesRecyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fixtures, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fixturesRecyclerAdapter=new FixturesRecyclerAdapter(getActivity());
        fixturesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fixturesRecyclerView.setAdapter(fixturesRecyclerAdapter);
    }
}
