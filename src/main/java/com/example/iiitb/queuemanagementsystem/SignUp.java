package com.example.iiitb.queuemanagementsystem;

/**
 * Created by iiitb on 11/4/17.
 */


        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.Serializable;


public class SignUp extends Activity {

     DatabaseHelper helper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }


    public void onSignUpClick(View v) {
        if (v.getId() == R.id.Bsignupbutton) {

            EditText name =(EditText)findViewById(R.id.TFname);
            EditText email =(EditText)findViewById(R.id.TFemail);
            EditText uname =(EditText)findViewById(R.id.TFuname);
            EditText pass1 =(EditText)findViewById(R.id.TFpass1);
            EditText pass2 =(EditText)findViewById(R.id.TFpass2);
            EditText secret = (EditText)findViewById(R.id.Secret);


            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str)){


                Toast pass =Toast.makeText(SignUp.this,"Passwords doesnot match !!",Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                Contact c = new Contact();
               // Student s = new Student();

                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);
                c.setSecretpass(secret.getText().toString());
                helper.insertContact(c);


            //    Toast pass =Toast.makeText(SignUp.this,pass1str,Toast.LENGTH_SHORT);
             //   pass.show();

                Intent i = new Intent(SignUp.this,MainActivity.class);


                startActivity(i);



            }
        }
    }
}