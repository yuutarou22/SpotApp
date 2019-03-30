package com.example.yutaroapp.spotapp;

import android.graphics.Color;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {
  /* Fragmentの値渡し
  　　MainFragmentに値を受け取るための処理を書く。
  　　値の受け渡しには、BundleというKeyPairで値を持つ事のできるクラスを使用する。
  　　1, Bundleのインタンスを作成する。
  　　2, 値をKeyPairの形でputして追加していく。
  　　3, FragmentにsetArgumentという形でセットすることで
  　　　　フラグメントがBundleの値を取得できるようになる。
  */

  // クラス内で参照するため、privateにしておく。
  private final static String KEY_NAME = "key_name";
  private final static String KEY_BACKGROUND = "key_background_color";

  // onCreateで受け取るための変数
  private String mName = "";
  private @ColorInt int mBackgroundColor = Color.TRANSPARENT;

  private TextView mTextView;

  // このメソッドからFragmentを強制的に作成する。
  // createInstanceメソッドを使用することで、
  // そのクラスを作成する際にどのような値が必要になるか制約を設けることができる
  @CheckResult
  public static MainFragment createInstance(String name, @ColorInt int color) {
    MainFragment fragment = new MainFragment();
    // Fragmentに渡す値はBundleでやり取りする。
    Bundle args = new Bundle();
    // Key/Pairで値をセット
    args.putString(KEY_NAME, name);
    args.putInt(KEY_BACKGROUND, color);
    // Fragmentに値をセット
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);

    // レイアウトをViewとして作成する
    return inflater.inflate(R.layout.fragment_main, container, false);
  }

  @Override
  public void onCreate(Bundle saveInstanceState) {
    super.onCreate(saveInstanceState);
    // Bundleを受け取る処理はonCreate内で実行する。
    Bundle args = getArguments();
    // Bundleがセットされていなかった時はnullなのでNullチェックする
    if (args != null) {
      mName = args.getString(KEY_NAME);
      mBackgroundColor = args.getInt(KEY_BACKGROUND, Color.TRANSPARENT);
    }
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

    view.setBackgroundColor(mBackgroundColor);
    mTextView.setText(mName);
  }
}
