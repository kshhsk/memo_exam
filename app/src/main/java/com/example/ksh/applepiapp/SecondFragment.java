package com.example.ksh.applepiapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ksh on 2016-08-12.
 */
public class SecondFragment extends Fragment{
    ListView listView;
    ListViewBtnAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        listView=(ListView)view.findViewById(R.id.list);//결론 설명할것도 없다 so ez
        // Adapter 생성
        adapter = new ListViewBtnAdapter(this.getContext()) ;

        // 리스트뷰 참조 및 Adapter달기
        listView.setAdapter(adapter);

        adapter.add(new ListviewBtn("S대","100000 지식",100000));
        adapter.add(new ListviewBtn("K대","50000 지식",50000));
        adapter.add(new ListviewBtn("Y대","50000 지식", 50000));

        return view;
    }

}
