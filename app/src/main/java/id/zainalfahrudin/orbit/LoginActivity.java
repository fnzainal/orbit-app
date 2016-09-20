package id.zainalfahrudin.orbit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsername, etPassword;
    private TextView tvUsername, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        Button buttonGo = (Button) findViewById(R.id.btnGo);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (user.length()<5){
                    etUsername.setError("user minimal 5 karakter");
                }else if (password.length()<6){
                    etPassword.setError("password minimal 6 karakter");
                }else{
                    etUsername.setError(null);
                    etPassword.setError(null);

                    SharedPreferences sharedPreferences = getSharedPreferences("Login", 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("username", user);
                    editor.putString("password", password);
                    editor.commit();

                    startActivity(new Intent(LoginActivity.this, FirstActivity.class));

                }
            }
        });

//
//        buttonGo.setOnClickListener(this);
//        etUsername.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGo:
                //aksi

                break;
            case R.id.tvUsername:
                //aksi
                break;
        }
    }
}
