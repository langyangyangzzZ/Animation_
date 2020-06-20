package demo.ht.com.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class TweenAnimationActivity extends AppCompatActivity {

    private Button button_alpha;
    private Button button_rotate;
    private Button button_scale;
    private Button button_translate,button_set;
    private TextView tv_animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
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
                Animation animation = AnimationUtils.loadAnimation(TweenAnimationActivity.this, R.anim.alpha_anim);
                tv_animation.startAnimation(animation);
            }
        });
        //缩放动画
        button_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(TweenAnimationActivity.this, R.anim.scale_anim);
                tv_animation.startAnimation(animation);
            }
        });

        //平移动画
        button_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(TweenAnimationActivity.this, R.anim.translate_anim);
                tv_animation.startAnimation(animation);
            }
        });

     //旋转动画
        button_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(TweenAnimationActivity.this, R.anim.rotate_anim);
                tv_animation.startAnimation(animation);
            }
        });
        //组合使用
        button_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(TweenAnimationActivity.this, R.anim.set_anim);
                tv_animation.startAnimation(animation);
            }
        });
    }
}
