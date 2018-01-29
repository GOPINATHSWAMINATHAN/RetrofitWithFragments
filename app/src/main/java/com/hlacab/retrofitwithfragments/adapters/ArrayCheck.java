package com.hlacab.retrofitwithfragments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.hlacab.retrofitwithfragments.R;

import java.util.ArrayList;

/**
 * Created by gopinath on 28/01/18.
 */

public class ArrayCheck extends BaseAdapter {

    Context context;
    String al[];
    LayoutInflater inflater;

    public ArrayCheck(Context context, String ap[])
    {
        this.context=context;
        this.al=ap;
        inflater=(LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return al.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    TextView country;
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.array_view,null);
        country=convertView.findViewById(R.id.textCheck);

        country.setText(al[position]);
        country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,""+al[position].toString(),Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }
}
