package com.example.lukekramer.assignment6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private ListView listView;
    private String[] names;

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
            int i = 0;

            while(itPerson.hasNext()) {

                names[i] = itPerson.next().getFirstName();
                i++;
            }

            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, names);

            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
        else{
            Toast.makeText(ShowAll.this, "No Data", Toast.LENGTH_SHORT).show();
        }


    }
}
