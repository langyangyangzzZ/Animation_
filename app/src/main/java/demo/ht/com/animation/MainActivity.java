package demo.ht.com.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_tween = findViewById(R.id.button_tween);

        //Tween Animation补间动画
        button_tween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TweenAnimationActivity.class));
            }
        });

        Button button_tween2 = findViewById(R.id.button_tween2);
        //Tween Animation补间动画 动态代码实现
        button_tween2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TweenAnimation2Activity.class));
            }
        });

        Button button_property = findViewById(R.id.button_property);

        button_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PropertyAnimatorActivity.class));
            }
        });
    }
}
