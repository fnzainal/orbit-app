package id.zainalfahrudin.orbit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import id.zainalfahrudin.orbit.R;
import id.zainalfahrudin.orbit.ui.CircleImageView;

public class FirstActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF");
        setContentView(R.layout.activity_first);

        CircleImageView imageView = (CircleImageView) findViewById(R.id.ivAva);

        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvDeskripsi = (TextView) findViewById(R.id.tvDesc);

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            String namaOs = bundle.getString(BelajarListView.TITLE_OS);
            String deskripsi = bundle.getString(BelajarListView.DESC);

            Log.d(TAG, "onCreate: data intent = "+namaOs+", "+deskripsi);

            tvName.setText(namaOs);
            tvDeskripsi.setText(deskripsi);
            int icon = bundle.getInt(BelajarListView.ICON);
            imageView.setImageDrawable(getResources().getDrawable(icon));
        }else{
            Log.d(TAG, "onCreate: bundle null");
        }


        /*imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Logout!", Toast.LENGTH_SHORT).show();
                getSharedPreferences("Login",0).edit().clear().apply();
                startActivity(new Intent(FirstActivity.this,Login.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });*/
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /*startActivity(new Intent(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_HOME)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK));*/
    }
}
