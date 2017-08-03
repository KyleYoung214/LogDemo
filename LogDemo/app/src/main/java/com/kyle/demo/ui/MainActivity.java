package com.kyle.demo.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kyle.demo.Contants.NumberCnts;
import com.kyle.demo.R;
import com.kyle.demo.strategy.BubbleSort;
import com.kyle.demo.strategy.InsertSort;
import com.kyle.demo.strategy.SortIntegers;
import com.kyle.demo.utils.LogUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null)
                        .show();
            }
        });

        initViews();
        printLogs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.function1_btn:
                SortIntegers sortIntegers = new SortIntegers();
                sortIntegers.setIntegers(NumberCnts.unsortedIntegers);
                //sortIntegers.setSortMethod(new InsertSort());
                sortIntegers.setSortMethod(new BubbleSort());
                sortIntegers.sortAndPrint();
                break;
            case R.id.function2_btn:
                break;
        }
    }

    private void initViews() {
        findViewById(R.id.function1_btn).setOnClickListener(this);
        findViewById(R.id.function2_btn).setOnClickListener(this);
    }

    private void printLogs() {
        LogUtils.v("this is a verbose message");
        LogUtils.v("verbose", "verbose tag message");

        LogUtils.d("this is a debug message");
        LogUtils.d("debug", "debug tag message");

        LogUtils.i("this is a info message");
        LogUtils.i("info", "info tag message");

        LogUtils.w("this is a warning message");
        LogUtils.w("warning", "warning tag message");

        LogUtils.e("this is a error message");
        LogUtils.e("error", "error tag message");
    }
}
