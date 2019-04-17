package com.example.yutaroapp.spotapp;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
    statusButton.setOnClickListener(this);

    ImageButton pointButton = (ImageButton)findViewById(R.id.footer_menu).
            findViewById(R.id.footer_menu_button_point).findViewById(R.id.footer_menu_button_img_button);
    pointButton.setOnClickListener(this);

    ImageButton spoitButton = (ImageButton)findViewById(R.id.footer_menu).
            findViewById(R.id.footer_menu_button_spoit).findViewById(R.id.footer_menu_button_img_button);
    spoitButton.setOnClickListener(this);

    ImageButton settingButton = (ImageButton)findViewById(R.id.footer_menu).
            findViewById(R.id.footer_menu_button_setting).findViewById(R.id.footer_menu_button_img_button);
    settingButton.setOnClickListener(this);
  }

  @Override
  // 共通して、footer_menu_button_img_buttonのIDを送ってる。。。
  // 考えられる対策として、共通化して居るID（footer_menu_button_img_button）を
  // 上書いて固有のIDにする。（他にもっといい方法がありそう）
  public void onClick(View v) {
    if (v != null) {
      Log.d("LOG: ", String.valueOf(v.getId()));
      switch (v.getId()) {
        case R.id.footer_menu_button_status:
          StatusFragment statusFragment = new StatusFragment();
          openFragment(statusFragment);
          break;
        case R.id.footer_menu_button_point:
          PointFragment pointFragment = new PointFragment();
          openFragment(pointFragment);
          break;
//        case R.id.footer_menu_button_img_button: 左のようにすれば引っかかる。
        case R.id.footer_menu_button_spoit:
          SpoitFragment spoitFragment = new SpoitFragment();
          openFragment(spoitFragment);
          break;
        case R.id.footer_menu_button_setting:
          SettingFragment settingFragment = new SettingFragment();
          openFragment(settingFragment);
          break;
      }
    }
  }

  protected void openFragment(Fragment fragment) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    fragmentTransaction.replace(R.id.fragment_area, fragment);
    fragmentTransaction.commit();
  }
}
