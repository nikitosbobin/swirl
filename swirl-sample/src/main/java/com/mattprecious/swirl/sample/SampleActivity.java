package com.mattprecious.swirl.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.mattprecious.swirl.SwirlView;

public class SampleActivity extends Activity
    implements RadioGroup.OnCheckedChangeListener {
  @Bind(R.id.swirl) SwirlView swirlView;
  @Bind(R.id.state) RadioGroup stateView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    ButterKnife.bind(this);

    stateView.setOnCheckedChangeListener(this);
  }

  @Override public void onCheckedChanged(RadioGroup group, int checkedId) {
    switch (checkedId) {
      case R.id.off:
        swirlView.setState(SwirlView.State.OFF);
        break;
      case R.id.on:
        swirlView.setState(SwirlView.State.ON);
        break;
      case R.id.error:
        swirlView.setState(SwirlView.State.ERROR);
        break;
      default:
        throw new IllegalArgumentException("Unexpected checkedId: " + checkedId);
    }
  }
}
