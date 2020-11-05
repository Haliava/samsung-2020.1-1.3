package ru.samsung.itschool.book.testbed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MyView extends View {
    Paint paint = new Paint();
    boolean flag = true;
    int previous_r = 20;
    int counter = 5;
    float x = 0;
    float y = 0;

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GREEN);
        if (flag) {
            canvas.drawCircle(x, y, previous_r, paint);
            if (counter == 0) {
                flag = false;
                counter = 5;
            } else counter -= 1;
        } else {
            previous_r = new Random().nextInt(50);
            canvas.drawCircle(x, y, previous_r, paint);
            flag = true;
            if (counter == 0) {
                flag = false;
                counter = 5;
            } else counter -= 1;
        }
        y += 1;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        return true;
    }
}
