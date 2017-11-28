package spodesta.androidfirstapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DivisionActivity extends AppCompatActivity {

    String team = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle b = getIntent().getExtras();
        String title = b.getString("title");
        getSupportActionBar().setTitle(title);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        ArrayList lista = b.getStringArrayList("lista");



        int[] imgid= b.getIntArray("images");
        ArrayList teamsDescriptions = b.getStringArrayList("teamsDescriptions");

        CustomListAdapter adapter= new CustomListAdapter(this,lista,imgid,teamsDescriptions);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        //this.setListAdapter(new ArrayAdapter<String>(this,R.layout.teamlist,R.id.Itemname,lista));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(getApplicationContext(),TeamDetailsActivity.class);
                Bundle b =  new Bundle();

                b.putString("Team",adapterView.getItemAtPosition(i).toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }

}
