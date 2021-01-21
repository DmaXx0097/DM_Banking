package com.example.bankingapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Customer> allCust = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CustomerAdapter adapter;

    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        showData();
    }

    private void showData() {
        allCust.clear();
        Cursor cursor = new DatabaseHelper(this).readalldata();
        while(cursor.moveToNext()){
            String balancefromdb = cursor.getString(2);
            Double balance = Double.parseDouble(balancefromdb);

            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setGroupingUsed(true);
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);
            String price = nf.format(balance);

            Customer customer = new Customer(cursor.getString(0), cursor.getString(1), price);
            allCust.add(customer);
        }

        adapter = new CustomerAdapter(allCust, MainActivity.this);
        recyclerView.setAdapter(adapter);

    }

    public void nextActivity(int position) {
        phoneNumber = allCust.get(position).getPhoneno();
        Intent intent = new Intent(MainActivity.this, UserDetail.class);
        intent.putExtra("phonenumber",phoneNumber);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_history, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_history){
            startActivity(new Intent(MainActivity.this, History.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

