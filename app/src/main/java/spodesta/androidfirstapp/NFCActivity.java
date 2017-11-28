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

public class NFCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);
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

        final ListView listView = (ListView) findViewById(R.id.listNFC);

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
                        lista.add("Vikings");
                        teamsDescriptions.add("Minnesota");
                        lista.add("Packers");
                        teamsDescriptions.add("Green bay");
                        lista.add("Lions");
                        teamsDescriptions.add("Detroit");
                        lista.add("Bears");
                        teamsDescriptions.add("Chicago");
                        images[0] = R.drawable.vikings;
                        images[1] = R.drawable.packers;
                        images[2] = R.drawable.lions;
                        images[3] = R.drawable.bears;
                        title = "NFC North";
                        break;


                    case "South":
                        lista.add("Saints");
                        lista.add("Panthers");
                        lista.add("Falcons");
                        lista.add("Buccaneers");
                        images[0] = R.drawable.saints;
                        images[1] = R.drawable.panthers;
                        images[2] = R.drawable.falcons;
                        images[3] = R.drawable.buccaneers;
                        teamsDescriptions.add("New Orleans");
                        teamsDescriptions.add("Carolina");
                        teamsDescriptions.add("Atlanta");
                        teamsDescriptions.add("Tampa Bay");
                        title = "NFC South";
                        break;


                    case "East":
                        lista.add("Eagles");
                        lista.add("Cowboys");
                        lista.add("Redskins");
                        lista.add("Giants");
                        images[0] = R.drawable.eagles;
                        images[1] = R.drawable.cowboys;
                        images[2] = R.drawable.redskins;
                        images[3] = R.drawable.giants;
                        teamsDescriptions.add("Philadelphia");
                        teamsDescriptions.add("Dallas");
                        teamsDescriptions.add("Washington");
                        teamsDescriptions.add("New York");
                        title = "NFC East";
                        break;


                    case "West":
                        lista.add("Rams");
                        lista.add("Seahawks");
                        lista.add("Cardinals");
                        lista.add("49ers");
                        images[0] = R.drawable.rams;
                        images[1] = R.drawable.seahawks;
                        images[2] = R.drawable.cardinals;
                        images[3] = R.drawable.niners;
                        teamsDescriptions.add("Los Angeles");
                        teamsDescriptions.add("Seattle");
                        teamsDescriptions.add("Arizona");
                        teamsDescriptions.add("San Francisco");
                        title = "NFC West";
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
