package com.miguel_santos.com.example.appfinancas.model;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.miguel_santos.com.example.appfinancas.R;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;


public class Expense extends Item<ViewHolder> {

    private String title;
    private String date;
    private int ic_type_expense;
    private String price;

    public Expense(String title, String date, int ic_type_expense, String price) {
        this.title = title;
        this.date = date;
        this.ic_type_expense = ic_type_expense;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public int getIc_type_expense() {
        return ic_type_expense;
    }

    public String getPrice() {
        return price;
    }


    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {
        TextView txtTitle = viewHolder.itemView.findViewById(R.id.txt_title);
        txtTitle.setText(getTitle());

        TextView txtDate = viewHolder.itemView.findViewById(R.id.txt_date);
        txtDate.setText(getDate());

        ImageView imgIcExpenseType = viewHolder.itemView.findViewById(R.id.img_type_expense);
        imgIcExpenseType.setImageResource(getIc_type_expense());

        TextView txtPrice = viewHolder.itemView.findViewById(R.id.txt_price);
        txtPrice.setText(getPrice());
    }

    @Override
    public int getLayout() {
        return R.layout.item_expense;
    }
    
}
