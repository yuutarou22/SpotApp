package com.example.yutaroapp.spotapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {

  private TextView mTextView;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);

    // レイアウトをViewとして作成する
    return inflater.inflate(R.layout.fragment_main, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // TextViewを紐付け
    mTextView = (TextView) view.findViewById(R.id.text_view01);

    // Buttonタップ時の処理
    view.findViewById(R.id.button01).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mTextView.setText(mTextView.getText() + "PUSHしたな？");
      }
    });
  }
}
