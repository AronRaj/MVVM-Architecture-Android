package com.idroidz.aronarchitecture.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.idroidz.aronarchitecture.R;
import com.idroidz.aronarchitecture.ui.base.BaseFragment;
import com.idroidz.aronarchitecture.ui.base.BaseViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomeViewModel> {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public HomeViewModel getViewModel() {
        return null;
    }


}
