package com.laudablesolutions.cricwiz.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laudablesolutions.cricwiz.R;

public class FixturesRecyclerAdapter extends RecyclerView.Adapter<FixturesRecyclerAdapter.Holder>{

    Context context;

    public FixturesRecyclerAdapter(Context context){

        this.context=context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View row = LayoutInflater.from(context).inflate(R.layout.fixture_itemview, viewGroup, false);
        Holder holded = new Holder(row);
        return holded;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {



    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView teamA,teamB,stadium,year,month,day,pool,time;

        public Holder(View itemView) {
            super(itemView);
        }
    }
}
