package com.fukaimei.navigationbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_toolbar).setOnClickListener(this);
        findViewById(R.id.btn_toolbar_custom).setOnClickListener(this);
        findViewById(R.id.btn_overflow_menu).setOnClickListener(this);
        findViewById(R.id.btn_search_view).setOnClickListener(this);
        findViewById(R.id.btn_tab_layout).setOnClickListener(this);
        findViewById(R.id.btn_tab_custom).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_toolbar) {
            Intent intent = new Intent(this, ToolbarActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_overflow_menu) {
            Intent intent = new Intent(this, OverflowMenuActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_search_view) {
            Intent intent = new Intent(this, SearchViewActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_toolbar_custom) {
            Intent intent = new Intent(this, ToolbarCustomActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_tab_layout) {
            Intent intent = new Intent(this, TabLayoutActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_tab_custom) {
            Intent intent = new Intent(this, TabCustomActivity.class);
            startActivity(intent);
        }
    }

}
