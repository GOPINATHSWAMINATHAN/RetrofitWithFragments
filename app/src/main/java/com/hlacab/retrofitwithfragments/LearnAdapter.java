package com.hlacab.retrofitwithfragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hlacab.retrofitwithfragments.adapters.ArrayCheck;

import java.util.ArrayList;

/**
 * Created by gopinath on 28/01/18.
 */

public class LearnAdapter extends Activity {

    ArrayList al;
    ListView lv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_adapter);
        lv = findViewById(R.id.myListView);
        al = new ArrayList();
        al.add("Gopinath");
        al.add("Fadal");
        al.add("Manickam");
        al.add("Kamran");

        String arr[] = {};
        arr = (String[]) al.toArray(new String[al.size()]);

        ArrayCheck check = new ArrayCheck(getApplicationContext(), arr);

        lv.setAdapter((check));

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (al.get(position) == "Fadal")
//                    Toast.makeText(getApplicationContext(), "" + al.get(position), Toast.LENGTH_LONG).show();
//
//            }
//        });


    }

}
