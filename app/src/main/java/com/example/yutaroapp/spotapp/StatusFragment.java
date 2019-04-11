package com.example.yutaroapp.spotapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StatusFragment extends Fragment {
  public StatusFragment() {
  }

  public static StatusFragment newInstance() {
    // インスタンス作成
    StatusFragment fragment = new StatusFragment();
    // Bundleにパラメータを指定（できる）
    Bundle args = new Bundle();
//    args.putInt("Counter", count);
//    countは引数
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_status, container, false);
  }
}
