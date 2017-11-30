package spodesta.androidfirstapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class AFCActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
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

        final Context myContext = this.getBaseContext();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Object  DivisionList = listView.getItemAtPosition(i);

                Intent intent = new Intent(getApplicationContext(),DivisionActivity.class);
                Bundle bundle = new Bundle();

                ArrayList<String> teamNames = new ArrayList<String>();
                ArrayList<String> teamCities = new ArrayList<>();
                int[] images = new int[4];
                String title = "Title";
                int idDivision = 0;

                switch (DivisionList.toString())
                {
                    case "North":
                        idDivision = 1;
                        title = "AFC North";
                        break;


                    case "South":
                        idDivision = 2;
                        title = "AFC South";
                        break;


                    case "East":
                        idDivision = 3;
                        title = "AFC East";
                        break;


                    case "West":
                        idDivision = 4;
                        title = "AFC West";
                        break;

                }

                Cursor cursor = getTeamsFromDB(idDivision);
                int eachTeam = 0;
                while (cursor.moveToNext())
                {
                    String team = cursor.getString(0);
                    String city = cursor.getString(1);
                    teamNames.add(team);
                    teamCities.add(city);
                    images[eachTeam] = getResources().getIdentifier(team.toLowerCase(), "drawable", myContext.getPackageName());
                    eachTeam++;
                }

                bundle.putStringArrayList("lista",teamNames);
                bundle.putIntArray("images",images);
                bundle.putString("title",title);
                bundle.putStringArrayList("teamsDescriptions",teamCities);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private Cursor getTeamsFromDB(int idDivision)
    {
        String[] whereArgs = new String[] { String.valueOf(idDivision) };
        DatabaseHelper myDbHelper = new DatabaseHelper(this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (java.sql.SQLException sqle) {

        }
        SQLiteDatabase sd = myDbHelper.getReadableDatabase();
        String[] tableColumns = new String[] {
                "name",
                "city"
        };
        String whereClause = "idDivision = ?";
        String orderBy = "id";
        return sd.query("team", tableColumns, whereClause, whereArgs, null, null, orderBy);
    }
}
