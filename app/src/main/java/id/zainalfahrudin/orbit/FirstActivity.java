package id.zainalfahrudin.orbit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF");
        setContentView(R.layout.activity_first);
    }
}
