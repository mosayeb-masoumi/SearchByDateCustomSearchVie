package com.example.searchbydatesearchview2;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {


    AdapterPlayer adapter;
    ArrayList<ModelPlayers> filterList;

    public CustomFilter( ArrayList<ModelPlayers> filterList,AdapterPlayer adapter) {
        this.adapter = adapter;
        this.filterList = filterList;
    }



    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if (constraint != null && constraint.length() > 0){

            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<ModelPlayers> filteredModelPlayers =new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getName().toUpperCase().contains(constraint))// filter by date or name or...
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredModelPlayers.add(filterList.get(i));
                }
            }
            results.count= filteredModelPlayers.size();
            results.values= filteredModelPlayers;

        }else{
            results.count=filterList.size();
            results.values=filterList;
        }

        return  results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.modelPlayers = (ArrayList<ModelPlayers>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();
    }
}
