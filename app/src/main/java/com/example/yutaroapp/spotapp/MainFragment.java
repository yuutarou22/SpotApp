package com.example.yutaroapp.spotapp;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainFragment extends Fragment {
  private final static String BACKGROUND_COLOR = "background_color";

  public static MainFragment newInstance(@ColorInt int IdRes) {
    MainFragment frag = new MainFragment();
    Bundle b = new Bundle();
    b.putInt(BACKGROUND_COLOR, IdRes);
    frag.setArguments(b);
    return frag;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, null);
    final TextView textView = (TextView) view.findViewById(R.id.text_view);
    Button button = (Button) view.findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        textView.setText( textView.getText() + "押したね？");
      }
    });
    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fragment_main_linearlayout);
    linearLayout.setBackgroundResource(getArguments().getInt(BACKGROUND_COLOR));

    return view;
  }
}