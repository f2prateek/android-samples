package com.f2prateek;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    private static String TAG = "HelloAndroidActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void startRecyclingListActivity(View v) {
        Intent i = new Intent(this, RecyclingListActivity.class);
        startActivity(i);
    }

}

