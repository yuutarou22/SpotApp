package com.example.yutaroapp.spotapp;

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

    final boolean[] flg = {true};
    final TextView textView = (TextView)findViewById(R.id.footer_menu).
            findViewById(R.id.footer_menu_button1).findViewById(R.id.footer_menu_button_text);

    ImageButton imageButton01 = (ImageButton)findViewById(R.id.footer_menu).
            findViewById(R.id.footer_menu_button1).findViewById(R.id.footer_menu_button_img_button);
    imageButton01.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (flg[0]) {
          textView.setText("切り替えテスト");
          flg[0] = false;
        } else {
          textView.setText(R.string.app_name);
          flg[0] = true;
        }
      }
    });
  }
}
