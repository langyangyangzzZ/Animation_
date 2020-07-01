package demo.ht.com.animation;

import androidx.appcompat.app.AppCompatActivity;
import demo.ht.com.animation.View.MyPointView;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ObjectAnimatorActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        tv = findViewById(R.id.tv);
        Button button_alpha = findViewById(R.id.button_alpha);
        Button button_rotation = findViewById(R.id.button_rotation);
        Button button_rotationX = findViewById(R.id.button_rotationX);
        Button button_rotationY = findViewById(R.id.button_rotationY);
        Button button_translationY = findViewById(R.id.button_translationY);
        Button button_tranlationX = findViewById(R.id.button_tranlationX);
        Button button_scaleX = findViewById(R.id.button_scaleX);
        Button button_scaleY = findViewById(R.id.button_scaleY);
        final MyPointView pointView = findViewById(R.id.pointView);
        Button button_start = findViewById(R.id.button_start);

        //alpha
        button_alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ObjectAnimatorActivity.this, "alpha", Toast.LENGTH_SHORT).show();
                ObjectAnimator alpha = ObjectAnimator.ofFloat(tv, "alpha", 1, 0, 1,0.5f,0,1);
                alpha.setDuration(3000);
                alpha.start();
            }
        });

        //旋转动画
        button_rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setObjectAnimatorOfFloat("rotation",0,180,-360,0);
            }
        });
        button_rotationX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setObjectAnimatorOfFloat("rotationX",0,180,360,0);
            }
        });
        button_rotationY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setObjectAnimatorOfFloat("rotationY",0,180,360,0);
            }
        });


        //平移
        button_tranlationX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setObjectAnimatorOfFloat("translationX",0,180,360,0);
            }
        });
        button_translationY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setObjectAnimatorOfFloat("translationY",0,-180,360,0);
            }
        });

        //缩放
        button_scaleX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setObjectAnimatorOfFloat("scaleX",0,1,2,1);
            }
        });

        button_scaleY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setObjectAnimatorOfFloat("scaleY",0,1,2,1);
            }
        });

        //圆形动画开始
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator pointBean = ObjectAnimator.ofInt(pointView, "PointBean", 0,200, 300, 100);
                pointBean.setDuration(3000);
                pointBean.start();
//                pointView.setPointBean();

            }
        });


    }




    private void setObjectAnimatorOfFloat(String propertyName, float... values) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv, propertyName, values);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }
}
