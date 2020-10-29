package jp.ac.shohoku.s19b712;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainView extends View{
 public final int FIRST = 1;
 public final int SECOND = 2;
 public final int THIRD = 3;

         int state;
         public MainView(Context context, AttributeSet attrs) {
         super(context, attrs);
         state = FIRST;
         }
    @Override
 protected void onDraw(Canvas canvas) {
         super.onDraw(canvas);
         Paint p = new Paint();

         if(state == FIRST) {
             p.setColor(Color.BLUE);
             canvas.drawARGB(255, 255, 255, 255);
             canvas.drawRect(100, 100, 300, 200, p);
             } else if (state == SECOND){
             p.setColor(Color.RED);
             canvas.drawARGB(255, 255, 255, 0);
             canvas.drawRect(100, 100, 300, 200, p);
             } else if (state == THIRD){
             p.setColor(Color.GREEN);
             canvas.drawARGB(255, 0, 0, 0);
             canvas.drawRect(100, 100, 300, 200, p);
             } else {
             Log.d("error", "never come here");
             }
         }
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int x = (int) event.getX();
             int y = (int) event.getY();


             if(x>100 && x < 300 && y>100 && y<200) {
                 if(state == FIRST){
                     state = SECOND;
                     } else if (state == SECOND) {
                     state = THIRD;
                     } else if (state == THIRD) {
                     state = FIRST;
                     } else {
                     Log.d("error", "never come here");
                     }
                 }

            invalidate();
            return super.onTouchEvent(event);
             }
 }



