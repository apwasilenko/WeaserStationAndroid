package ru.apvasilenko.weaserststionandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private WeaserBD weaserBD;
    WeaserPoint[] arrayWeaserPoint;

    Button btUpdate;
    TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        weaserBD = new WeaserBD ("http://f0659051.xsph.ru:80/temper/php/data_out.php?mytype=temper&limit=60");

        btUpdate = findViewById ( R.id.btUpdate );
        btUpdate.setOnClickListener ( this );

        tvResponse = findViewById ( R.id.tvResponse );

        tvResponse.setText ( R.string.textTV1 );
    }

    @Override
    public void onClick(View view) {
        if (view.getId () == R.id.btUpdate) {
            updateWeaserBD ();
        }
    }

    public void updateWeaserBD(){
        weaserBD.getArrJson ( weaserBD.getBDHtml () );
        Log.d ( "mLog", "Обновлено" );
        String txtTvResponse = "Температура на улице " +
                String.valueOf ( weaserBD.arrayWeiserPoint[0].t_street.toString () );
        tvResponse.setText ( txtTvResponse);
        for (int i = 0; i < weaserBD.arrayWeiserPoint.length; i++){
            String log = String.valueOf ( weaserBD.arrayWeiserPoint[i].datetime.getTime ().toString ()) + "| Температура на улице - "
                    + String.valueOf ( weaserBD.arrayWeiserPoint[i].t_home.toString ());
            Log.d ( "mLog", log );
        }
    }
}