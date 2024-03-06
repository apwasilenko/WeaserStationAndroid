package ru.apvasilenko.weaserststionandroid.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class SensorView extends View {

    public SensorView(Context context) {
        super ( context );
    }

    public SensorView(Context context, @Nullable AttributeSet attrs) {
        super ( context, attrs );
    }

    public SensorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super ( context, attrs, defStyleAttr );
    }

    public SensorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super ( context, attrs, defStyleAttr, defStyleRes );
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw ( canvas );
        canvas.save (); //Сохраняем холст
//Преобразование осей координат
//        paint.setColor ( 0x99111111 );
//        paint.setStyle ( Paint.Style.FILL );
//        Float radius = Float.valueOf ( (float) (8.0 / 10.0) );
//        canvas.drawCircle ( 0,0, radius, paint );
//        radius = Float.valueOf ( (float) (9.0 / 10.0) );
//        canvas.drawCircle ( 0,0, radius, paint );

        Paint paint = new Paint (Paint.ANTI_ALIAS_FLAG);
        paint.setColor ( Color.CYAN );
        paint.setStyle ( Paint.Style.FILL_AND_STROKE );
        paint.setStrokeWidth ( 1f );
        canvas.drawLine ( 100f, 100f, 300f, 100f, paint );
        canvas.drawLine ( 100f, 70f, 300f, 70f, paint );
        float centerX = getWidth ()/2;
        float centerY = getHeight ()/2;
        float radius =  getHeight ()/2;
        canvas.drawCircle ( centerX, centerY, radius, paint );

        Paint fontPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fontPaint.setColor ( Color.RED );
        fontPaint.setTextSize(40);
        fontPaint.setStyle(Paint.Style.STROKE);
        float width = fontPaint.measureText("10");
        String text = "Ширина = " + getWidth () + "Ширина текста = " + String.valueOf ( width );
        canvas.drawText (text, 100,100, fontPaint );

        canvas.restore ();  // Востонавливаем холст
    }
}