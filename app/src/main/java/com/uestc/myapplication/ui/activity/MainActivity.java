package com.uestc.myapplication.ui.activity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.uestc.myapplication.R;
import com.uestc.myapplication.base.activity.BaseActivity;
import com.uestc.myapplication.base.fragment.BaseFragment;
import com.uestc.myapplication.base.presenter.BasePresenter;
import com.uestc.myapplication.model.HomeFriendModel;
import com.uestc.myapplication.presenter.HomeFriendPresenter;
import com.uestc.myapplication.ui.fragment.FindFragment;
import com.uestc.myapplication.ui.fragment.HomeFragment;
import com.uestc.myapplication.ui.fragment.MeFragment;
import com.uestc.myapplication.ui.fragment.MessageFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity{
    private RadioGroup rgMain;
    private RadioButton rbtnHome;
    private RadioButton rbtnFind;
    private RadioButton rbtnMessage;
    private RadioButton rbtnMe;

    private ArrayList<BaseFragment> mBaseFragments;
    private int mPosition;
//    private HomeFriendPresenter mHomeFriendPresenter;

    private final int HOME_POSITION = 0;
    private final int FIND_POSITION = 1;
    private final int MESSAGE_POSITION = 2;
    private final int ME_POSITION = 3;
    private final int HOME_FRAGMENT_COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //去掉系统设置默认标题栏
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);   //设置透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);   //设置透明导航栏
//        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView(){
        rgMain = findViewById(R.id.rg_main);
        rbtnHome = findViewById(R.id.rbtn_home);
        rbtnFind = findViewById(R.id.rbtn_find);
        rbtnMessage = findViewById(R.id.rbtn_message);
        rbtnMe = findViewById(R.id.rbtn_me);

        radioButtonSize();

        mBaseFragments = new ArrayList<BaseFragment>(HOME_FRAGMENT_COUNT);
        mBaseFragments.add(new HomeFragment(this));
        mBaseFragments.add(new FindFragment(this));
        mBaseFragments.add(new MessageFragment(this));
        mBaseFragments.add(new MeFragment(this));

        rgMain.check(R.id.rbtn_home);
        setFragment();

        rgMain.setOnCheckedChangeListener((RadioGroup group, int checkedId)->{
            switch (checkedId){
                default:
                    mPosition = HOME_POSITION;
                    break;
                case R.id.rbtn_home:
                    mPosition = HOME_POSITION;
                    break;
                case R.id.rbtn_find:
                    mPosition = FIND_POSITION;
                    break;
                case R.id.rbtn_message:
                    mPosition = MESSAGE_POSITION;
                    break;
                case R.id.rbtn_me:
                    mPosition = ME_POSITION;
                    break;
            }
            setFragment();
        });

    }

    private void radioButtonSize(){
        //定义底部标签图片大小和位置
        Drawable drawable_home = getResources().getDrawable(R.drawable.rbtn_home_selector);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb 规定这个矩形
        drawable_home.setBounds(0, 0, 65, 65);
        //设置图片在文字的上方
        rbtnHome.setCompoundDrawables(null, drawable_home, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_find = getResources().getDrawable(R.drawable.rbtn_find_selector);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb 规定这个矩形
        drawable_find.setBounds(0, 0, 65, 65);
        //设置图片在文字的上方
        rbtnFind.setCompoundDrawables(null, drawable_find, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_message = getResources().getDrawable(R.drawable.rbtn_message_selector);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb 规定这个矩形
        drawable_message.setBounds(0, 0, 65, 65);
        //设置图片在文字的上方
        rbtnMessage.setCompoundDrawables(null, drawable_message, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_me = getResources().getDrawable(R.drawable.rbtn_me_selector);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb 规定这个矩形
        drawable_me.setBounds(0, 0, 65, 65);
        //设置图片在文字的上方
        rbtnMe.setCompoundDrawables(null, drawable_me, null, null);
    }

    private void setFragment(){
        FragmentManager fragmentManager =  getSupportFragmentManager();  //得到fragmentManager
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fl_main,getBasePager());
        fragmentTransaction.replace(R.id.fl_main,mBaseFragments.get(mPosition));
        fragmentTransaction.commit();
    }

//    public BaseFragment getBasePager() {
//        BaseFragment baseFragment = mBaseFragments.get(mPosition);
//        if(!baseFragment.isDataInit()){
//            HomeFriendModel homeFriendModel = HomeFriendModel.getInstance();
//            BasePresenter basePresenter = null;
//            if(baseFragment instanceof HomeFragment){
//                basePresenter = new HomeFriendPresenter(homeFriendModel, (HomeFragment)baseFragment);
//            }
//            baseFragment.setPresenter(basePresenter);
//        }
//
//        return baseFragment;
//    }

}