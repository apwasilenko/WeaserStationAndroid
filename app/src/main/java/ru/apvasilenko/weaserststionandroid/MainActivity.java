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

        btUpdate = (Button) findViewById ( R.id.btUpdate );
        btUpdate.setOnClickListener ( this );

        tvResponse = (TextView) findViewById ( R.id.tvResponse );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.btUpdate:
                tvResponse.setText (  R.string.textTV2);
        }
    }
}