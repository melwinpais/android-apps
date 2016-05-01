package com.pais.checkguess;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

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
        String message = "Nah! Try again...";

        EditText editTextRange = (EditText) findViewById(R.id.textNumberRange);
        EditText editTextNumber = (EditText) findViewById(R.id.textNumber);

        int range = 0;
        if((null == editTextRange.getText()) || (editTextRange.getText().toString().isEmpty())) {
            message = "Range cannot be empty. Try again!";
            editTextRange.setText("10");
        } else {
            range = Integer.parseInt(editTextRange.getText().toString());
            if((range <= 1) || (range > 100)) {
                message = "Range out of bounds. Try again!";
                editTextRange.setText("10");
            }
        }

        int guessedNumber = -1;
        int randomNum = -1;
        if((null == editTextNumber.getText()) || (editTextNumber.getText().toString().isEmpty())) {
            message = "Guessed number cannot be empty. Try again!";
        } else {
            guessedNumber = Integer.parseInt(editTextNumber.getText().toString());
            if((guessedNumber < 0) || (guessedNumber > 100) || (guessedNumber > range)) {
                message = "Guessed number out of bounds. Try again!";
            }
            Random random =  new Random();
            randomNum = random.nextInt(range);
            if(randomNum == guessedNumber) {
                message = "You've guessed it right!";
            }
        }

        Log.i("info", "" + range + ":" + guessedNumber + ":" + randomNum);
        editTextNumber.setText("");
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

    }
}
