package demo.ht.com.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class TweenAnimation2Activity extends AppCompatActivity {
    private Button button_alpha;
    private Button button_rotate;
    private Button button_scale;
    private Button button_translate,button_set;
    private TextView tv_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation2);

        button_alpha = findViewById(R.id.button_alpha);
        button_rotate = findViewById(R.id.button_rotate);
        button_scale = findViewById(R.id.button_scale);
        button_translate = findViewById(R.id.button_translate);
        button_set = findViewById(R.id.button_set);
        tv_animation = findViewById(R.id.tv_animation);

        //透明动画
        button_alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0.1f);
                alphaAnimation.setDuration(3000);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setRepeatCount(3);
                tv_animation.startAnimation(alphaAnimation);
            }
        });

        //缩放动画
        button_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(
                        0.5f, 1.5f, 0.5f, 1.5f,
                        tv_animation.getWidth()/2,tv_animation.getHeight()/2);
                scaleAnimation.setDuration(3000);
                scaleAnimation.setFillAfter(true);
                tv_animation.startAnimation(scaleAnimation);
            }
        });

        //平移动画
        button_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation translateAnimation = new TranslateAnimation(
                        0f,
                        tv_animation.getWidth()*1.5f,
                       0f,
                        tv_animation.getHeight()*1.5f
                );
                translateAnimation.setDuration(3000);
                translateAnimation.setFillAfter(true);
                tv_animation.startAnimation(translateAnimation);
            }
        });

        //旋转动画
        button_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, tv_animation.getWidth() / 2, tv_animation.getHeight() / 2);
                rotateAnimation.setDuration(3000);
                rotateAnimation.setFillAfter(true);
                tv_animation.startAnimation(rotateAnimation);
            }
        });

        //组合使用
        button_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1f);
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, tv_animation.getWidth() / 2, tv_animation.getHeight() / 2);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0f, 1f, 0f, 1f,tv_animation.getWidth()/2,tv_animation.getHeight()/2);
                TranslateAnimation translateAnimation = new TranslateAnimation(tv_animation.getWidth(),0f,tv_animation.getHeight(),0f);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.setDuration(3000);
                animationSet.setFillAfter(true);
                tv_animation.startAnimation(animationSet);
            }
        });
    }
}
