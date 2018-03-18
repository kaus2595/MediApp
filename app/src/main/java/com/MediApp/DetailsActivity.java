package com.MediApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class DetailsActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Spinner spinner1;
    private DatePicker datepicker;
    private Button book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        book=(Button)findViewById(R.id.bookappointment);
        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Book Appoinment");

        spinner1=(Spinner)findViewById(R.id.idspinner);

        String []doctors={"Mr Kaustubh(Child Specialist)","Mr.Rohit (Bone Specialist)","Mr Shashank (Surgery)","Mr Honey(Cancer)"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,doctors);
        spinner1.setAdapter(adapter);
        datepicker=(DatePicker)findViewById(R.id.datpicker);
        Calendar calander=Calendar.getInstance();
        datepicker.init(calander.get(Calendar.YEAR), calander.get(Calendar.MONTH), calander.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(getApplicationContext(),datepicker.getDayOfMonth()+"/"+ datepicker.getMonth()+"/n"+datepicker.getYear(),Toast.LENGTH_LONG).show();
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(DetailsActivity.this,MainActivity.class);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(mainIntent);

                Toast.makeText(getApplicationContext(),"Booking Confirmed",Toast.LENGTH_LONG).show();
            }
        });
    }
}
