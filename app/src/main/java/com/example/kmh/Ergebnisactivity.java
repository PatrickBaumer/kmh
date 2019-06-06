package com.example.kmh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

public class Ergebnisactivity extends Activity implements View.OnClickListener {
    protected Button _zurueck = null;
    protected TextView _ergTextView2 = null;
    protected TextView _eingabe_KM2 = null;
    protected TextView _eingabe_L2 = null;


    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergebnisactivity);

        _zurueck = findViewById(R.id.zurueck);
        _ergTextView2 = findViewById(R.id.ergTextView2);
        _eingabe_KM2 = findViewById(R.id.eingeg_KM);
        _eingabe_L2 = findViewById(R.id.eingeg_L);
        _zurueck.setOnClickListener(this);
        Intent intent = getIntent();
        _ergTextView2.setText("der verbrauch"+intent.getStringExtra("ergebnis"));
        _eingabe_L2.setText(intent.getStringExtra("liter"));
        _eingabe_KM2.setText(intent.getStringExtra("km"));


    }

}
