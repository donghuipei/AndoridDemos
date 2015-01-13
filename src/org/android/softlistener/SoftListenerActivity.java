package org.android.softlistener;

import org.android.demos.R;
import org.android.widget.SoftListenerView;
import org.android.widget.SoftListenerView.SoftListener;
import org.android.widget.SoftListenerView.SoftState;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SoftListenerActivity extends Activity implements SoftListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_soft_listener);
        SoftListenerView softListenerView = (SoftListenerView) findViewById(R.id.soft_listener_holder_view);
        softListenerView.setSoftListener(this);
    }

    @Override
    public void onSoftChange(SoftState softState, int softHeight) {
        Log.d("AndroidDemos", "SoftState:" + softState + ";softHeight:" + softHeight);
    }
}
