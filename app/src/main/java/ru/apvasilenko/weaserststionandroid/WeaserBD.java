package ru.apvasilenko.weaserststionandroid;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class WeaserBD {

    private Thread secThread;
    private Runnable runnable;
    private URL url;
    private Document doc;
    private String text_html = "---";



    public String getBDHtml() throws InterruptedException {
        ReadHtml ();
        return text_html;
    }
    private void ReadHtml() throws InterruptedException {
        runnable = new Runnable () {
            @Override
            public void run() {
                try {
                    url = new URL ( "http","f0659051.xsph.ru", 80, "/temper/php/data_out.php?mytype=temper&limit=10");
                    doc = Jsoup.connect (url.toString ()).timeout ( 5000 ).get();
                    text_html = doc.body ().toString ();
                } catch (IOException e) {
                    e.printStackTrace ();
                    Log.d("mLog",e.toString ());
                }
                Log.d("mLog", text_html );
                text_html = text_html.replace ("\n", "");
                text_html = text_html.replace ("<body>", "");
                text_html = text_html.replace ("</body>", "");
                try {
                    JSONArray jsonArray = new JSONArray ( text_html );
                    JSONObject jsonObject = jsonArray.getJSONObject ( 1 );
                    String temper = jsonObject.getString ( "t_home" );
                    Log.d ( "mLog", jsonObject.toString () );
                    text_html = temper;
                    Log.d("mLog", temper);

                } catch (JSONException e){
                    e.printStackTrace ();
                    Log.d("mLog",e.toString ());
                }

            }
        };
        secThread = new Thread (runnable);
        secThread.start();
        secThread.join (5000);
    }
}
