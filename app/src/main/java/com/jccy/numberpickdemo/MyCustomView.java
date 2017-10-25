package com.jccy.numberpickdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by heyangyang on 2017/10/24.
 */

public class MyCustomView extends View {

    private Paint paint;
    private float density;
    private float radius;
    private RectF rectF;

    public MyCustomView(Context context) {
        this(context, null);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        density = getResources().getDisplayMetrics().density;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2 * density);

        radius = 90 * density;
        rectF = new RectF(-radius, -radius, radius, radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.translate(width/2, height - 2 * density);

        float startAngle = -180;
        float sweepAngle = 9;
        for (int i = 0; i < 21; i++){
            float startX = (float) (radius * Math.cos(startAngle / 180 * Math.PI));
            float startY = (float) (radius * Math.sin(startAngle / 180 * Math.PI));
            if (i % 5 == 0){
                paint.setColor(Color.BLUE);
                float endX = (float) ((radius - 10 * density) * Math.cos(startAngle / 180 * Math.PI));
                float endY = (float) ((radius - 10 * density) * Math.sin(startAngle / 180 * Math.PI));
                canvas.drawLine(startX, startY, endX, endY, paint);
            }else {
                paint.setColor(Color.BLACK);
                float endX = (float) ((radius - 5 * density) * Math.cos(startAngle / 180 * Math.PI));
                float endY = (float) ((radius - 5 * density) * Math.sin(startAngle / 180 * Math.PI));
                canvas.drawLine(startX, startY, endX, endY, paint);
            }
            startAngle += sweepAngle;
        }
        paint.setColor(Color.BLACK);
        canvas.drawArc(rectF, -180, 180f, false, paint);
    }
}
