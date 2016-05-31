package com.example.lukekramer.assignment6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by lukekramer on 26/05/16.
 */
public class RegisterClient extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText phoneNumber;
    private EditText emailAddress;
    private EditText income;

    private TextView Textfirstname;
    private TextView Textlastname;
    private TextView Textphonenum;
    private TextView Textemail;
    private TextView Textincome;

    private Button previewButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_client);


        firstName =(EditText)findViewById(R.id.First_Name_EditText);
        lastName = (EditText)findViewById(R.id.Last_Name_EditText);
        phoneNumber = (EditText)findViewById(R.id.Phone_Number_EditText);
        emailAddress = (EditText)findViewById(R.id.Email_EditText);
        income = (EditText)findViewById(R.id.Income_EditText);



        previewButton =(Button)findViewById(R.id.preview_button);

        previewButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), RegisterClientPreview.class);
                i.putExtra("firstName",firstName.getText().toString());
                i.putExtra("lastName",lastName.getText().toString());
                i.putExtra("phoneNumber",phoneNumber.getText().toString());
                i.putExtra("emailAddress",emailAddress.getText().toString());
                i.putExtra("income",income.getText().toString());
                startActivity(i);

            }
        });







    }

}
