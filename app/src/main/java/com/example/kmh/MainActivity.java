package com.example.kmh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

import utils.LocaleHelper;

public class MainActivity extends Activity implements View.OnClickListener {

    private String mLanguageCode = "de";

    protected Button _umrechenButton = null;
    protected TextView _titleTextView = null;
    protected EditText _getankteLiterEditText = null;
    protected EditText _eingabeKMEditText = null;
    protected TextView _ergTextView = null;
    protected Button _btnChangeLangView = null;
    protected Button _hilfe_button = null;
    protected Button _resetButton = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _umrechenButton = findViewById(R.id.umrechenButton);
        _titleTextView = findViewById(R.id.TitleTextView);
        _getankteLiterEditText = findViewById(R.id.getankteLiterEditText);
        _eingabeKMEditText = findViewById(R.id.eingabeKMEditText);
        _resetButton = findViewById(R.id.reset_button);

        _btnChangeLangView = findViewById(R.id.btnChangeLangView);
        _hilfe_button = findViewById(R.id.hilfe_button);


        _umrechenButton.setOnClickListener(this);
        _btnChangeLangView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Locale.getDefault().getLanguage() == "de") {
                    mLanguageCode = "en";
                    LocaleHelper.setLocale(MainActivity.this, mLanguageCode);

                } else {
                    LocaleHelper.setLocale(MainActivity.this, mLanguageCode);
                }
                recreate();
            }
        });

        _hilfe_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent2 = new Intent(MainActivity.this, HilfeActivity.class);
            startActivity(intent2);
                }
        }
        );

        _resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }

        });
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Ergebnisactivity.class);
        intent.putExtra("ergebnis", ""+eventUmrechnenButton());
        intent.putExtra("km",(((EditText) findViewById(R.id.eingabeKMEditText)).getText().toString().trim()));
        intent.putExtra("liter",(((EditText) findViewById(R.id.getankteLiterEditText)).getText().toString().trim()));
        startActivity(intent);



    }

    protected void reset()
    {
        _getankteLiterEditText.setText("");
        _eingabeKMEditText.setText("");
    }

    protected double eventUmrechnenButton() {
        double Liter = 0;
        double Km = 0;

        //if(((EditText)findViewById(R.id.eingabeKMEditText)).getText().toString().trim() || ((EditText)findViewById(R.id.getankteLiterEditText)).getText().toString().trim() == )
        //{ }
        try {
            Liter = Double.parseDouble(((EditText) findViewById(R.id.getankteLiterEditText)).getText().toString().trim());
            Km = Double.parseDouble(((EditText) findViewById(R.id.eingabeKMEditText)).getText().toString().trim());
        } catch (NumberFormatException ex) {      }

        double erg = Liter * 100 / Km;
        return erg;

    }
}
