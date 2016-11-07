package id.zainalfahrudin.orbit.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import id.zainalfahrudin.orbit.R;

public class BelajarMethod extends AppCompatActivity implements View.OnClickListener {
    private TextView tvScore;
    private Button buttonMinus, buttonPlus;
    private int realScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar_method);

        tvScore = (TextView) findViewById(R.id.tvScore);
        buttonMinus = (Button) findViewById(R.id.btnMinus);
        buttonPlus = (Button) findViewById(R.id.btnPlus);

        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String stringScore = tvScore.getText().toString();
        int nilaiTvScore = Integer.parseInt(stringScore);

        switch (v.getId()){
            case R.id.btnPlus:
                realScore = nilaiTvScore + 2;
                tvScore.setText(String.valueOf(realScore));
                break;
            case R.id.btnMinus:
                if (nilaiTvScore<1){
                    Toast.makeText(this, "Score is null, cannot decrease", Toast.LENGTH_SHORT).show();
                    Snackbar.make(buttonMinus, "Score is null, cannot decrease", Snackbar.LENGTH_SHORT).show();
                }else{
                    realScore = nilaiTvScore - 2;
                    tvScore.setText(String.valueOf(realScore));
                }
                break;
        }
    }
}
