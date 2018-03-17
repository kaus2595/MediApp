package com.MediApp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class start_activity extends AppCompatActivity implements View.OnClickListener {
     FirebaseUser user;
      FirebaseAuth mAuth;
      EditText email,password;
      Button button;
      TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        email = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        textView = findViewById(R.id.textView);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button:
              //  Toast.makeText(this,"Buttons Case",Toast.LENGTH_LONG).show();
                String email_val = email.getText().toString();
                String password_val = password.getText().toString();
                if (email_val.equals(null) ) {
                    Toast.makeText(this,"Please Enter Email",Toast.LENGTH_LONG).show();
                }
                else {
                    if(password_val.equals(null) && password_val.length()<6)
                    {
                        Toast.makeText(this,"Please Enter Password",Toast.LENGTH_LONG).show();
                    }
                    else {
                        mAuth.signInWithEmailAndPassword(email_val,password_val)
                                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            // Sign in success, update UI with the signed-in user's information
                                            String user = mAuth.getCurrentUser().getUid();
                                            Intent i = new Intent (getBaseContext(),MainActivity.class);
                                            i.putExtra("s",user);
                                            finish();

                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Toast.makeText(getApplicationContext(),"Authentication Failed",Toast.LENGTH_LONG).show();

                                        }

                                        // ...
                                    }
                                });

                    }
                }
                break;

            case R.id.textView:
              //  Toast.makeText(this,"TextView Case",Toast.LENGTH_LONG).show();
                Intent i = new Intent(this,Signup.class);
                startActivity(i);
                finish();
                break;

        }



        }
        }



