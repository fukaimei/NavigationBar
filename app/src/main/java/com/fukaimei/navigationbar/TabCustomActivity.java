package com.fukaimei.navigationbar;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.ViewPagerOnTabSelectedListener;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.fukaimei.navigationbar.adapter.GoodsPagerAdapter;
import com.fukaimei.navigationbar.util.Utils;

public class TabCustomActivity extends AppCompatActivity {
    private final static String TAG = "TabCustomActivity";
    private Toolbar tl_head;
    private ViewPager vp_content;
    private TabLayout tab_title;
    private TextView tv_toolbar1, tv_toolbar2;
    private ArrayList<String> mTitleArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_custom);
        tl_head = (Toolbar) findViewById(R.id.tl_head);
        tab_title = (TabLayout) findViewById(R.id.tab_title);
        vp_content = (ViewPager) findViewById(R.id.vp_content);
        setSupportActionBar(tl_head);
        mTitleArray.add("商品");
        mTitleArray.add("详情");
        initTabLayout();
        initTabViewPager();
    }

    private void initTabLayout() {
        tab_title.addTab(tab_title.newTab().setCustomView(R.layout.item_toolbar1));
        tv_toolbar1 = (TextView) findViewById(R.id.tv_toolbar1);
        tv_toolbar1.setText(mTitleArray.get(0));
        tab_title.addTab(tab_title.newTab().setCustomView(R.layout.item_toolbar2));
        tv_toolbar2 = (TextView) findViewById(R.id.tv_toolbar2);
        tv_toolbar2.setText(mTitleArray.get(1));
        tab_title.setOnTabSelectedListener(new ViewPagerOnTabSelectedListener(vp_content));
    }

    private void initTabViewPager() {
        GoodsPagerAdapter adapter = new GoodsPagerAdapter(
                getSupportFragmentManager(), mTitleArray);
        vp_content.setAdapter(adapter);
        vp_content.addOnPageChangeListener(new SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                tab_title.getTabAt(position).select();
            }
        });
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        // 显示菜单项左侧的图标
        Utils.setOverflowIconVisible(featureId, menu);
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        } else if (id == R.id.menu_refresh) {
            Toast.makeText(this, "当前刷新时间: " + Utils.getNowDateTime("yyyy-MM-dd HH:mm:ss")
                    , Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.menu_about) {
            Toast.makeText(this, "这个是标签布局的演示demo", Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.menu_quit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
