package com.hlacab.retrofitwithfragments.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hlacab.retrofitwithfragments.R;
import com.hlacab.retrofitwithfragments.adapters.DataAdapter;
import com.hlacab.retrofitwithfragments.model.DemoModel;
import com.hlacab.retrofitwithfragments.model.RequestInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gopinath on 08/12/17.
 */

public class Demo extends Fragment {
    RecyclerView recylerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.recyclercheck, container, false);
        recylerView = v.findViewById(R.id.recyclerView);
        int numberOfColumns = 2;
        recylerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        Toast.makeText(getActivity(), "FRAGMENT ACTIVITY", Toast.LENGTH_LONG).show();
        getValue();
        return v;

    }


    public void getValue() {
        final List<String> demo = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RequestInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        RequestInterface api = retrofit.create(RequestInterface.class);

        Call<List<DemoModel>> call = api.getHeroes();

        call.enqueue(new Callback<List<DemoModel>>() {
            @Override
            public void onResponse(Call<List<DemoModel>> call, Response<List<DemoModel>> response) {

                List<DemoModel> heroes = response.body();
                for (DemoModel d : heroes) {

                    demo.add(d.getName());

                    Log.d("name", "" + d.getName());
                    Log.d("imageUrl", "" + d.getImageUrl());

                }

                DataAdapter dd = new DataAdapter(getActivity(),heroes);
                recylerView.setAdapter(dd);

            }

            @Override
            public void onFailure(Call<List<DemoModel>> call, Throwable t) {

            }
        });

    }


}
