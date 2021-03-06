package com.antovski.antonio.reminder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;

public class MyNotesActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener,
        MonthFragment.OnFragmentInteractionListener,
        WeekFragment.OnFragmentInteractionListener,
        DayFragment.OnFragmentInteractionListener{

    WeekView mWeekView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);
        listFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuDayView:
                dayFragment();
                return true;
            case R.id.menuListView:
                listFragment();
                return true;
            case R.id.menuMonthView:
                monthFragment();
                return true;
            case R.id.menuWeekView:
                weekFragment();
                return true;
        }
        return false;
    }

    public void listFragment() {
        ListFragment lf = (ListFragment) getSupportFragmentManager().findFragmentByTag("ListFragment");
        if (lf == null) {
            lf = new ListFragment();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentLayout, lf, "ListFragment");
        ft.commit();
    }

    public void monthFragment() {
        MonthFragment mf = (MonthFragment) getSupportFragmentManager().findFragmentByTag("MonthFragment");
        if(mf == null){
            mf = new MonthFragment();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentLayout, mf, "MonthFragment");
        ft.commit();
    }

    public void weekFragment() {
        WeekFragment wf = (WeekFragment) getSupportFragmentManager().findFragmentByTag("WeekFragment");
        if(wf == null){
            wf = new WeekFragment();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentLayout, wf, "WeekFragment");
        ft.commit();
    }

    public void dayFragment() {
        DayFragment df = (DayFragment) getSupportFragmentManager().findFragmentByTag("DayFragment");
        if(df == null){
            df = new DayFragment();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentLayout, df, "DayFragment");
        ft.commit();
    }

    public void mapView(){
        Fragment f = getSupportFragmentManager().findFragmentByTag("map");
        if(f == null){
            f = new Fragment();
        }
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.fragmentLayout, f, "map");
        t.commit();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(MyNotesActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}