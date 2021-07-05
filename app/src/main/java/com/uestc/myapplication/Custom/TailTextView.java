package com.uestc.myapplication.Custom;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import com.uestc.myapplication.R;
import com.uestc.myapplication.ui.activity.HomeDetailActivity;

public class TailTextView extends AppCompatTextView {
    private boolean showTail = true;
    private boolean isEllipsed = false;     //标识是否已经处理过
    private static final String LINE_BREAKER = "\n";
    private String tailText = " … 全文";
    private String clickText = "全文";

    public TailTextView(Context context) {
        this(context, null);
    }

    public TailTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TailTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //不显示小尾巴或者已经处理过的不再处理
        if (!showTail || isEllipsed) {
            return;
        }
        int lineCount = getLineCount();
        Layout layout = getLayout();
        int maxLines = getMaxLines();
        //行数没有到maxLines不处理
        if (maxLines == 0 || lineCount < maxLines || TextUtils.isEmpty(getText())) ;
        else {
            //offset是从第一行第一个字符开始算起的·    getLineEnd中的行数，是从0开始计算的
            int lineEndIndex = layout.getLineEnd(maxLines - 1); //第 maxLines 行的末字符offset
            int lineStartIndex = layout.getLineStart(maxLines - 1); //第 maxLines 行的首字符offset
            if (lineEndIndex >= getText().length()) return;     //如果text总长度没超过第maxLines行，不做处理，直接返回

            CharSequence mustShowText = getText().subSequence(0, lineStartIndex);   //第 maxLines 行前的所有字符
            float tailWidth = getPaint().measureText(tailText);     //当长度超过时，需要显示在末尾的字符串的长度（此处为：...全文）
            CharSequence lastLineText;
            //最后一个字是个换行符就把这个换行符去掉，不然不能在那一行后面增加文字了
            if (LINE_BREAKER.equals(String.valueOf(getText().charAt(lineEndIndex - 1)))) {
                lastLineText = getText().subSequence(lineStartIndex, lineEndIndex - 1);
            } else {
                lastLineText = getText().subSequence(lineStartIndex, lineEndIndex);
            }
            int availableWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();     //获得一行可以显示的宽度
            //设置最后一行需要截取的部分
            CharSequence ellipsizeLastLineText = TextUtils.ellipsize(lastLineText, getPaint(), availableWidth - tailWidth,
                    TextUtils.TruncateAt.END);
            if (ellipsizeLastLineText.length() > 2 && ellipsizeLastLineText != lastLineText) {
                lastLineText = ellipsizeLastLineText.subSequence(0, ellipsizeLastLineText.length() - 1);
            }
            //通过 SpannableStringBuilder 类来设置文字，以及文字的多种属性
            SpannableStringBuilder ssb = new SpannableStringBuilder(mustShowText);
            ssb.append(lastLineText).append(tailText);
//            //文字点击事件设置
//            ClickableSpan clickableSpan = new ClickableSpan() {
//                @Override
//                public void onClick(View view) {
////                    BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.parseColor(String.valueOf(android.R.color.holo_blue_bright)));
////                    ssb.setSpan(backgroundColorSpan,ssb.length() - clickText.length(), ssb.length(),
////                            Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
////                    setText(ssb);
////                    setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
//                    getContext().startActivity(new Intent(getContext(), HomeDetailActivity.class));
//                }
//
////                @Override
////                public void updateDrawState(@NonNull TextPaint ds) {
////                    super.updateDrawState(ds);
////                    ds.bgColor = getResources().getColor(android.R.color.holo_blue_bright);
////                    ds.setColor(getResources().getColor(android.R.color.holo_blue_bright));
////                    ds.setUnderlineText(false);
////                    ds.clearShadowLayer();
////                }
//            };
//            ClickSpan clickSpan = new ClickSpan();
//            ssb.setSpan(clickableSpan,ssb.length() - clickText.length(), ssb.length(),
//                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            //去掉下划线
            ssb.setSpan(new NoUnderlineSpan(),0, ssb.length(),Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

            //文字颜色设置，需要防在后面，不然颜色设置会被覆盖
            ssb.setSpan(new ForegroundColorSpan(getResources().getColor(android.R.color.holo_blue_dark)),
                    ssb.length() - tailText.length(), ssb.length(),
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            setText(ssb);
            setMovementMethod(LinkMovementMethod.getInstance());
            //重置一下这个位
            isEllipsed = false;
        }
    }
}