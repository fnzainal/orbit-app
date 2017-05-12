package id.zainalfahrudin.orbit.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.regex.Pattern;

import id.zainalfahrudin.orbit.R;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.subscriptions.CompositeSubscription;

public class Login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private TextView tvUsername, tvPassword;
    final Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    private CompositeSubscription compositeSubscription = new CompositeSubscription();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvPassword = (TextView) findViewById(R.id.tvPassword);
        final Button buttonGo = (Button) findViewById(R.id.btnGo);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, FirstActivity.class));
            }
        });


        compositeSubscription.add(checkUsername().map(new Func1<Boolean, Integer>() {
            @Override
            public Integer call(Boolean aBoolean) {
                return aBoolean ? Color.BLACK : Color.RED;
            }
        }).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer color) {
                        etUsername.setTextColor(color);
                        if (etUsername.getText().length()>1) {
                            tvUsername.setTextColor(color);
                            if (color == Color.RED) {
                                tvUsername.setText("incorrect email");
                            } else {
                                tvUsername.setText("Email");
                            }
                        }else{
                            tvUsername.setTextColor(color);
                            tvUsername.setText("Email");
                        }

                    }
                })
        );

        compositeSubscription.add(checkPassword().map(new Func1<Boolean, Integer>() {
            @Override
            public Integer call(Boolean aBoolean) {
                return aBoolean ? Color.BLACK : Color.RED;
            }
        }).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer color) {
                        etPassword.setTextColor(color);
                        if (etPassword.getText().length()>=6) {
                            tvPassword.setTextColor(color);
                            if (color == Color.RED) {
                                tvPassword.setText("incorrect password");
                            } else {
                                tvPassword.setText("Password");
                            }
                        }
                    }
                })

        );

        compositeSubscription.add(checkFormValid().subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean btnEnabled) {
                int visibility;

                if (btnEnabled){
                    visibility = View.VISIBLE;
                }else{
                    visibility = View.INVISIBLE;
                }
                buttonGo.setVisibility(visibility);
            }
        }));
    }

    private rx.Observable<Boolean> checkUsername(){
        return RxTextView.textChanges(etUsername).map(new Func1<CharSequence, Boolean>()
        {
            @Override
            public Boolean call(CharSequence charSequence) {
                return emailPattern.matcher(charSequence).matches();
            }
        });
    }

    private rx.Observable<Boolean> checkPassword(){
        return RxTextView.textChanges(etPassword).map(new Func1<CharSequence, Boolean>()
        {
            @Override
            public Boolean call(CharSequence charSequence) {
                return charSequence.length()>=6;
            }
        });
    }

    private Observable<Boolean> checkFormValid(){
        return Observable.combineLatest(checkUsername(), checkPassword(), new Func2<Boolean, Boolean, Boolean>() {
            @Override
            public Boolean call(Boolean aBoolean, Boolean aBoolean2) {
                return aBoolean && aBoolean2;
            }
        });
    }

}
