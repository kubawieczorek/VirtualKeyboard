package com.soft.virtualkeyboard.virtualkeyboard;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AchievementsActivity extends AppCompatActivity {

    TextView bestWrite, averageWrite, bestRead, averageRead;
    boolean dialogReturnFalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        bestWrite = (TextView) findViewById(R.id.bestWriteText);
        averageWrite = (TextView) findViewById(R.id.averageWriteText);
        bestRead = (TextView) findViewById(R.id.bestReadText);
        averageRead = (TextView) findViewById(R.id.averageReadText);
        setTexts();

        bestWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDialog("najlepszej prędkości wprowadzania tekstu","bestWriteSpeed", v);
            }
        });

        averageWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDialog("średniej prędkości wprowadzania tekstu","averageWriteSpeed", v);
            }
        });

        bestRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDialog("najlepszej prędkości odczytywania tekstu","bestReadSpeed", v);
            }
        });

        averageRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDialog("średniej prędkości odczytywania tekstu","averageReadSpeed", v);
            }
        });
    }

    private void setTexts() {
        bestWrite.setText(String.valueOf(DataStorage.getBestWriteSpeed()));
        averageWrite.setText(String.valueOf(DataStorage.getAverageWriteSpeed()));
        bestRead.setText(String.valueOf(DataStorage.getBestReadSpeed()));
        averageRead.setText(String.valueOf(DataStorage.getAverageReadSpeed()));
    }

    private void callDialog(String message, final String textName, View view) {
        dialogReturnFalue = false;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
        builder1.setMessage("Na pewno chcesz wyzerować wartość " + message);
        builder1.setCancelable(false);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DataStorage.clearValue(textName);
                        setTexts();
                    }
                });
        builder1.setNegativeButton(
                "COFNIJ",
                new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    dialogReturnFalue = false;
                }
        });
        AlertDialog alert11 = builder1.create();
        alert11.show();


    }
}
