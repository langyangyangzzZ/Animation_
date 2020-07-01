package demo.ht.com.animation.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import demo.ht.com.animation.Bean.PointBean;

public class MyPointView extends View {
    public PointBean pointBean = new PointBean(100);
    private Paint mPaint;

    public MyPointView(Context context) {
        super(context);
    }

    public MyPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPaint != null) {
            canvas.drawCircle(300,300,pointBean.getRadio(),mPaint);
        }
    }

    public void setPointBean(int radio){
        pointBean.setRadio(radio);
        invalidate();
    }
}
