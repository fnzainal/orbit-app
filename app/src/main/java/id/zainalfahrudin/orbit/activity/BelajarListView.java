package id.zainalfahrudin.orbit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import id.zainalfahrudin.orbit.R;

/**
 * Wrote by :
 * Zainal Fahrudin
 * fnzainal@gmail.com
 * on 22/09/16 15:41.
 */

public class BelajarListView extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_view);

        ListView listView = (ListView) findViewById(R.id.lvData);

        final String[] stringsArray = new String[] {
                "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, stringsArray);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), stringsArray[position],
//                        Toast.LENGTH_SHORT).show();

                startActivity(new Intent(Intent.ACTION_SHUTDOWN));

                //SAK KAREP MU
            }
        });
    }
}
