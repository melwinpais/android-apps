package com.pais.christening;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        ImageView sam1 = (ImageView) findViewById(R.id.imageView);
        ImageView sam3 = (ImageView) findViewById(R.id.imageView2);
        sam1.animate().alpha(0f).setDuration(2000);
        sam3.animate().alpha(1f).setDuration(2000);
        sam1.setVisibility(View.INVISIBLE);
        sam3.setVisibility(View.VISIBLE);
        Log.i("info", "Tapped 1");
    }
    public void onClick2(View view) {
        ImageView sam1 = (ImageView) findViewById(R.id.imageView);
        ImageView sam3 = (ImageView) findViewById(R.id.imageView2);
        sam3.animate().alpha(0f).setDuration(2000);
        sam1.animate().alpha(1f).setDuration(2000);
        sam1.setVisibility(View.VISIBLE);
        sam3.setVisibility(View.INVISIBLE);
        Log.i("info", "Tapped 2");
    }
}
