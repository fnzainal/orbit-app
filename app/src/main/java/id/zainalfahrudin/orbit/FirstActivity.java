package id.zainalfahrudin.orbit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import id.zainalfahrudin.orbit.ui.TypefaceUtil;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF");
        setContentView(R.layout.activity_first);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
