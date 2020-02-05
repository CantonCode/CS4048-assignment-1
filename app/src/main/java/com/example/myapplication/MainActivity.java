package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String EXTRA_MESSAGE = "finalOrder.MESSAGE";
    CheckBox ch;
    CheckBox ch1;
    CheckBox ch2;
    CheckBox ch3;
    CheckBox ch4;
    CheckBox ch5;
    String text;
    String msg = " ";
    String cheesyMsg = " ";
    Switch simpleSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pizza_name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        ch = findViewById(R.id.checkBox);
        ch1 = findViewById(R.id.checkBox2);
        ch2 = findViewById(R.id.checkBox3);
        ch3 = findViewById(R.id.checkBox4);
        ch4 = findViewById(R.id.checkBox5);
        ch5 = findViewById(R.id.checkBox6);

        simpleSwitch = (Switch) findViewById(R.id.switch1);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onCheckboxClicked(View view) {

        msg = " ";

        if (ch.isChecked())
            msg = msg + "  " + ch.getText();
        if (ch1.isChecked())
            msg = msg + "  " + ch1.getText();
        if (ch2.isChecked())
            msg = msg + "  " + ch2.getText();
        if (ch3.isChecked())
            msg = msg + "  " + ch3.getText();
        if (ch4.isChecked())
            msg = msg + "  " + ch4.getText();
        if (ch5.isChecked())
            msg = msg + "  " + ch5.getText();

        Toast.makeText(this, msg + " is selected", Toast.LENGTH_LONG).show();
    }

    public void onSwitchClicked(View view) {
        cheesyMsg = " ";

        if (simpleSwitch.isChecked())
            cheesyMsg = cheesyMsg + simpleSwitch.getText().toString();

        Toast.makeText(this, cheesyMsg + " is selected", Toast.LENGTH_LONG).show();

    }

    public void onConfirmedClicked(View view) {
        String finalOrder = text + " " + msg + " " + cheesyMsg;
        Intent intent = new Intent(this, ConfirmationPage.class);
        intent.putExtra(EXTRA_MESSAGE, finalOrder);
        startActivity(intent);
    }




}

