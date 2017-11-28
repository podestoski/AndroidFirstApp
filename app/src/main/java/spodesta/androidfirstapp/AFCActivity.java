package spodesta.androidfirstapp;

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

public class AFCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final ListView listView = (ListView) findViewById(R.id.listAFC);

        ArrayList<String> lista = new ArrayList<String>();

        lista.add("North");
        lista.add("South");
        lista.add("East");
        lista.add("West");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object  o = listView.getItemAtPosition(i);

                Intent intent = new Intent(getApplicationContext(),DivisionActivity.class);
                Bundle b = new Bundle();
                ArrayList<String> lista = new ArrayList<String>();
                ArrayList<String> teamsDescriptions = new ArrayList<>();
                int[] images = new int[4];
                String title = "Title";


                switch (o.toString())
                {
                    case "North":
                        lista.add("Steelers");
                        lista.add("Ravens");
                        lista.add("Bengals");
                        lista.add("Browns");
                        images[0] = R.drawable.steelers;
                        images[1] = R.drawable.ravens;
                        images[2] = R.drawable.bengals;
                        images[3] = R.drawable.browns;
                        teamsDescriptions.add("Pittsburgh");
                        teamsDescriptions.add("Baltimore");
                        teamsDescriptions.add("Cincinnati");
                        teamsDescriptions.add("Cleveland");
                        title = "AFC North";
                        break;

                    case "South":
                        lista.add("Jaguars");
                        lista.add("Titans");
                        lista.add("Colts");
                        lista.add("Texans");
                        images[0] = R.drawable.jaguars;
                        images[1] = R.drawable.titans;
                        images[2] = R.drawable.colts;
                        images[3] = R.drawable.texans;
                        teamsDescriptions.add("Jacksonville");
                        teamsDescriptions.add("Tennessee");
                        teamsDescriptions.add("Indianapolis");
                        teamsDescriptions.add("Houston");
                        title = "AFC South";
                        break;

                    case "East":
                        lista.add("Patriots");
                        lista.add("Bills");
                        lista.add("Jets");
                        lista.add("Dolphins");
                        images[0] = R.drawable.patriots;
                        images[1] = R.drawable.bills;
                        images[2] = R.drawable.jets;
                        images[3] = R.drawable.dolphins;
                        teamsDescriptions.add("New England");
                        teamsDescriptions.add("Buffalo");
                        teamsDescriptions.add("New York");
                        teamsDescriptions.add("Miami");
                        title = "AFC East";
                        break;

                    case "West":
                        lista.add("Chiefs");
                        lista.add("Chargers");
                        lista.add("Raiders");
                        lista.add("Broncos");
                        images[0] = R.drawable.chiefs;
                        images[1] = R.drawable.chargers;
                        images[2] = R.drawable.raiders;
                        images[3] = R.drawable.broncos;
                        teamsDescriptions.add("Kansas City");
                        teamsDescriptions.add("Los Angeles");
                        teamsDescriptions.add("Oakland");
                        teamsDescriptions.add("Denver");
                        title = "AFC West";
                        break;
                }
                b.putStringArrayList("lista",lista);
                b.putIntArray("images",images);
                b.putString("title",title);
                b.putStringArrayList("teamsDescriptions",teamsDescriptions);
                intent.putExtras(b);
                startActivity(intent);

            }
        });

    }

}
