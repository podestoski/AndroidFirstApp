package spodesta.androidfirstapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import cz.msebera.android.httpclient.Header;

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
        final TextView lblQB = (TextView) findViewById(R.id.lblQB);

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




        /*String NFLRestService = "http://localhost:46953/RestNFLService.svc/json/1";
        JSONObject jsonObj;

        ResExecution.get(null,new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                String _response = response.toString();// If the response is JSONObject instead of expected JSONArray
                lblQB.setText(_response);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                String _response = response.toString();// If the response is JSONObject instead of expected JSONArray
                lblQB.setText(_response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

            }


        });*/




        view.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });
    }

}
