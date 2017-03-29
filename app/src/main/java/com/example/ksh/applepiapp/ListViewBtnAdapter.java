package com.example.ksh.applepiapp;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

/**
 * Created by ksh on 2016-08-20.
 */
public class ListViewBtnAdapter extends ArrayAdapter<ListviewBtn> {
    ArrayList<ListviewBtn> items;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ListviewBtn listViewItem = (ListviewBtn) getItem(position);//listviewBtn에서 값을 가져오기 위해 선언
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_list, null);
        TextView titleText = (TextView) view.findViewById(R.id.s_university);
        Button button = (Button) view.findViewById(R.id.s_button);


       // ListviewBtn data = getItem(position);
        titleText.setText(listViewItem.getText());
        button.setText(listViewItem.getBtnStr());
        button.setOnClickListener(new View.OnClickListener() {//버튼눌리면
            @Override
            public void onClick(View v) {
                if(Player.totalJisik >= listViewItem.getKnow()) {
                    Player.totalJisik -= listViewItem.getKnow();
                    
                    String str = listViewItem.getText();
                    String str2 = "에 합격하셨습니다!";
                    Toast toast = Toast.makeText(getContext(), str + str2, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        return view;
    }

    public ListViewBtnAdapter(Context context){//생성자
        super(context, R.layout.item_list);//리스트 xml적용

    }
}