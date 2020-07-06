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

    private ImageView image_car;
    private View view3,view4,view5;
    private int mX;
    private int mY;
    private View view1;
    private View view2;

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
        mX = point.x;
        mY = point.y;
        Log.i("szjDisplay111", "x = " + mX + ",y = " + mY);


        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        view5 = findViewById(R.id.view5);
        final Button button = findViewById(R.id.button);
        final LinearLayout linear_1 = findViewById(R.id.linear_1);
        final LinearLayout linear_2 = findViewById(R.id.linear_2);
        final LinearLayout linear_3 = findViewById(R.id.linear_3);
        final LinearLayout linear_0 = findViewById(R.id.linear_0);
        final LinearLayout linear = findViewById(R.id.linear);
        final LinearLayout linear_view = findViewById(R.id.linear_view);
        image_car = findViewById(R.id.image_car);

        setObjectAnimator(linear_1, "translationY", 0, 100, 200,300);
        setObjectAnimator(linear_2, "translationY", 0, 100, 200,300);
        setObjectAnimator(linear_3, "translationY", 0, 100, 200,300);
        setObjectAnimator(linear_0, "translationY", 0, 100, 200,300);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear.setVisibility(View.GONE);
                setObjectAnimatorOfFloat(linear_view,"rotation",0,180);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        linear.setVisibility(View.VISIBLE);
                        Log.i("szjButton",(mX/2 -view3.getPaddingLeft()) +"\t\t"+view3.getPaddingLeft());

                        settranslationXAnimator(image_car,0,50,90,90,90,90,90,0);
                        view1.setVisibility(View.VISIBLE);
                        setAlphaAnimation(view1,0,1,0);
                        setAlphaAnimation(view4,1,0,1);
                        settranslationXAnimator(linear_0,0,90,0);
                        settranslationXAnimator(linear_1,0,90,0);
                        settranslationXAnimator(linear_2,0,90,0);
                        settranslationXAnimator(linear_3,0,90,0);
                    }
                }, 3000);
            }
        });

    }

    private void setAlphaAnimation(View view1, float... value) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view1, "alpha", value);
        alpha.setDuration(8000);
        alpha.start();
    }

    public void settranslationXAnimator(View view , float... value){
        ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", value);
        translationX.setDuration(8000);
        translationX.setAutoCancel(true);
        translationX.start();
    }

    private void setObjectAnimator(LinearLayout linear, String string, float... value) {
        ObjectAnimator translationY = ObjectAnimator.ofFloat(linear, string, value);
        translationY.setDuration(3000);
        translationY.setRepeatCount(-1);
        translationY.setRepeatMode(ValueAnimator.RESTART);
        translationY.start();
    }

    private void setObjectAnimatorOfFloat(View view ,String propertyName, float... values) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, propertyName, values);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }
}
