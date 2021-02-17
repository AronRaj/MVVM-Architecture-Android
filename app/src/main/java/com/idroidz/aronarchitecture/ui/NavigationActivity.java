package com.idroidz.aronarchitecture.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.idroidz.aronarchitecture.R;
import com.idroidz.aronarchitecture.ui.base.BaseActivity;

public class NavigationActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_navigation);
    }

    @Override
    public void initViewModel() {

    }
}
