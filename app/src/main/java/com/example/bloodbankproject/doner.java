package com.example.bloodbankproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class doner extends AppCompatActivity
{
    TextInputLayout name;
    Spinner contact,email;
    Button fb1;
    Button sbmt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doner);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name = (TextInputLayout) findViewById(R.id.nametext1);
        contact = (Spinner) findViewById(R.id.contacttext1);
        email = (Spinner) findViewById(R.id.disease);
        fb1 = (Button) findViewById(R.id.fbtn1);
        sbmt1 = (Button) findViewById(R.id.sbmt_add1);


        sbmt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                processinsert(name.getEditText().getText().toString(),contact.getSelectedItem().toString(),email.getSelectedItem().toString());
            }
        });


        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),fetch_data.class));
            }
        });


    }

    private void processinsert(String n, String c, String e)
    {
        String res=new dpmanager1(this).addrecord(n,c,e);
        name.getEditText().setText("");
        contact.setSelection(1);
        email.setSelection(1);
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }


}