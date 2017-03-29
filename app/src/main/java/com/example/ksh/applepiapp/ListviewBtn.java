package com.example.ksh.applepiapp;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ksh on 2016-08-20.
 */
public class ListviewBtn {
    private String textStr;//텍스트
    private String btnStr;//버튼 텍스트
    private int know;

    public ListviewBtn(String textViewText, String btnText,int know) {
        setText(textViewText);
        setBtnStr(btnText);
        setKnow(know);
    }

    public void setText(String text) {//값저장
        textStr = text;

    }
    public void setBtnStr(String text){
        btnStr=text;
    }

    public void setKnow(int know) {
        this.know = know;
    }

    public String getText() {//값호출
        return this.textStr;
    }
    public  String getBtnStr(){
        return this.btnStr;
    }
    public int getKnow(){
        return this.know;
    }

}

