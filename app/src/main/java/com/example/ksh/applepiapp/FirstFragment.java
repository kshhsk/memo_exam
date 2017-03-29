package com.example.ksh.applepiapp;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ksh on 2016-08-12.
 */
public class FirstFragment extends Fragment {
    static Context mContext;
    Button button;

    TextView gisik;
    TextView Lv;
    TextView level_up;

    RbPreference pref;

    int minus_gisik=50;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext=getContext();
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        button=(Button)view.findViewById(R.id.button_Lv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Player.totalJisik >= minus_gisik) {
                    Player.totalJisik -= minus_gisik; // 총 지식에서 빠지는 부분
                    minus_gisik = minus_gisik * 2; // 한번 레벨업할때마다 필요한 지식의 수 *2

                    pref.put("minus_gisik", minus_gisik);
                    ((MainActivity) getActivity()).sum_gisik.setText(String.valueOf(Player.totalJisik));
                    Player.increaseJisik += Player.increaseJisikLevelUp;  // d = 레벨업할때 올라가는 터치당 지식수

                    gisik.setText("" + Player.increaseJisik); //gisik = 03 지식 같은 텍스트
                    level_up.setText("" + minus_gisik); //레벨업하려면 ~ 이부분 텍스트변화
                    pref.put("increase_gisik", Player.increaseJisik);

                    Lv.setText("" + ++Player.level); // 텍스트 LV 1씩 증가
                    pref.put("LEVEL", Player.level);

                }
            }
        });


        gisik = (TextView) view.findViewById(R.id.gisik);
        Lv = (TextView) view.findViewById(R.id.LV);
        level_up = (TextView) view.findViewById(R.id.level_up);
        pref = new RbPreference(getContext());

        minus_gisik=pref.getValue("minus_gisik",50);
        Player.increaseJisik=pref.getValue("increase_gisik", 3);
        Player.level=pref.getValue("LEVEL",1);

        gisik.setText(String.valueOf(Player.increaseJisik));
        Lv.setText(String.valueOf(Player.level));
        level_up.setText(String.valueOf(minus_gisik));
        return view;
    }






}
