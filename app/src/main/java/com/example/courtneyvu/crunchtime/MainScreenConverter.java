package com.example.courtneyvu.crunchtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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

        if (exerciseFrom.equals("Push Ups")) {
            converted_cals_val = (val * 100) / 350;
        } else if (exerciseFrom.equals("Sit Ups")) {
            converted_cals_val = (val * 100) / 200;
        } else if (exerciseFrom.equals("Squats")) {
            converted_cals_val = (val * 100) / 225;
        } else if (exerciseFrom.equals("Leg Lift")) {
            converted_cals_val = (val * 100) / 25;
        } else if (exerciseFrom.equals("Planks")) {
            converted_cals_val = (val * 100) / 25;
        } else if (exerciseFrom.equals("Jumping Jacks")) {
            converted_cals_val = (val * 100) / 10;
        } else if (exerciseFrom.equals("Pull Ups")) {
            converted_cals_val = (val * 100) / 100;
        } else if (exerciseFrom.equals("Cycling")) {
            converted_cals_val = (val * 100) / 12;
        } else if (exerciseFrom.equals("Walking")) {
            converted_cals_val = (val * 100) / 20;
        } else if (exerciseFrom.equals("Jogging")) {
            converted_cals_val = (val * 100) / 12;
        } else if (exerciseFrom.equals("Swimming")) {
            converted_cals_val = (val * 100) / 13;
        } else if (exerciseFrom.equals("Stair Climbing")) {
            converted_cals_val = (val * 100) / 15;
        }

        cals_output.setText(converted_cals_val.toString());

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
        TextView input_units_field = (TextView)findViewById(R.id.input_units);
        TextView converted_units_field = (TextView)findViewById(R.id.converted_units);

        EditText num_input = (EditText)findViewById(R.id.enter_reps_mins);
        EditText cals_output = (EditText)findViewById(R.id.calories);
        EditText conversion_output = (EditText)findViewById(R.id.exercise_conversion);

        String selected = parent.getItemAtPosition(pos).toString();

        switch(parent.getId()){
            case R.id.exercises_spinner1 :
                //Your Action Here.
                String selectedFrom = selected;
                exerciseFrom = selectedFrom;
                num_input.setText("");
                cals_output.setText("");
                conversion_output.setText("");

                if (selected.equals("Select Option")) {
                    input_units_field.setText("");
                } else if (selected.equals("Push Ups")) {
                    input_units_field.setText("Reps");
                } else if (selected.equals("Sit Ups")) {
                    input_units_field.setText("Reps");
                } else if (selected.equals("Squats")) {
                    input_units_field.setText("Reps");
                } else if (selected.equals("Leg Lift")) {
                    input_units_field.setText("Minutes");
                } else if (selected.equals("Planks")) {
                    input_units_field.setText("Minutes");
                } else if (selected.equals("Jumping Jacks")) {
                    input_units_field.setText("Minutes");
                } else if (selected.equals("Pull Ups")) {
                    input_units_field.setText("Reps");
                } else if (selected.equals("Cycling")) {
                    input_units_field.setText("Minutes");
                } else if (selected.equals("Walking")) {
                    input_units_field.setText("Minutes");
                } else if (selected.equals("Jogging")) {
                    input_units_field.setText("Minutes");
                } else if (selected.equals("Swimming")) {
                    input_units_field.setText("Minutes");
                } else if (selected.equals("Stair Climbing")) {
                    input_units_field.setText("Minutes");
                }
                break;
            case R.id.exercises_spinner2 :
                //Your Another Action Here.
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
