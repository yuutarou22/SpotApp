package com.example.yutaroapp.spotapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

  @Override
  public void onStart() {
    super.onStart();

    TextView userName = (TextView)getActivity().findViewById(R.id.status_user_name);
    TextView lankName = (TextView)getActivity().findViewById(R.id.status_lank_name);
    TextView messageText = (TextView)getActivity().findViewById(R.id.status_message_text_area);
    // 本来はDBなどからデータを取得してセットする。
    userName.setText("うぱぁー");
    lankName.setText("都内アドバイザー");
    messageText.setText("うぱうぱうぱぱぱー、うぱぱぱー。");
  }
}
