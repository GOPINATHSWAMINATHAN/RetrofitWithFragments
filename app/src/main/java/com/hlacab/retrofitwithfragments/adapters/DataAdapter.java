package com.hlacab.retrofitwithfragments.adapters;

/**
 * Created by gopinath on 08/12/17.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hlacab.retrofitwithfragments.R;
import com.hlacab.retrofitwithfragments.model.DemoModel;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<DemoModel> android;
    Context context;

    public DataAdapter( Context context,List<DemoModel> android) {
this.context=context;
        this.android = android;
      for(DemoModel d:android)
      {
         Log.e("VALUE IS ",""+d.getImageUrl()) ;
      }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_main, viewGroup, false);
        ViewHolder vHolder=new ViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {


          viewHolder.image_name.setText(android.get(i).getName());
          Log.e("ONBIND VIEW HOLDER ARE",""+android.get(i).getName().toString());
            Picasso.with(context).load(android.get(i).getImageUrl()).into(viewHolder.imageView);
//            Log.e("ONBIND VIEW HOLDER",""+d.getName());
//            viewHolder.image_name.setText(d.getName());
//            Picasso.with(context).load(d.getImageUrl()).into(viewHolder.imageView);


    }

    @Override
    public int getItemCount() {
        Log.e("size value is ",""+android.size());
        return android.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView image_name;
        private ImageView imageView;
        public ViewHolder(View view) {
            super(view);
            imageView=(ImageView)view.findViewById(R.id.imageName);
            image_name = (TextView)view.findViewById(R.id.movieName);

        }
    }


}