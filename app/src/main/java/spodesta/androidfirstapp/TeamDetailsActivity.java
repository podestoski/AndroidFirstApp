package spodesta.androidfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

public class TeamDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);
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

        Bundle b = getIntent().getExtras();

        ImageView view = (ImageView) findViewById(R.id.imageStadium);
        ImageView viewQB = (ImageView) findViewById(R.id.imageQB);
        TextView lblStadium = (TextView) findViewById(R.id.lblStadium);
        TextView lblQB = (TextView) findViewById(R.id.lblQB);

        int imageStadium = 0,imageQb = 0;
        String stadium = "",qb = "";

        switch (b.getString("Team"))
        {
            case "Steelers":
                imageStadium = R.drawable.heinzfield;
                imageQb = R.drawable.roethlisberger;
                stadium = "Heinz Field";
                qb = "Ben Roethlisberger";
                break;

            case "Ravens":
                imageStadium = R.drawable.mtbankstadium;
                imageQb = R.drawable.flacco;
                stadium = "M&T Bank Stadium";
                qb = "Joe Flacco";
                break;

        }

        view.setImageResource(imageStadium);
        viewQB.setImageResource(imageQb);
        lblStadium.setText(stadium);
        lblQB.setText(qb);


        view.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });
    }

}
