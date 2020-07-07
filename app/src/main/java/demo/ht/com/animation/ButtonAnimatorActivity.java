package demo.ht.com.animation;

import androidx.appcompat.app.AppCompatActivity;
import demo.ht.com.animation.Adapter.MyListViewAdapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ButtonAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button openButton;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_animator);


        openButton = findViewById(R.id.openButton);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        ListView listView = findViewById(R.id.listview);

        ArrayList<String> list = new ArrayList<>();
        list.add("测试数据1");
        list.add("测试数据2");
        list.add("测试数据3");
        list.add("测试数据4");
        list.add("测试数据5");
        list.add("测试数据6");

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);

        listView.setAdapter(stringArrayAdapter);

        //代码设置通过加载XML动画设置文件来创建一个Animation对象；
//        Animation animation= AnimationUtils.loadAnimation(this,R.anim.set_buttonanimator_activity);   //得到一个LayoutAnimationController对象；
//        LayoutAnimationController controller = new LayoutAnimationController(animation);   //设置控件显示的顺序；
//        controller.setOrder(LayoutAnimationController.ORDER_RANDOM);   //设置控件显示间隔时间；
//        controller.setDelay(0.3f);   //为ListView设置LayoutAnimationController属性；
//        listView.setLayoutAnimation(controller);
//        listView.startLayoutAnimation();


        openButton.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);

    }


    Boolean buttonType = false;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.openButton) {
            if (!buttonType) {
                buttonType = true;
                setOpenButton(bt1,0,5,600);
                setOpenButton(bt2,1,5,600);
                setOpenButton(bt3,2,5,600);
                setOpenButton(bt4,3,5,600);
                setOpenButton(bt5,4,5,600);
            }else{
                buttonType = false;
                setCloseButton(bt1,0,5,600);
                setCloseButton(bt2,1,5,600);
                setCloseButton(bt3,2,5,600);
                setCloseButton(bt4,3,5,600);
                setCloseButton(bt5,4,5,600);
            }
        }else{
            Toast.makeText(this, "点击了"+v.getId(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setCloseButton(final Button button, int index, int number, int radio) {
        double degree =   Math.toRadians(90) / (number - 1) * index;
        int x = (int) - (radio * Math.sin(degree));
        int y = (int) - (radio * Math.cos(degree));
        Log.i("setCloseButton",degree+"\n");
        Log.i("setXXX"+ index,x+"\t\t"+y);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(button,"translationX",x , 0),
                ObjectAnimator.ofFloat(button,"translationY",y , 0),
                ObjectAnimator.ofFloat(button,"alpha",1 , 0),
                ObjectAnimator.ofFloat(button,"scaleX",1 , 0),
                ObjectAnimator.ofFloat(button,"scaleY",1 , 0)

        );
//        方法一:
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

                Log.i("szjanimatorSet","onAnimationStart");
            }

            
            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i("szjanimatorSet","end");
                button.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.i("szjanimatorSet","onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

                Log.i("szjanimatorSet","onAnimationRepeat");
            }
        });

        animatorSet.setDuration(500);
        animatorSet.start();
//        方法二:
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                button.setVisibility(View.INVISIBLE);
//            }
//        },500);

    }

    /**
     *
     * @param button    控件对象
     * @param index     当前按钮下标
     * @param number    按钮总个数
     * @param radio     圆的半径
     */
    private void setOpenButton(Button button, int index, int number, int radio) {
        button.setVisibility(View.VISIBLE);
        double degree = Math.toRadians(90)/(number - 1) * index;
       Log.i("setOpenButton",degree+"");
       float x = (float) -(radio * Math.sin(degree));
        float y = (float) -(radio * Math.cos(degree));

        Log.i("szjdegree"+index,x+"\t\t"+y);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(button,"translationX",0,x),
                ObjectAnimator.ofFloat(button,"translationY",0,y),
                ObjectAnimator.ofFloat(button,"alpha",0,1),
                ObjectAnimator.ofFloat(button,"scaleX",0,1),
                ObjectAnimator.ofFloat(button,"scaleY",0,1)

        );

        animatorSet.setDuration(500);
        animatorSet.start();
    }
}
