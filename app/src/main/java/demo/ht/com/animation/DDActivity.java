package demo.ht.com.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DDActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dd);
        // 设置为横屏模式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 设置为竖屏模式
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 设置为跟随系统sensor的状态
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        final int x = point.x;
        final int y = point.y;
        Log.i("szjDisplay111", "x = " + x + ",y = " + y);


        final View view1 = findViewById(R.id.view1);
        final View view2 = findViewById(R.id.view2);
        final View view3 = findViewById(R.id.view3);
        final Button button = findViewById(R.id.button);
        final LinearLayout linear_1 = findViewById(R.id.linear_1);
        final LinearLayout linear_2 = findViewById(R.id.linear_2);
        final LinearLayout linear_3 = findViewById(R.id.linear_3);
        final LinearLayout linear_0 = findViewById(R.id.linear_0);
        final LinearLayout linear = findViewById(R.id.linear);

        setObjectAnimator(linear_1, "translationY", 0, 100, 200,300);
        setObjectAnimator(linear_2, "translationY", 0, 100, 200,300);
        setObjectAnimator(linear_3, "translationY", 0, 100, 200,300);
        setObjectAnimator(linear_0, "translationY", 0, 100, 200,300);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear.setVisibility(View.GONE);
                setRotateAnimation(view1.getWidth() / 2, view1.getHeight() / 2, view1);
                setRotateAnimation(view2.getWidth() / 2, view2.getHeight() / 2, view2);
                setRotateAnimation(view3.getWidth() / 2, view3.getHeight() / 2, view3);


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        linear.setVisibility(View.VISIBLE);
                    }
                }, 3000);
            }
        });

    }

    private void setObjectAnimator(LinearLayout linear, String string, float... value) {
        ObjectAnimator translationY = ObjectAnimator.ofFloat(linear, string, value);
        translationY.setDuration(3000);
        translationY.setRepeatCount(-1);
        translationY.setRepeatMode(ValueAnimator.RESTART);
        translationY.start();
    }

    public void setRotateAnimation(int x, int y, View view) {
//        RotateAnimation rotateAnimation = new RotateAnimation(0,90,x/2,y/2);
//        rotateAnimation.setDuration(3000);
//        rotateAnimation.setFillAfter(true);
//        view.setAnimation(rotateAnimation);

        RotateAnimation rotateAnimation = new RotateAnimation(0, 180, x, y);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 1f, 1f, 1f, x, y);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);

        animationSet.setDuration(3000);
        animationSet.setFillAfter(true);
        view.startAnimation(animationSet);


    }
}
