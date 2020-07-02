package demo.ht.com.animation;

import Evaluator.MyEvaluator;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class PropertyValuesHolderActivity extends AppCompatActivity {

    private MyTextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_values_holder);

        Button button_start = findViewById(R.id.button_start);
        final TextView tv = findViewById(R.id.tv);
        myTextView = findViewById(R.id.myTextView);


        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                PropertyValuesHolder rotate = PropertyValuesHolder.ofFloat("Rotation", 40f, -40f, 50f, -50f, 60f, -60f,0);
//                PropertyValuesHolder background = PropertyValuesHolder.ofInt("BackgroundColor", 0xffff00ff, 0xffffff00, 0xff00ffff, 0xff00ff00);
//
//                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(tv, rotate, background);
//                objectAnimator.setDuration(3000);
//                objectAnimator.setInterpolator(new BounceInterpolator());
//                objectAnimator.start();

                Keyframe keyframe = Keyframe.ofFloat(0f, 0);
                Keyframe keyframe1 = Keyframe.ofFloat(0.1f, 20f);
                Keyframe keyframe2 = Keyframe.ofFloat(0.2f, -20f);
                Keyframe keyframe3 = Keyframe.ofFloat(0.3f, 40f);
                Keyframe keyframe4 = Keyframe.ofFloat(0.4f, -40f);
                Keyframe keyframe5 = Keyframe.ofFloat(0.5f, 20f);
                Keyframe keyframe6 = Keyframe.ofFloat(0.6f, -20f);
                Keyframe keyframe7 = Keyframe.ofFloat(0.7f, 40f);
                Keyframe keyframe8 = Keyframe.ofFloat(0.8f, -40f);
                Keyframe keyframe9 = Keyframe.ofFloat(0.9f, 20f);
                Keyframe keyframe10 = Keyframe.ofFloat(1f, 0);


                Keyframe scaleKeyframe = Keyframe.ofFloat(0f, 0);
                Keyframe scaleKeyframe1 = Keyframe.ofFloat(0.1f, 1.1f);
                Keyframe scaleKeyframe2 = Keyframe.ofFloat(0.2f, 1.2f);
                Keyframe scaleKeyframe3 = Keyframe.ofFloat(0.3f, 1.2f);
                Keyframe scaleKeyframe4 = Keyframe.ofFloat(0.4f, 2f);
                Keyframe scaleKeyframe5 = Keyframe.ofFloat(0.5f, 2f);
                Keyframe scaleKeyframe6 = Keyframe.ofFloat(0.6f, 1.2f);
                Keyframe scaleKeyframe7 = Keyframe.ofFloat(0.7f, 1.1f);
                Keyframe scaleKeyframe8 = Keyframe.ofFloat(0.8f, 1.1f);
                Keyframe scaleKeyframe9 = Keyframe.ofFloat(0.9f, 1.5f);
                Keyframe scaleKeyframe10 = Keyframe.ofFloat(1f, 1f);


                PropertyValuesHolder rotation = PropertyValuesHolder.ofKeyframe("rotation"
                                                                                        ,keyframe, keyframe1, keyframe2, keyframe3, keyframe4,
                                                                                        keyframe5, keyframe6, keyframe7, keyframe8, keyframe9, keyframe10);

                PropertyValuesHolder scale = PropertyValuesHolder.ofKeyframe("scaleX"
                                                                                       ,scaleKeyframe, scaleKeyframe1, scaleKeyframe2, scaleKeyframe3, scaleKeyframe4,
                        scaleKeyframe5, scaleKeyframe6, scaleKeyframe7, scaleKeyframe8,scaleKeyframe9, scaleKeyframe10);


                ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(tv, rotation,scale);
                objectAnimator1.setDuration(3000);
                objectAnimator1.start();




            }
        });


    }

    public void onClickButtonA_Z(View view) {

        // Keyframe.ofObject实现
//        Keyframe objectKetframeA = Keyframe.ofObject(0, 'A');
//        Keyframe objectKetframeC = Keyframe.ofObject(0.3f, 'C');
//        Keyframe objectKetframeZ = Keyframe.ofObject(1f, 'Z');
//        PropertyValuesHolder textTitle = PropertyValuesHolder.ofKeyframe("TextTitle", objectKetframeA, objectKetframeC, objectKetframeZ);
//        textTitle.setEvaluator(new MyEvaluator());
//        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(myTextView, textTitle);
//        objectAnimator.setDuration(3000);
//        objectAnimator.start();


        //PropertyValuesHolder.ofObject实现
        PropertyValuesHolder TextTitle = PropertyValuesHolder.ofObject("TextTitle",new MyEvaluator(), new Character('A'), new Character('Z'));
        PropertyValuesHolder backgroundColor = PropertyValuesHolder.ofInt("backgroundColor",0xffff00ff,0xffffff00,0xff00ff00,0xff00f0f0);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY",1.1f,1,5,1f,7f,1f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(myTextView, TextTitle,backgroundColor,scaleY);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }
}
