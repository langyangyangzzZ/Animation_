package demo.ht.com.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class AnimatorSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);

        Button button_start = findViewById(R.id.button_start);
        Button button_start_build = findViewById(R.id.button_start_build);
        final TextView tv1 = findViewById(R.id.tv1);
        final TextView tv2 = findViewById(R.id.tv2);
        final TextView tv3 = findViewById(R.id.tv3);

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator tv1TranslationY = ObjectAnimator.ofFloat(tv1, "translationX", 0, 100, 300);
                ObjectAnimator Tv1BackgroundColor = ObjectAnimator.ofInt(tv1, "BackgroundColor", 0xff00ff11, 0xff22ff11, 0xff000011, 0xff019f11);
                ObjectAnimator tv2TranslationY = ObjectAnimator.ofFloat(tv2, "translationY", 0, 100, 300);
//                tv1TranslationY.setDuration(3000);
                AnimatorSet animatorSet = new AnimatorSet();
                //逐个播放
                animatorSet.playSequentially(Tv1BackgroundColor,tv1TranslationY,tv2TranslationY);
                //一起播放
//                animatorSet.playTogether(tv1TranslationY,Tv1BackgroundColor,tv2TranslationY);
                animatorSet.setTarget(tv2);
                animatorSet.setDuration(2000);
                animatorSet.start();

            }
        });



        button_start_build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator tv1TranslationY = ObjectAnimator.ofFloat(tv1, "translationY", 0, 100, 300, 0);
                ObjectAnimator tv1BackgroundColor = ObjectAnimator.ofInt(tv1, "BackgroundColor", 0xff00ff11, 0xff22ff11, 0xff000011, 0xff019f11);
                ObjectAnimator tv2TranslationY = ObjectAnimator.ofFloat(tv2, "translationY", 0, 100, 300, 0);
                ObjectAnimator tv3TranslationY = ObjectAnimator.ofFloat(tv3, "translationY", 0, 100, 300, 0);

                tv1TranslationY.setRepeatCount(-1);
                tv3TranslationY.setStartDelay(3000);

                AnimatorSet animatorSet = new AnimatorSet();
                AnimatorSet.Builder play = animatorSet.play(tv1TranslationY);
                play.before(tv2TranslationY).after(tv3TranslationY).with(tv1BackgroundColor);
                animatorSet.setDuration(3000);


                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.i("szjaddListener","start");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.i("szjaddListener","end");
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        Log.i("szjaddListener","cancel");
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        Log.i("szjaddListener","repeat");
                    }
                });

                animatorSet.start();
            }
        });


    }
}
