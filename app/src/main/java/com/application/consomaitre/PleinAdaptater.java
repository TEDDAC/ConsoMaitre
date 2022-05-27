package com.application.consomaitre;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.Plein;

public class PleinAdaptater extends RecyclerView.Adapter<PleinAdaptater.ViewHolder> {
    private ArrayList<Plein> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView)view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public PleinAdaptater(ArrayList<Plein> pleins){
        this.localDataSet = pleins;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.plein_card,parent, false);
        Log.d("PleinAdaptater","onCreateViewHolder");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plein current = localDataSet.get(position);
        holder.getTextView().setText(current.toString());
        Log.d("PleinAdaptater","onBindViewHolder");
    }

    @Override
    public int getItemCount(){
        return localDataSet.size();
    }
}
