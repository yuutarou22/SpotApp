package com.example.yutaroapp.spotapp;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    if (savedInstanceState == null) {
      fragmentTransaction.add(R.id.fragment_area, StatusFragment.newInstance());
      fragmentTransaction.commit();
    }

    onCreateView();
  }

  protected void onCreateView() {
    // 処理が冗長なので要検討
    ImageButton statusButton = (ImageButton)findViewById(R.id.footer_menu).
            findViewById(R.id.footer_menu_button_status).findViewById(R.id.footer_menu_button_img_button);
    statusButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        StatusFragment statusFragment = new StatusFragment();
        openFragment(statusFragment);
      }
    });

    ImageButton pointButton = (ImageButton)findViewById(R.id.footer_menu).
            findViewById(R.id.footer_menu_button_point).findViewById(R.id.footer_menu_button_img_button);
    pointButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        PointFragment pointFragment = new PointFragment();
        openFragment(pointFragment);
      }
    });

    ImageButton spoitButton = (ImageButton)findViewById(R.id.footer_menu).
            findViewById(R.id.footer_menu_button_spoit).findViewById(R.id.footer_menu_button_img_button);
    spoitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        SpoitFragment spoitFragment = new SpoitFragment();
        openFragment(spoitFragment);
      }
    });

    ImageButton settingButton = (ImageButton)findViewById(R.id.footer_menu).
            findViewById(R.id.footer_menu_button_setting).findViewById(R.id.footer_menu_button_img_button);
    settingButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        SettingFragment settingFragment = new SettingFragment();
        openFragment(settingFragment);
      }
    });
  }

  protected void openFragment(Fragment fragment) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    fragmentTransaction.replace(R.id.fragment_area, fragment);
    fragmentTransaction.commit();
  }
}
