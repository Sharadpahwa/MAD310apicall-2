package com.example.mad_310apicall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Listadapt extends BaseAdapter {

    Context c;
    ArrayList<Products> prols;

    LayoutInflater inflater;

    public Listadapt(Context c, ArrayList<Products> prols) {
        this.c = c;
        this.prols = prols;
    }

    @Override
    public int getCount() {
        return prols.size();
    }

    @Override
    public Object getItem(int position) {
        return prols.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
        {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.lstitem,parent,false);
        }


        ImageView img = convertView.findViewById(R.id.img_product);
        TextView txtnm = convertView.findViewById(R.id.txt_product);

        Picasso.get().load(prols.get(position).getPimgurl()).into(img);
        txtnm.setText(prols.get(position).getPproname());


        return convertView;
    }
}
