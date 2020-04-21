package com.gdg.bhopal.covid19trackerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustumAdapter extends RecyclerView.Adapter<CustumAdapter.ViewHolder> {

LayoutInflater inflater;
List<Usrdata> usrdata;

        public CustumAdapter(Context  context,List<Usrdata> usrdata)
        {
           this.inflater=LayoutInflater.from(context);
           this.usrdata=usrdata;

        }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view=inflater.inflate(R.layout.designlayot,parent,false);
     return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            //bind data
        holder.state.setText(usrdata.get(position).getState());
        holder.recover.setText(usrdata.get(position).getRecover());
        holder.death.setText(usrdata.get(position).getDeath());
        holder.confern.setText(usrdata.get(position).getConferm());
        holder.active.setText(usrdata.get(position).getActive());

    }

    @Override
    public int getItemCount() {
        return usrdata.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView state,active,confern,death,recover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            state=itemView.findViewById(R.id.state);
            active=itemView.findViewById(R.id.active);
            confern=itemView.findViewById(R.id.listcnfurme);
            death=itemView.findViewById(R.id.listdeath);
            recover=itemView.findViewById(R.id.listrecover);
        }
    }
}
