package com.uestc.myapplication.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.uestc.myapplication.base.ui.BaseView;

import org.jetbrains.annotations.NotNull;

public abstract class BaseFragment extends Fragment implements BaseView {
    protected boolean mDataInit = false;
    protected View mView;
    protected Context mContext;
    protected abstract View initView();
    public abstract void dataInit();
    public abstract boolean isDataInit();

}
