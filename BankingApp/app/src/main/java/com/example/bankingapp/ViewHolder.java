package com.example.bankingapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView cName, cPhonenumber, cBalance, cRupee, cRupeeslash, cName1, cName2, cDate, cTransc_status;
    ImageView cArrow;
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;

        cName = itemView.findViewById(R.id.txtUserName);
        cPhonenumber = itemView.findViewById(R.id.txtPhone);
        cBalance = itemView.findViewById(R.id.balance);
        cRupee = itemView.findViewById(R.id.rupee);
        cRupeeslash = itemView.findViewById(R.id.rupeeslash);
       // mPhone = itemView.findViewById(R.id.phone);
        cName1 = itemView.findViewById(R.id.name1);
        cName2 = itemView.findViewById(R.id.name2);
        cDate = itemView.findViewById(R.id.date);
        cArrow = itemView.findViewById(R.id.arrow);
        cTransc_status = itemView.findViewById(R.id.transaction_status);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

    }
    private ViewHolder.ClickListener mClickListener;
    public interface  ClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
       mClickListener = clickListener;
    }
}
