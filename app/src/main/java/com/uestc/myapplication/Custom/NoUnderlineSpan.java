package com.uestc.myapplication.Custom;


import android.text.TextPaint;
import android.text.style.UnderlineSpan;

//去掉下划线
public class NoUnderlineSpan extends UnderlineSpan {
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setUnderlineText(false);
    }
}
