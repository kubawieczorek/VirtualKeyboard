package com.soft.virtualkeyboard.virtualkeyboard;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfigurationActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        final Button button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editTextWriteConf = (EditText) findViewById(R.id.editText3);
                EditText editTextReadConf = (EditText) findViewById(R.id.editText4);

                boolean ret1 = false;
                boolean ret2 = false;

                // Zapisywanie konfiguracji
                ret1 = DataStorage.setTextToRead(editTextReadConf.getText().toString());
                ret2 = DataStorage.setTextToWrite(editTextWriteConf.getText().toString());

                //Przygotowanie wiadomosci o powodzeniu zapisu
                String message = "";
                if(ret1&&ret2){
                    message ="Konfiguracja została zapisana";
                }
                else{
                    message ="Błąd podczas zapisywania konfiguracji";
                }

                AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                builder1.setMessage(message);
                builder1.setCancelable(false);

                builder1.setNeutralButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
    }

    @Override
    protected void onStart() {

        EditText editTextWriteConf = (EditText) findViewById(R.id.editText3);
        EditText editTextReadConf = (EditText) findViewById(R.id.editText4);

        //Odczytywanie obecnej konfiguracji
        editTextWriteConf.setText(DataStorage.getTextToWrite());
        editTextReadConf.setText(DataStorage.getTextToRead());
        super.onStart();
    }
}
