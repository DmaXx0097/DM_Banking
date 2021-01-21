package com.example.bankingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomerTransAdapter extends RecyclerView.Adapter<ViewHolder> {

    Transfer transfer;
    List<Customer> transferToList;

    public CustomerTransAdapter(Transfer transfer, List<Customer> transferToList) {
        this.transfer = transfer;
        this.transferToList = transferToList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_users, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                transfer.selectuser(position);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Customer customer = transferToList.get(position);
        holder.cName.setText(customer.getName());
        holder.cPhonenumber.setText(customer.getPhoneno());
        holder.cBalance.setText(customer.getBalance());
    }

    @Override
    public int getItemCount() {
        return transferToList.size();
    }

    public void setFilter(ArrayList<Customer> newList){
        transferToList = new ArrayList<>();
        transferToList.addAll(newList);
        notifyDataSetChanged();
    }

}
