package id.zainalfahrudin.orbit.job10;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import id.zainalfahrudin.orbit.R;

public class ActivityRequest extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();
    private TextView textView;
    private ListView lvPantai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        textView = (TextView) findViewById(R.id.tvReturn);
        Button button = (Button) findViewById(R.id.btnRequest);
        lvPantai = (ListView) findViewById(R.id.lvPantai);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestData();
            }
        });
    }


    private void requestData() {
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("loading");
        progress.show();
        String url = "https://gist.githubusercontent.com/fnzainal/360c10bedb3d84aa51d9ee026ff2d10d/raw/c708ae215a7c5956edcf072ab981f81bcb84089a/json_exercise.json";

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: \n"+response);
                progress.dismiss();

                Type type = new TypeToken<ArrayList<ModelPantai>>() {}.getType();

                //convert json to list data
                final List<ModelPantai> dataList = new Gson().fromJson(response, type);

                //inisiasi adapter
                AdapterPantai adapter = new AdapterPantai(ActivityRequest.this, dataList);
                lvPantai.setAdapter(adapter);

                //on item click
                lvPantai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        AlertDialog dialog = new AlertDialog.Builder(ActivityRequest.this)
                                .setTitle("Notice")
                                .setMessage("Kunjungi postingan "+dataList.get(position).getUrl()+" ?")
                                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //membuka url
                                    }
                                }).show();
                    }
                });

//                textView.setText(response);
            }
        }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progress.dismiss();
//                    textView.setText("ERROR");
                }
        });
        queue.add(request);

    }
}
