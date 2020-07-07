package demo.ht.com.animation.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import demo.ht.com.animation.R;

public class MyListViewAdapter extends ArrayAdapter {

   public ArrayList<String> mlist;
   public Context context;


    public MyListViewAdapter(@NonNull Context context, int resource, ArrayList<String> mlist) {
        super(context, resource, mlist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String item = (String) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, null);
        TextView tv = view.findViewById(R.id.tv);
        tv.setText(item);
        return view;
    }
}
