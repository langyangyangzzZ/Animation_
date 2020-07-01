package demo.ht.com.animation;

import Evaluator.MyEvaluator;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class PropertyOfObjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_of_object);
        Button button_start = findViewById(R.id.button_start);
        final TextView tv = findViewById(R.id.tv);



        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyEvaluator(), 'A', 'Z');
                valueAnimator.setDuration(3000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {

                        Character animatedValue = (Character) animation.getAnimatedValue();
                        tv.setText(String.valueOf(animatedValue));

                    }
                });
                valueAnimator.start();
            }
        });


    }
}
