package com.example.lukekramer.assignment6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.lukekramer.assignment6.entity.Person;
import com.example.lukekramer.assignment6.repository.person.Impl.PersonRepositoryImpl;
import com.example.lukekramer.assignment6.repository.tables.CreateTables;

/**
 * Created by lukekramer on 26/05/16.
 */
public class RegisterClientPreview extends AppCompatActivity {

    private TextView Textfirstname;
    private TextView Textlastname;
    private TextView Textphonenum;
    private TextView Textemail;
    private TextView Textincome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_client_preview);

        Textfirstname =(TextView)findViewById(R.id.firstname_TextView);
        Textlastname =(TextView)findViewById(R.id.lastname_TextView);
        Textphonenum =(TextView)findViewById(R.id.phonenumber_TextView);
        Textemail =(TextView)findViewById(R.id.email_TextView);
        Textincome =(TextView)findViewById(R.id.income_TextView);

        Intent i = getIntent();

        Bundle b = i.getExtras();

        if(b!=null)
        {
            String fname = (String)b.get("firstName");
            Textfirstname.setText(fname);

            String lname =(String)b.get("lastName");
            Textlastname.setText(lname);

            String num = (String)b.get("phoneNumber");
            Textphonenum.setText(num);

            String email = (String)b.get("emailAddress");
            Textemail.setText(email);

            String income = (String)b.get("income");
            Textincome.setText(income);



        }

    }

    public void btnSubmit(View view) throws InterruptedException {

        CreateTables createTables = new CreateTables(this.getApplicationContext());

        createTables.createTables();

        PersonRepositoryImpl personRepository = new PersonRepositoryImpl(getApplicationContext());

        Person person = new Person.Builder()
                .FirstName(Textfirstname.getText().toString())
                .Email(Textemail.getText().toString())
                .Income(5000)
                .LastName(Textlastname.getText().toString())
                .PhoneNumber(Textphonenum.getText().toString())
                .build();

        personRepository.save(person);
        
        Intent intent = new Intent(this, ShowAll.class);

        startActivity(intent);
    }
}
