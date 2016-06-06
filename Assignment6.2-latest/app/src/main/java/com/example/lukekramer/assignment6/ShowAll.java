package com.example.lukekramer.assignment6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lukekramer.assignment6.entity.Person;
import com.example.lukekramer.assignment6.repository.person.Impl.PersonRepositoryImpl;
import com.example.lukekramer.assignment6.repository.tables.CreateTables;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by lukekramer on 31/05/16.
 */
public class ShowAll extends AppCompatActivity {

    private Set<Person> personSet;
    private ArrayAdapter adapter;
    //private ArrayAdapter adapter1;
    private ListView listView;
    private String[] names;
    //private String[] id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);

        CreateTables createTables = new CreateTables(this.getApplicationContext());

        createTables.createTables();

        PersonRepositoryImpl personRepository = new PersonRepositoryImpl(this.getApplicationContext());

        personSet = new HashSet<>();

        personSet = personRepository.findAll();

        Iterator<Person> itPerson = personSet.iterator();

        if(personSet.size() > 0) {

            names = new String[personSet.size()];
           // id = new String[personSet.size()];
            int i = 0;

            while(itPerson.hasNext()) {
               // id[i]= String.valueOf(itPerson.next().getId());
                names[i] = itPerson.next().getFirstName();

                i++;
            }

            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
            //adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,id);

            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
            //listView.setAdapter(adapter1);
        }
        else{
            Toast.makeText(ShowAll.this, "No Data", Toast.LENGTH_SHORT).show();
        }


    }

    public void returntoHome(View view) {

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

    }
}
//#3F51B5
//#303F9F
//#FF4081