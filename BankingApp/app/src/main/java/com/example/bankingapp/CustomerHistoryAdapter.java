package com.example.bankingapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerHistoryAdapter extends RecyclerView.Adapter<ViewHolder> {

    History history;
    List<Customer> historyList;

    TextView mTransc_status;

    public CustomerHistoryAdapter(List<Customer> historyList, History history) {
        this.history = history;
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_list, parent, false);

        mTransc_status = itemView.findViewById(R.id.transaction_status);

        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener(){
            @Override
            public void onItemClick(View view, int position) {

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Customer customer = historyList.get(position);
        holder.cName1.setText(customer.getName1());
        holder.cName2.setText(customer.getName2());
        holder.cDate.setText(customer.getDate());
        holder.cBalance.setText(customer.getBalance());
        holder.cTransc_status.setText(customer.getTransaction_status());

        if(customer.getTransaction_status().equals("Failed")){
            holder.cTransc_status.setTextColor(Color.parseColor("#f40404"));
        }else{
            holder.cTransc_status.setTextColor(Color.parseColor("#4BB543"));
        }
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

}
