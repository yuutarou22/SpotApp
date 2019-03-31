package com.example.yutaroapp.spotapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
  private Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setViews();
  }

  private void setViews() {
    FragmentManager manager = getSupportFragmentManager();
    ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
    FragmentPagerAdapter adapter = new FragmentPagerAdapter(manager);
    viewPager.setAdapter(adapter);
  }
}
