package com.example.courtneyvu.crunchtime;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainScreenConverter extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String exerciseFrom;
    String exerciseTo;
    String units;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_converter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        Spinner spinner1 = (Spinner) findViewById(R.id.exercises_spinner1);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exercise_options, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);


        Spinner spinner2 = (Spinner) findViewById(R.id.exercises_spinner2);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);

        exerciseFrom = "";
        exerciseTo = "";
        units = "";
    }

    /** Called when the user clicks the Convert button */
    public void convert(View view) {
        // Do something in response to button
        EditText num_input = (EditText)findViewById(R.id.enter_reps_mins);
        EditText cals_output = (EditText)findViewById(R.id.calories);
        EditText conversion_output = (EditText)findViewById(R.id.exercise_conversion);

        String content = num_input.getText().toString();
        Integer val;
        if (!content.equals("")) {
            val = Integer.parseInt(content);
        } else {
            return;
        }
        Integer converted_cals_val = 0;

        if (units.equals("Reps")) {
            if (exerciseFrom.equals("Push Ups")) {
                converted_cals_val = (val * 100) / 350;
            } else if (exerciseFrom.equals("Sit Ups")) {
                converted_cals_val = (val * 100) / 200;
            } else if (exerciseFrom.equals("Jumping Jacks")) {

            } else if (exerciseFrom.equals("Jogging")) {

            }
        } else if (units.equals("Mins")) {
            if (exerciseFrom.equals("Push Ups")) {

            } else if (exerciseFrom.equals("Sit Ups")) {

            } else if (exerciseFrom.equals("Jumping Jacks")) {
                converted_cals_val = val * 10;
            } else if (exerciseFrom.equals("Jogging")) {
                converted_cals_val = val * 100 / 12;
            }
        }

        cals_output.setText(converted_cals_val.toString());

        Integer converted_ex_val = 0;

        if (exerciseTo.equals("Push Ups")) {
            converted_ex_val = (converted_cals_val / 100) * 350;
        } else if (exerciseTo.equals("Sit Ups")) {
            converted_ex_val = (converted_cals_val / 100) * 200;
        } else if (exerciseTo.equals("Jumping Jacks")) {
            converted_ex_val = converted_cals_val / 10;
        } else if (exerciseTo.equals("Jogging")) {
            converted_ex_val = (converted_cals_val / 100) * 12;
        }

        conversion_output.setText(converted_ex_val.toString());
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_reps:
                if (checked)
                    units = "Reps";
                    break;
            case R.id.radio_mins:
                if (checked)
                    units = "Mins";
                    break;
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        switch(parent.getId()){
            case R.id.exercises_spinner1 :
                //Your Action Here.
                String selectedFrom = parent.getItemAtPosition(pos).toString();
                exerciseFrom = selectedFrom;
                break;
            case R.id.exercises_spinner2 :
                //Your Another Action Here.
                String selectedTo = parent.getItemAtPosition(pos).toString();
                exerciseTo = selectedTo;
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        switch(parent.getId()){
            case R.id.exercises_spinner1 :
                //Your Action Here.
                break;
            case R.id.exercises_spinner2 :
                //Your Another Action Here.
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen_converter, menu);
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

}
