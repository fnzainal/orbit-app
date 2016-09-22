package id.zainalfahrudin.orbit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import id.zainalfahrudin.orbit.R;
import id.zainalfahrudin.orbit.ui.CircleImageView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF");
        setContentView(R.layout.activity_first);

        CircleImageView imageView = (CircleImageView) findViewById(R.id.tvAva);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Logout!", Toast.LENGTH_SHORT).show();
                getSharedPreferences("Login",0).edit().clear().apply();
                startActivity(new Intent(FirstActivity.this,Login.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_HOME)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
