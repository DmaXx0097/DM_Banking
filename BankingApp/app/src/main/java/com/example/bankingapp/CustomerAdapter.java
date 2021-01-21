package com.example.bankingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<ViewHolder> {

    MainActivity mainActivity;
    List<Customer> customerList;

    public CustomerAdapter(List<Customer> customerList, MainActivity mainActivity) {

        this.mainActivity = mainActivity;
        this.customerList = customerList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_users, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mainActivity.nextActivity(position);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Customer customer = customerList.get(position);
        holder.cName.setText(customer.getName());
        holder.cPhonenumber.setText(customer.getPhoneno());
        holder.cBalance.setText(customer.getBalance());

    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

}
