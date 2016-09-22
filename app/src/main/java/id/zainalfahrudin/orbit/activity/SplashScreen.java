package id.zainalfahrudin.orbit.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

import id.zainalfahrudin.orbit.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final SharedPreferences sharedPreferences = getSharedPreferences("Login", 0);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String username = sharedPreferences.getString("username","");
                if (username.length()<5){
                    //jika panjang karakter username kurang dari 5 login terlebih dahulu
                    startActivity(new Intent(SplashScreen.this,LoginActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                                    | Intent.FLAG_ACTIVITY_NEW_TASK)

                    );
                }else{
                    //jika panjang karakter username lebih dari = 5 maka masuk ke FirstActivity
                    startActivity(new Intent(SplashScreen.this, FirstActivity.class));
                }

            }
        },3000); //3000 ms = 3 detik
    }
}
