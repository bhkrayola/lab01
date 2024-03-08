package com.hobrian.lab08;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Paint;


import androidx.annotation.Nullable;

public class DrawView extends View {
    private Paint p = new Paint();
    private int y=0, dY=5;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        p.setColor(Color.parseColor("#FFA500"));
        canvas.drawCircle(getWidth()/2,getHeight()/2,400f,p);
        canvas.drawCircle(100,200,150.5f,new Paint());
        y+=dY;
        y%=getHeight();
        invalidate();
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }
}
