package com.example.kmh;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import utils.LocaleHelper;

public class MainActivity extends Activity implements View.OnClickListener {

    private String mLanguageCode = "en";

    protected Button _umrechenButton =null;
    protected TextView _titleTextView = null;
    protected EditText _getankteLiterEditText = null;
    protected EditText _eingabeKMEditText = null;
    protected TextView _ergTextView = null;
    protected Button _btnChangeLangView = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _umrechenButton = findViewById(R.id.umrechenButton);
        _titleTextView = findViewById(R.id.TitleTextView);
        _getankteLiterEditText = findViewById(R.id.getankteLiterEditText);
        _eingabeKMEditText = findViewById(R.id.eingabeKMEditText);
        _ergTextView = findViewById(R.id.ergTextView);
        _btnChangeLangView = findViewById(R.id.btnChangeLangView);

        _btnChangeLangView.setOnClickListener(this);
        _umrechenButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        eventUmrechnenButton();
        //chnLang();


    }

    protected void chnLang(){

        LocaleHelper.setLocale(MainActivity.this, mLanguageCode);
    }
    protected void eventUmrechnenButton(){
        double Liter = 0;
        double Km = 0;

        try {
            Liter = Double.parseDouble(((EditText)findViewById(R.id.getankteLiterEditText)).getText().toString().trim());
            Km = Double.parseDouble(((EditText)findViewById(R.id.eingabeKMEditText)).getText().toString().trim());


        }catch (NumberFormatException ex){         }

        double erg =  Liter*100/Km;
        _ergTextView.setText(""+ erg);



    }
}
