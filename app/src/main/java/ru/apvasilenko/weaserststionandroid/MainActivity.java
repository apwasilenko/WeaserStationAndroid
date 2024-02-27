package ru.apvasilenko.weaserststionandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btUpdate;
    TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        btUpdate = findViewById ( R.id.btUpdate );
        btUpdate.setOnClickListener ( this );

        tvResponse = findViewById ( R.id.tvResponse );

        tvResponse.setText ( R.string.textTV1 );
    }

    @Override
    public void onClick(View view) {
        if (view.getId () == R.id.btUpdate) {
            tvResponse.setText ( R.string.textTV2 );
        }
    }
}