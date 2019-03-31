package com.example.yutaroapp.spotapp;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter{
  public FragmentPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @SuppressLint("ResourceAsColor")
  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return MainFragment.newInstance(android.R.color.holo_blue_bright);
      case 1:
        return MainFragment.newInstance(android.R.color.holo_green_light);
      case 2:
        return MainFragment.newInstance(android.R.color.holo_red_dark);
    }
    return null;
  }

  @Override
  public int getCount() {
    return 3;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return "ページ" + (position + 1);
  }
}
