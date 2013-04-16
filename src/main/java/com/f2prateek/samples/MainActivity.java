package com.f2prateek.samples;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private static final String TAG = "HelloAndroidActivity";
    private static final String[] SAMPLE_LIST = {"ListView Recycling"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, SAMPLE_LIST));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent;
        switch (position) {
            default:
            case 0:
                intent = new Intent(this, RecyclingViewListActivity.class);
                break;
        }
        startActivity(intent);
    }

}

