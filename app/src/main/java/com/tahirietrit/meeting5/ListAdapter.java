package com.tahirietrit.meeting5;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by macb on 02/10/17.
 */

public class ListAdapter extends BaseAdapter {

    LayoutInflater inflater;
    public ListAdapter(LayoutInflater inflater){
        this.inflater = inflater;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = inflater.inflate(R.layout.list_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText(arrayList.get(i));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(i);
                notifyDataSetChanged();
            }
        });
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                    if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){

                    }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){

                    }else if(motionEvent.getAction() == MotionEvent.ACTION_CANCEL){

                    }else if(motionEvent.getAction()== MotionEvent.ACTION_MOVE){
//                        view.setX(motionEvent.getRawX());
//                        view.setY(motionEvent.getRawY());
                    }
                return true;
            }
        });
        return view;
    }

    public class ViewHolder{
        TextView textView;
        public ViewHolder(View v){
            textView = (TextView) v.findViewById(R.id.text_view);
        }
    }
    ArrayList<String> arrayList = new ArrayList<>();
    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }
}
