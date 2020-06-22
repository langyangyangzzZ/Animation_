package demo.ht.com.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PropertyAnimatorActivity extends AppCompatActivity {

    private TranslateAnimation translateAnimation;
    private TextView tv;

    public int mIndex = 0;
    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animator);

        final Button button_tween = findViewById(R.id.button_tween);
        tv = findViewById(R.id.tv);

        //补间动画
        button_tween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translateAnimation = new TranslateAnimation(0, button_tween.getWidth() * 2, 0, button_tween.getHeight() * 2);
                translateAnimation.setDuration(2000);
                translateAnimation.setFillAfter(true);
                tv.startAnimation(translateAnimation);
            }
        });


        Button button_valueAnimator = findViewById(R.id.button_valueAnimator);
        //属性动画
        button_valueAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueAnimator = ValueAnimator.ofFloat(0f, 400f,200f,600f,405.2f,202.1f,600f);
                valueAnimator.setDuration(2000);
                valueAnimator.setRepeatCount(3);//执行三次
                valueAnimator.setRepeatMode(ValueAnimator.REVERSE);//反转
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        //因为这里咋们使用的是ofFloat所以得强制转换成Float
                        Float animated = (Float) animation.getAnimatedValue();
                        Log.i("szjanimatedValue",animated+"");
                        int animatedValue = animated.intValue();//转换为int类型设置给tv
                        tv.layout(animatedValue,animatedValue,tv.getWidth()+animatedValue,tv.getHeight()+animatedValue);
                    }
                });
                valueAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        //最开始执行
                        Log.i("szjjListener:","start");
                    }
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        //执行完之后在执行
                        Log.i("szjjListener","End");
                    }
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        Log.i("szjjListener","Cancel");
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        //没执行一次执行 在start后执行
                        Log.i("szjjListener","Repeat");
                    }
                });


         valueAnimator.start();
            }
        });

        Button button_clone = findViewById(R.id.button_clone);
        button_clone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valueAnimator == null) {
                    Toast.makeText(PropertyAnimatorActivity.this, "没有获取原控件", Toast.LENGTH_SHORT).show();
                    return;
                }
                

                ValueAnimator clone = valueAnimator.clone();
                clone.setStartDelay(2000);
                clone.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        //因为这里咋们使用的是ofFloat所以得强制转换成Float
                        Float animated = (Float) animation.getAnimatedValue();
                        Log.i("szjanimatedValue",animated+"");
                        int animatedValue = animated.intValue();//转换为int类型设置给tv
                        tv.layout(animatedValue,animatedValue,tv.getWidth()+animatedValue,tv.getHeight()+animatedValue);
                    }
                });
                clone.start();
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIndex++ %2 == 0) {
                    tv.setBackground(getResources().getDrawable(R.color.colorAccent));
                }else{
                    tv.setBackground(getResources().getDrawable(R.color.colorPrimary));
                }
                Toast.makeText(PropertyAnimatorActivity.this, "我被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setReductionClick(View view) {
        if (translateAnimation != null) {
            tv.setBackground(getResources().getDrawable(R.color.colorPrimary));
            translateAnimation.setFillAfter(false);
            translateAnimation.setDuration(0);
            tv.startAnimation(translateAnimation);
            translateAnimation = null;
        }else if(valueAnimator != null){
            valueAnimator.cancel();
            valueAnimator.removeAllListeners();
            valueAnimator = null;
        }


    }
}
