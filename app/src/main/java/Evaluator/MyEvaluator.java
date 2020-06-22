package Evaluator;


import android.animation.TypeEvaluator;
import android.util.Log;

public class MyEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int end = endValue;
        int start = startValue;
         int a = (int) (start + ( fraction * (end - start)));
         char b = (char) a;
         return b;
    }
}
