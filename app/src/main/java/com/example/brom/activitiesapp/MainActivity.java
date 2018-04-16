package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private Integer[] mountainHeights ={4478,4808,6190};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.
    List<String> nameData = new ArrayList<String>(Arrays.asList(mountainNames));
    List<String> locationData = new ArrayList<String>(Arrays.asList(mountainLocations));
    List<Integer> heightData = new ArrayList<Integer>(Arrays.<Integer>asList(mountainHeights));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Create a ListView as in previous assignment
        final List<String> listData = new ArrayList<String>(Arrays.asList(mountainNames));

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.list_item_textview,
                R.id.my_item_textview, listData);

        ListView myListView = (ListView) findViewById(R.id.my_listview);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,MountainDetailsActivity.class);

                String selectedMountain = nameData.get(position);
                String mountainData = "Location: " + locationData.get(position) + "\n" + "Height: " + heightData.get(position);

                intent.putExtra("Name", selectedMountain);
                intent.putExtra("Info", mountainData);
                startActivity(intent);

                //Toast.makeText(MainActivity.this, mountainData, Toast.LENGTH_LONG).show();
            }
        });

        myListView.setAdapter(adapter);

        // 2. Create a new activity named "MountainDetailsActivity - done
        // 3. Create a new Layout file for the MountainDetailsActivity called
        //    "activity_mountaindetails". MountainDetailsActivity must have MainActivity as its
        //    ´parent activity. - done
        // 4. The layout file created in step 3 must have a LinearLayout - done
        // 5. The layout file created in step 3 must be able to display
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 6. When tapping on a list item: create an Intent that includes
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 7. Display the MountainDetailsActivity with the data from the Intent created in step
        //    6
        // 8. From the MountainDetailsActivity you should have an option to "go back" using an
        //    left arro button. This is done by letting the MainActivity be the parent activity to
        //    MountainDetailsActivity.
    }
}
