package com.example.ksh.applepiapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by ksh on 2016-08-12.
 */
public class ThirdFragment extends Fragment{
    ListView listView;
    ListViewBtnAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        listView=(ListView)view.findViewById(R.id.list);
        // Adapter 생성
        adapter = new ListViewBtnAdapter(this.getContext()) ;

        // 리스트뷰 참조 및 Adapter달기
        listView.setAdapter(adapter);

        adapter.add(new ListviewBtn("P사","300000 지식",300000));
        adapter.add(new ListviewBtn("I사","200000 지식",200000));
        adapter.add(new ListviewBtn("E사","100000 지식", 100000));

        return view;
    }
}
