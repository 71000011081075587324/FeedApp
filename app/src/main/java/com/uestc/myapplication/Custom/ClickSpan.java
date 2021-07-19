//package com.uestc.myapplication.Custom;
//
//import android.content.Intent;
//import android.graphics.Color;
//import android.text.TextPaint;
//import android.text.style.ClickableSpan;
//import android.view.View;
//
//import androidx.annotation.NonNull;
//
//import com.uestc.myapplication.ui.activity.HomeDetailActivity;
//
//public class ClickSpan extends ClickableSpan {
//    @Override
//    public void onClick(@NonNull View widget) {
//        widget.getContext().startActivity(new Intent(widget.getContext(), HomeDetailActivity.class));
//    }
//
////    @Override
////    public void updateDrawState(@NonNull TextPaint ds) {
////        super.updateDrawState(ds);
////        ds.setColor(getResources().getColor(android.R.color.holo_blue_bright));
////        ds.setUnderlineText(false);
////        ds.clearShadowLayer();
////    }
//}
