package com.example.ex1101_sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    /** TextView to display the counter value. */
    TextView tVNum;

    /** Integer variable to keep track of the count. */
    int count;

    /** EditText to accept user input. */
    EditText et;

    /** SharedPreferences instance to store and retrieve data persistently. */
    SharedPreferences settings;

    /** SharedPreferences.Editor instance to edit and commit changes. */
    SharedPreferences.Editor editor;



    /**
     * Called when the activity is first created.
     * Initializes UI components and loads saved data from SharedPreferences.
     *
     * @param savedInstanceState Saved state of the application, if any.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tVNum = findViewById(R.id.tVNum);
        et = findViewById(R.id.eT);

        settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        editor = settings.edit();

        String name = settings.getString("name", "");
        et.setText(name);

        count = settings.getInt("count", 0);
        tVNum.setText(count + "");
    }

    /**
     * Increments the counter by 1 and updates the displayed value.
     *
     * @param view The button view that was clicked.
     */
    public void countClick(View view) {
        count +=1;
        tVNum.setText(count + " ");


    }

    /**
     * Resets the counter to 0 and updates the displayed value.
     *
     * @param view The button view that was clicked.
     */

    public void resetClick(View view) {
        count = 0;
        tVNum.setText("0");

    }

    /**
     * Saves the user input and counter value to SharedPreferences and exits the application.
     *
     * @param view The button view that was clicked.
     */
    public void exitClick(View view) {
        editor.putString("name", et.getText().toString());
        editor.putInt("count", count);
        editor.commit();
        finish();
    }

    /**
     * Creates the options menu on screen
     *
     * @param menu the menu
     * @return ture
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Checks if the clicked menuItem is the item wanted
     * @param item the item
     * @return ture
     */

    @Override
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.credit) {
            Intent si = new Intent(this, CreditActivity.class);
            startActivity(si);
        }
        return true;
    }


}