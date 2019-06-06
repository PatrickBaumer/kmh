package com.example.kmh;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HilfeActivity extends Activity implements View.OnClickListener{
    protected Button _zurueck = null;

    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilfe);
        _zurueck = findViewById(R.id.zurueck);
        _zurueck.setOnClickListener(this);
    }
}
