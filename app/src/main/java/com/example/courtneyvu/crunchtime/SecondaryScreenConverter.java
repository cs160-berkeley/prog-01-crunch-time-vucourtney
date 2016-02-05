package com.example.courtneyvu.crunchtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SecondaryScreenConverter extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String exerciseTo;
    String units;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_screen_converter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        Spinner spinner1 = (Spinner) findViewById(R.id.exercises_spinner1);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exercise_options, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        exerciseTo = "";
        units = "";
    }

    /** Called when the user clicks the Convert button */
    public void convert(View view) {
        // Do something in response to button
        EditText num_input = (EditText)findViewById(R.id.cals_input);
        EditText conversion_output = (EditText)findViewById(R.id.exercise_conversion);

        String content = num_input.getText().toString();
        Integer val;
        if (!content.equals("")) {
            val = Integer.parseInt(content);
        } else {
            return;
        }
        Integer converted_cals_val = val;

        Integer converted_ex_val = 0;

        if (exerciseTo.equals("Push Ups")) {
            converted_ex_val = (converted_cals_val * 350) / 100;
        } else if (exerciseTo.equals("Sit Ups")) {
            converted_ex_val = (converted_cals_val * 200) / 100;
        } else if (exerciseTo.equals("Squats")) {
            converted_ex_val = (converted_cals_val * 225) / 100;
        } else if (exerciseTo.equals("Leg Lift")) {
            converted_ex_val = (converted_cals_val * 25) / 100;
        } else if (exerciseTo.equals("Planks")) {
            converted_ex_val = (converted_cals_val * 25) / 100;
        } else if (exerciseTo.equals("Jumping Jacks")) {
            converted_ex_val = (converted_cals_val * 10) / 100;
        } else if (exerciseTo.equals("Pull Ups")) {
            converted_ex_val = (converted_cals_val * 100) / 100;
        } else if (exerciseTo.equals("Cycling")) {
            converted_ex_val = (converted_cals_val * 12) / 100;
        } else if (exerciseTo.equals("Walking")) {
            converted_ex_val = (converted_cals_val * 20) / 100;
        } else if (exerciseTo.equals("Jogging")) {
            converted_ex_val = (converted_cals_val * 12) / 100;
        } else if (exerciseTo.equals("Swimming")) {
            converted_ex_val = (converted_cals_val * 13) / 100;
        } else if (exerciseTo.equals("Stair Climbing")) {
            converted_ex_val = (converted_cals_val * 15) / 100;
        }

        conversion_output.setText(converted_ex_val.toString());
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        TextView converted_units_field = (TextView)findViewById(R.id.converted_units);
        EditText conversion_output = (EditText)findViewById(R.id.exercise_conversion);

        String selected = parent.getItemAtPosition(pos).toString();

        String selectedTo = selected;
        exerciseTo = selectedTo;
        conversion_output.setText("");

        if (selected.equals("Select Option")) {
            converted_units_field.setText("");
        } else if (selected.equals("Push Ups")) {
            converted_units_field.setText("Reps");
        } else if (selected.equals("Sit Ups")) {
            converted_units_field.setText("Reps");
        } else if (selected.equals("Squats")) {
            converted_units_field.setText("Reps");
        } else if (selected.equals("Leg Lift")) {
            converted_units_field.setText("Minutes");
        } else if (selected.equals("Planks")) {
            converted_units_field.setText("Minutes");
        } else if (selected.equals("Jumping Jacks")) {
            converted_units_field.setText("Minutes");
        } else if (selected.equals("Pull Ups")) {
            converted_units_field.setText("Reps");
        } else if (selected.equals("Cycling")) {
            converted_units_field.setText("Minutes");
        } else if (selected.equals("Walking")) {
            converted_units_field.setText("Minutes");
        } else if (selected.equals("Jogging")) {
            converted_units_field.setText("Minutes");
        } else if (selected.equals("Swimming")) {
            converted_units_field.setText("Minutes");
        } else if (selected.equals("Stair Climbing")) {
            converted_units_field.setText("Minutes");
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

}
