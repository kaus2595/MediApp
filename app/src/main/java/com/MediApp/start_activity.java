package com.MediApp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class start_activity extends AppCompatActivity implements View.OnClickListener , GoogleApiClient.OnConnectionFailedListener{
    private static final String TAG = "XYZ";
    FirebaseUser user;
      FirebaseAuth mAuth;
      EditText email,password;
      Button button;
      TextView textView;
    GoogleApiClient mGoogle;
    ImageView imageView;
    private static final int sign=9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        email = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView2);
        imageView.setOnClickListener(this);

        textView = findViewById(R.id.Signup);
      //  textView.setOnClickListener(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestProfile()
                .requestEmail()
                .build();
        mGoogle = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
       // text = (TextView) findViewById(R.id.text);
       // signin = (SignInButton) findViewById(R.id.signin);
       // signin.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {


//        switch (view.getId())
//        {
//            case R.id.button:
//              //  Toast.makeText(this,"Buttons Case",Toast.LENGTH_LONG).show();
//                String email_val = email.getText().toString();
//                String password_val = password.getText().toString();
//                Log.d("Hello","APPLE");
//                Log.d("Hello",email_val+" "+password_val);
//                if (email_val.equals(null) ) {
//                    Toast.makeText(this,"Please Enter Email",Toast.LENGTH_LONG).show();
//                }
//                else {
//                    if(password_val.equals(null) && password_val.length()<6)
//                    {
//                        Toast.makeText(this,"Please Enter Password",Toast.LENGTH_LONG).show();
//                    }
//                    else {
//                        Log.d("Hello",email_val+" "+password_val);
//                        mAuth.signInWithEmailAndPassword("a@gmail.com","1234567890")
//                                .addOnCompleteListener(start_activity.this, new OnCompleteListener<AuthResult>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<AuthResult> task) {
//                                        if (task.isSuccessful()) {
//                                            // Sign in success, update UI with the signed-in user's information
//                                            if (!task.isSuccessful()) {
//                                                Log.e(TAG, "onComplete: Failed=" + task.getException().getMessage());
//                                            }
//                                            String user = mAuth.getCurrentUser().getUid();
//                                            Intent i = new Intent (getBaseContext(),MainActivity.class);
//                                            i.putExtra("s",user);
//                                            finish();
//
//                                        } else {
//                                            // If sign in fails, display a message to the user.
//                                            Toast.makeText(getApplicationContext(),"Authentication Failed",Toast.LENGTH_LONG).show();
//
//                                        }
//
//
//                                    }
//                                });
//
//                    }
//                }
//                break;
//
//            case R.id.Signup:
//               // Toast.makeText(this,"TextView Case",Toast.LENGTH_LONG).show();
//                Intent i = new Intent(this,Signup.class);
//                startActivity(i);
//                finish();
//                break;
//
//        }

//        Intent signInIntent= Auth.GoogleSignInApi.getSignInIntent(mGoogle);
//        startActivityForResult(signInIntent,sign);

        Intent signInIntent= Auth.GoogleSignInApi.getSignInIntent(mGoogle);
        startActivityForResult(signInIntent,sign);
        }

    public void onActivityResult(int requestcode, int resultcode, Intent data)
    {
        super.onActivityResult(requestcode,resultcode,data);
        if(requestcode==sign)
        {
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    private void handleSignInResult(GoogleSignInResult result)
    {
        Log.d(TAG,"handleSignInResult:"+result.isSuccess());
        if(result.isSuccess())
        {
            GoogleSignInAccount acc=result.getSignInAccount();
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            String name=acc.getDisplayName();
            String mail=acc.getEmail();
            Log.d("Hello",mail);
            Log.d("Hello",name);
//            i.putExtra("name",name);
            //Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
            startActivity(i);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }

    }
    public void onConnectionFailed(ConnectionResult ConnectionResult){
        Log.d(TAG, "onConnectionFailed:"+ ConnectionResult);
    }

}



