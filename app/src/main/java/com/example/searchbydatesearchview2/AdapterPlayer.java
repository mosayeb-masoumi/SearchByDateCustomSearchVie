package com.example.searchbydatesearchview2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterPlayer extends RecyclerView.Adapter<AdapterPlayer.ViewHolder> {
    ArrayList<ModelPlayers> modelPlayers,filterList;
    Context context;
    CustomFilter filter;

    public AdapterPlayer(ArrayList<ModelPlayers> modelPlayers, Context context) {
        this.modelPlayers = modelPlayers;
        this.context = context;
        this.filterList= modelPlayers;
    }

    @NonNull
    @Override
    public AdapterPlayer.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelPlayers model=modelPlayers.get(position);
        holder.txt_name.setText(model.getName());
        holder.txt_pos.setText(model.getPos());
        holder.txt_date.setText(model.getDate());
        holder.img.setImageResource(model.getImg());
//        holder.img.setImageResource(modelPlayers.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return modelPlayers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name,txt_pos,txt_date;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_name=itemView.findViewById(R.id.nameTxt);
            txt_pos=itemView.findViewById(R.id.posTxt);
            txt_date=itemView.findViewById(R.id.dateTxt);
            img=itemView.findViewById(R.id.playerImage);
        }
    }

    //RETURN FILTER OBJ
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }
        return filter;
    }
}
