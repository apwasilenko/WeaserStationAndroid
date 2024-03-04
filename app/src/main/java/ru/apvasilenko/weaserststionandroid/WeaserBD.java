package ru.apvasilenko.weaserststionandroid;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.URL;
import java.util.GregorianCalendar;

public class WeaserBD extends WeaserPoint{
    public WeaserBD(String urlstr){
        try {
            BDHtmlToJson (urlstr);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    private String text_html = "---";

    public String getBDHtml(){
        return text_html;
    }

    public WeaserPoint[] arrayWeiserPoint;


    private void BDHtmlToJson(String urlstr) throws InterruptedException {
        Runnable runnable = new Runnable () {
            @Override
            public void run() {
                try {
                    URL url = new URL ( urlstr);
                    Document doc = Jsoup.connect ( url.toString () ).timeout ( 4000 ).get ();
                    text_html = doc.body ().toString ();
                } catch (IOException e) {
                    e.printStackTrace ();
                    Log.d ( "mLog", e.toString () );
                }
                Log.d ( "mLog", text_html );
                text_html = text_html.replace ( "\n", "" );
                text_html = text_html.replace ( "<body>", "" );
                text_html = text_html.replace ( "</body>", "" );

            }
        };
        Thread secThread = new Thread ( runnable );
        secThread.start();
        secThread.join (5000);
    }

    public void getArrJson(String text_html){
        try {
            JSONArray jsonArray = new JSONArray ( text_html );
            int count = jsonArray.length ();
            arrayWeiserPoint = new WeaserPoint[count];
            for (int i = 0; i < count; i++){
                JSONObject jsonObject = jsonArray.getJSONObject ( i );
                WeaserPoint weaserPoint = new WeaserPoint ();
                String d_Time = jsonObject.getString ( "datetime" );
                int year = Integer.parseInt( d_Time.substring ( 0, 4 ) );
                int month = Integer.parseInt( d_Time.substring ( 5, 7 )) - 1;
                int day = Integer.parseInt( d_Time.substring ( 8, 10 ));
                int hour = Integer.parseInt( d_Time.substring ( 11, 13 ));
                int min = Integer.parseInt( d_Time.substring ( 14, 16 ));
                int sec = Integer.parseInt( d_Time.substring ( 17, 19 ));
                weaserPoint.datetime = new GregorianCalendar( year, month, day, hour, min, sec );
                weaserPoint.t_boller = jsonObject.getDouble ( "t_boller" );
                weaserPoint.t_home = jsonObject.getDouble ( "t_home" );
                weaserPoint.t_street = jsonObject.getDouble ( "t_street" );
                String log = weaserPoint.datetime.getTime ().toString () + "| Температура на улице - "
                        + weaserPoint.t_home;
                arrayWeiserPoint[i] = weaserPoint;
                Log.d ( "mLog", log );
            }
        } catch (JSONException e){
            e.printStackTrace ();
            Log.d("mLog",e.toString ());
        }
    }
}
