package com.uestc.myapplication.Custom;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.uestc.myapplication.utils.FlingHelper;

import java.util.Objects;

public class NestedScrollLayout extends NestedScrollView {

    ViewGroup mHeadViewFirst;//顶部控件 1
    ViewGroup mHeadViewSecond;//顶部控件 2
    ViewGroup mContentView;//内容控件
    int mVelocityY;//惯性滚动速度
    FlingHelper mFlingHelper;//处理惯性滑动速度与距离的转化
    int mConsumedY;//记录自身已经滚动的距离

    public NestedScrollLayout(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NestedScrollLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mFlingHelper = new FlingHelper(getContext());
        //设置滚动监听事件
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setOnScrollChangeListener(new View.OnScrollChangeListener() {

                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                    Log.e(getClass().getSimpleName(), "->" + String.valueOf(getChildAt(0)));

                    /*
                     * scrollY 表示已经滑动的距离
                     * scrollY == 0 即还未滚动
                     * scrollY == getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()即滚动到顶部了
                     */
                    //判断NestedScrollView是否滚动到顶部，若滚动到顶部，判断子控件是否需要继续滚动滚动
                    if (scrollY == ((ViewGroup)getChildAt(0)).getChildAt(0).getMeasuredHeight() || scrollY == ((ViewGroup)getChildAt(0)).getChildAt(1).getMeasuredHeight() ) {
                        dispatchChildFling();
                    }
                    //累计自身滚动的距离
                    mConsumedY += scrollY - oldScrollY;
                }
            });
        }
    }

    //将惯性滑动剩余的距离分发给子控件，继续惯性滑动
    private void dispatchChildFling() {
        if (mVelocityY != 0) {
            //将惯性滑动速度转化成距离
            double distance = mFlingHelper.getSplineFlingDistance(mVelocityY);
            //计算子控件应该滑动的距离 = 惯性滑动距离 - 已滑距离
            if (distance > mConsumedY) {
                RecyclerView recyclerView = getChildRecyclerView(mContentView);
                if (recyclerView != null) {
                    //将剩余滑动距离转化成速度交给子控件进行惯性滑动
                    int velocityY = mFlingHelper.getVelocityByDistance(distance - mConsumedY);
                    recyclerView.fling(0, velocityY);
                }
            }
        }

        mConsumedY = 0;
        mVelocityY = 0;
    }

    //当 View/ViewGroup  中所有的子控件均被映射成xml实例化后会回调
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e(getClass().getSimpleName(), "onFinishInflate()" + String.valueOf(getChildCount()));
        Log.e(getClass().getSimpleName(),"onFinishInflate()"  + String.valueOf(((ViewGroup)getChildAt(0)).getChildCount()));
        Log.e(getClass().getSimpleName(), "onFinishInflate()" + String.valueOf(getChildCount()));
        Log.e(getClass().getSimpleName(),"onFinishInflate()"  + String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(0)));
        Log.e(getClass().getSimpleName(),"onFinishInflate()"  + String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(1)));
        Log.e(getClass().getSimpleName(),"onFinishInflate()"  + String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(2)));
        mHeadViewFirst = (ViewGroup) ((ViewGroup) getChildAt(0)).getChildAt(0);
        mHeadViewSecond = (ViewGroup) ((ViewGroup) getChildAt(0)).getChildAt(1);
        mContentView = (ViewGroup) ((ViewGroup) getChildAt(0)).getChildAt(2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(getClass().getSimpleName(), "onMeasure()" + String.valueOf(getChildCount()));
        Log.e(getClass().getSimpleName(),"onMeasure()"  + String.valueOf(((ViewGroup)getChildAt(0)).getChildCount()));

        Log.e(getClass().getSimpleName(),"onMeasure()"  + String.valueOf((ViewGroup)((ViewGroup)getChildAt(0)).getChildAt(0)));
        Log.e(getClass().getSimpleName(),"onMeasure()"  + String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(1)));
        Log.e(getClass().getSimpleName(),"onMeasure()"  + String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(2)));

        Log.e(getClass().getSimpleName(),String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(0))  + ((ViewGroup)getChildAt(0)).getChildAt(0).getMeasuredHeight());
        Log.e(getClass().getSimpleName(),String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(1)) + ((ViewGroup)getChildAt(0)).getChildAt(1).getMeasuredHeight());
        Log.e(getClass().getSimpleName(),String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(2)) + ((ViewGroup)getChildAt(0)).getChildAt(2).getMeasuredHeight());
        Log.e(getClass().getSimpleName(),String.valueOf(getMeasuredHeight()));

        //第一个要点：顶部悬浮效果
        //解决方式：将内容布局的高度设置为NestedScrollView的高度，即滑到顶了，自然就固定在顶部了
        ViewGroup.LayoutParams layoutParams = mContentView.getLayoutParams();
        layoutParams.height = getMeasuredHeight();
        mContentView.setLayoutParams(layoutParams);

        Log.e(getClass().getSimpleName(),"onMeasure()"  + String.valueOf((ViewGroup)((ViewGroup)getChildAt(0)).getChildAt(0)));
        Log.e(getClass().getSimpleName(),"onMeasure()"  + String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(1)));
        Log.e(getClass().getSimpleName(),"onMeasure()"  + String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(2)));

        Log.e(getClass().getSimpleName(),String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(0))  + ((ViewGroup)getChildAt(0)).getChildAt(0).getMeasuredHeight());
        Log.e(getClass().getSimpleName(),String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(1)) + ((ViewGroup)getChildAt(0)).getChildAt(1).getMeasuredHeight());
        Log.e(getClass().getSimpleName(),String.valueOf(((ViewGroup)getChildAt(0)).getChildAt(2)) + ((ViewGroup)getChildAt(0)).getChildAt(2).getMeasuredHeight());
        Log.e(getClass().getSimpleName(),String.valueOf(getMeasuredHeight()));
    }

    /**
     * 嵌套滑动的两个角色：NestedScrollingParent3和NestedScrollingChild3两个接口，是由NestedScrollingChild3触发嵌套滑动，由NestedScrollingParent3触发不算嵌套滑动
     * 小结：子控件触发dispatchNestedPreScroll 时会先调用支持嵌套滚动的 父控件的 onNestedPreScroll 让父控件先滚动，再执行自身的 dispatchNestedScroll 进行滚动
     * 即 onNestedPreScroll 的作用是: 在子View消费滑动事件前，优先响应滑动操作，消费部分或全部滑动距离。
     *
     * @param target    触发嵌套滑动的 view
     * @param dx    表示 view 本次 x 方向的滚动的总距离，单位：像素
     * @param dy    表示 view 本次 y 方向的滚动的总距离，单位：像素
     * @param consumed  数组，输出：表示父布局消费的水平和垂直距离。
     * @param type  触发滑动事件的类型：其值有: ViewCompat. TYPE_TOUCH   ViewCompat. TYPE_NON_TOUCH
     */
    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        //super.onNestedPreScroll(target, dx, dy, consumed, type);
        /*
          第二个要点：先让NestedScrollingParent3滑动到顶部后，NestedScrollingChild3才可以滑动
          解决方法:由于NestedScrollView即实现了NestedScrollingParent3又实现了NestedScrollingChild3，
                  所以super.onNestedPreScroll(target, dx, dy, consumed, type)内部实现又会去调用父控件
                  的onNestedPreScroll方法，就会出现NestedScrollView无法滑动到顶部的想象，所以此处
                  注释掉super.onNestedPreScroll(target, dx, dy, consumed, type)，实现滑动逻辑
         */

        Log.e(getClass().getSimpleName(), "onNestedPreScroll" + String.valueOf(getChildCount()));
        Log.e(getClass().getSimpleName(),"onNestedPreScroll"  + String.valueOf(((ViewGroup)getChildAt(0)).getChildCount()));

        //向上滚动并且滚动的距离小于头部控件的高度，则此时父控件先滚动并记录消费的滚动距离
        boolean hideTop = dy > 0 && (getScrollY() < mHeadViewFirst.getMeasuredHeight() || getScrollY() < mHeadViewSecond.getMeasuredHeight());

        if (hideTop) {
            //滚动到相应的滑动距离
            scrollBy(0, dy);
            //记录父控件消费的滚动记录，防止子控件重复滚动
            consumed[1] = dy;
        }

    }


    /**
     * 要点三：惯性滑动，父控件在滑动完成后，在通知子控件滑动,此时不是嵌套滚动
     * 解决方法:1.记录惯性滑动的速度
     * 2.将速度转化成距离
     * 3.计算子控件应该滑动的距离 = 惯性滑动距离 - 已滑距离
     * 4.将剩余滑动距离转化成速度交给子控件进行惯性滑动
     */
    @Override
    public void fling(int velocityY) {
        super.fling(velocityY);
        //3.1记录惯性滚动的速度
        if (velocityY <= 0) {
            mVelocityY = 0;
        } else {
            mVelocityY = velocityY;
        }
    }

    //递归获取子控件RecyclerView
    private RecyclerView getChildRecyclerView(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof RecyclerView && Objects.requireNonNull(((RecyclerView) view).getLayoutManager()).canScrollVertically()) {
                return (RecyclerView) view;
            } else if (viewGroup.getChildAt(i) instanceof ViewGroup) {
                RecyclerView childRecyclerView = getChildRecyclerView((ViewGroup) viewGroup.getChildAt(i));
                if (childRecyclerView != null && Objects.requireNonNull((childRecyclerView).getLayoutManager()).canScrollVertically()) {
                    return childRecyclerView;
                }
            }
        }
        return null;
    }
}
