package com.MediApp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    EditText edit1,edit2,edit3,edit4;
    RadioButton radiobutton;
    Button button;
    FirebaseAuth auth;
    Boolean b;
    DatabaseReference fbdb;
    profile p;
    String  name,phone,mail,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        auth= FirebaseAuth.getInstance();
        fbdb=FirebaseDatabase.getInstance().getReference();
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
         name = edit1.getText().toString();
         phone = edit2.getText().toString();
         mail = edit3.getText().toString();
         password = edit4.getText().toString();
       b=radiobutton.isChecked();

       if(TextUtils.isEmpty(name)&& TextUtils.isEmpty(mail)){

           if(TextUtils.isEmpty(password)){

               Toast.makeText(this,"enter  passowed",Toast.LENGTH_SHORT).show();
           }
           else{
               Toast.makeText(getApplicationContext(),"enter uid",Toast.LENGTH_SHORT).show();

           }
       }
        else{
           auth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful()) {
                       // Sign in success, update UI with the signed-in user's information
                       String user = auth.getCurrentUser().getUid();
//                       Intent i = new Intent (getBaseContext(),MainActivity.class);
//                       i.putExtra("s",user);
                       if(b){
                             p=new profile();
                            p.setname(name);
                            p.setPhone(phone);
                            p.setMail(mail);
                            p.setPass(password);
                            fbdb.child("doctors").child(user).setValue(p);

                       }
                       else{
                           fbdb.child("users").child(user).setValue(p);

                       }
                       finish();

                   } else {
                       // If sign in fails, display a message to the user.
                       Toast.makeText(getApplicationContext(),"Authentication Failed",Toast.LENGTH_LONG).show();

                   }
               }
           });



       }
    }
}
