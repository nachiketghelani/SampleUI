package com.futurelens.screenui.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.futurelens.screenui.R;
import com.futurelens.screenui.adapters.PMAdapter;
import com.futurelens.screenui.fragments.AdminFragment;
import com.futurelens.screenui.fragments.PMFragment;
import com.futurelens.screenui.fragments.TLFragment;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProjectManagerActivity extends AppCompatActivity {


    @BindView(R.id.tabLayoutManagers)
    TabLayout tabLayoutManagers;
    @BindView(R.id.viewpagerPM)
    ViewPager viewpagerPM;

    private PMAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getWindow().setStatusBarColor(Color.TRANSPARENT);

        setContentView(R.layout.activity_contact_list);
        ButterKnife.bind(this);
        setViewPager();

    }

    @OnClick(R.id.btnAddMember)
    protected void addMember() {
        Intent intentAddMember = new Intent(ProjectManagerActivity.this, AddMemberActivity.class);
        startActivity(intentAddMember);
    }

    private void setViewPager() {

        mViewPagerAdapter = new PMAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFragment(new PMFragment(), "PM(17)");
        mViewPagerAdapter.addFragment(new TLFragment(), "TL(15)");
        mViewPagerAdapter.addFragment(new AdminFragment(), "ADMIN(5)");

        viewpagerPM.setAdapter(mViewPagerAdapter);
        tabLayoutManagers.setupWithViewPager(viewpagerPM);
    }
}
