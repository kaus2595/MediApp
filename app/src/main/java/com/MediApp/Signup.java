package com.MediApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    EditText edit1,edit2,edit3,edit4;
    RadioButton radiobutton;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edit1 = findViewById(R.id.editText3);
        edit2 = findViewById(R.id.editTextPhone);
        edit3 = findViewById(R.id.editTextMail);
        edit4 = findViewById(R.id.editTextPassword);
        radiobutton = findViewById(R.id.radioButtonDoctorYes);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       String  name = edit1.getText().toString();
       String  phone = edit2.getText().toString();
       String mail = edit3.getText().toString();
       String password = edit4.getText().toString();

    }
}
