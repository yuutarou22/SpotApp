package com.example.yutaroapp.spotapp;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // コードからFragmentを追加
    MainFragment fragment = new MainFragment();
    /*
    　　Fragmentの追加や削除は、Transactionを利用する。
    　　add, replace, removeといったメソッドを使う。
    　　最後にcommitを使用することで変更を反映する。
    　　引数1:ViewGroupのID、引数2:追加するFragment
    */
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.add(R.id.container, MainFragment.createInstance("fuga", Color.BLUE));
    transaction.add(R.id.container, MainFragment.createInstance("hoge", Color.RED));
    transaction.commit();
  }
}
