package com.example.a402;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapter extends ArrayAdapter {
    private String[] productNames;
    private String[] productQuantity;
    private Integer[] imageid;
    private Activity context;

    public CustomAdapter(Activity context, String[] prodNames, String[] prodQuant, Integer[] imageid) {
        super(context, R.layout.row_item, prodNames);
        this.context = context;
        this.productNames = prodNames;
        this.productQuantity = prodQuant;
        this.imageid = imageid;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_item, null, true);
        TextView textViewProduct = (TextView) row.findViewById(R.id.textViewProduct);
        TextView textViewQuantity = (TextView) row.findViewById(R.id.textViewQuantity);
        ImageView imageProduct = (ImageView) row.findViewById(R.id.imageViewProduct);

        textViewProduct.setText(productNames[position]);
        textViewQuantity.setText("Stock: " + productQuantity[position]);
        imageProduct.setImageResource(imageid[position]);
        return  row;
    }
}