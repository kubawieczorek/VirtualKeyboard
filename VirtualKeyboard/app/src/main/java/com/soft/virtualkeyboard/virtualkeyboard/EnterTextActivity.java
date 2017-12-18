package com.soft.virtualkeyboard.virtualkeyboard;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class EnterTextActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    private Button abcButton, defButton, ghiButton, jklButton, mnoButton, pqrsButton, tuvButton, wxyzButton, spaceDeleteButton;
    private GestureDetector abcGestureDetector, defGestureDetector, ghiGestureDetector,
            jklGestureDetector, mnoGestureDetector, pqrsGestureDetector, tuvGestureDetector,
            wxyzGestureDetector, enteredTextButtonGestureDetector, spaceDeleteButtonGestureDetector;
    private String[] abcArray = new String[]{"","A","B","C"}, defArray = new String[]{"","D","E","F"},
            ghiArray = new String[]{"","G","H","I"}, jklArray = new String[]{"","J","K","L"},
            mnoArray = new String[]{"","M","N","O"}, pqrsArray = new String[]{"","P","Q","R","S"},
            tuvArray = new String[]{"","T","U","V"}, wxyzArray = new String[]{"","W","X","Y","Z"},
            spaceDeleteArray = new String[]{"","Spacja","Usuń"};
    private int abcIndex = 0, defIndex, ghiIndex, jklIndex, mnoIndex, pqrsIndex, tuvIndex, wxyzIndex, spaceDeleteIndex;
    private TextView enteredText;
    private Date startData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertext);
        abcButton=(Button)findViewById(R.id.abcButton);
        defButton=(Button)findViewById(R.id.defButton);
        ghiButton=(Button)findViewById(R.id.ghiButton);
        jklButton=(Button)findViewById(R.id.jklButton);
        mnoButton=(Button)findViewById(R.id.mnoButton);
        pqrsButton=(Button)findViewById(R.id.pqrsButton);
        tuvButton=(Button)findViewById(R.id.tuvButton);
        wxyzButton=(Button)findViewById(R.id.wxyzButton);
        spaceDeleteButton = (Button)findViewById(R.id.spaceDeleteButton);
        enteredText = (TextView)findViewById(R.id.enteredText);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int i) {
                textToSpeech.setLanguage(new Locale("pl_PL"));
            }
        });
        setAbcButton();
        setDefButton();
        setGhiButton();
        setJklButton();
        setMnoButton();
        setPqrsButton();
        setTuvButton();
        setWxyzButton();
        setEnteredText();
        setSpaceDeleteButton();
    }

    private void setEnteredText() {
        enteredTextButtonGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                String text = enteredText.getText().toString();
                if (text.length() == 0)
                    text = "Brak wprowadzonego tekstu";

                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak("Wprowadzony tekst", TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        enteredText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return enteredTextButtonGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setSpaceDeleteButton() {
        spaceDeleteButtonGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                String text = enteredText.getText().toString();
                if (text.length() != 0) {
                    if (spaceDeleteArray[spaceDeleteIndex].matches("Spacja"))
                        text += " ";
                    else
                        text = text.substring(0, text.length()-1);
                }
                enteredText.setText(text);
                resetIndexes("");
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                spaceDeleteIndex++;
                if (spaceDeleteIndex > spaceDeleteArray.length-1) spaceDeleteIndex = 1;
                textToSpeech.speak(spaceDeleteArray[spaceDeleteIndex], TextToSpeech.QUEUE_FLUSH, null);
                resetIndexes(" ");
                return true;
            }
        });

        spaceDeleteButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return spaceDeleteButtonGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setAbcButton() {
        abcGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                String text = enteredText.getText().toString();
                if (text.length() == 0){
                    startData = Calendar.getInstance().getTime();
                    text += abcArray[abcIndex];
                }
                else {
                    text += abcArray[abcIndex].toLowerCase();
                }
                enteredText.setText(text);
                checkText();
                resetIndexes("");
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                abcIndex++;
                if (abcIndex > abcArray.length-1) abcIndex = 1;
                textToSpeech.speak(abcArray[abcIndex], TextToSpeech.QUEUE_FLUSH, null);
                resetIndexes("abc");
                return true;
            }
        });

        abcButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return abcGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setDefButton() {
        defGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                String text = enteredText.getText().toString();
                if (text.length() == 0){
                    startData = Calendar.getInstance().getTime();
                    text += defArray[defIndex];
                }
                else {
                    text += defArray[defIndex].toLowerCase();
                }
                enteredText.setText(text);
                checkText();
                resetIndexes("");
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                defIndex++;
                if (defIndex > defArray.length-1) defIndex = 1;
                textToSpeech.speak(defArray[defIndex], TextToSpeech.QUEUE_FLUSH, null);
                resetIndexes("def");
                return true;
            }
        });

        defButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return defGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setGhiButton() {
        ghiGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                String text = enteredText.getText().toString();
                if (text.length() == 0){
                    startData = Calendar.getInstance().getTime();
                    text += ghiArray[ghiIndex];
                }
                else {
                    text += ghiArray[ghiIndex].toLowerCase();
                }
                enteredText.setText(text);
                checkText();
                resetIndexes("ghi");
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                ghiIndex++;
                if (ghiIndex > ghiArray.length-1) ghiIndex = 1;
                textToSpeech.speak(ghiArray[ghiIndex], TextToSpeech.QUEUE_FLUSH, null);
                resetIndexes("");
                return true;
            }
        });

        ghiButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return ghiGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setJklButton() {
        jklGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                String text = enteredText.getText().toString();
                if (text.length() == 0){
                    startData = Calendar.getInstance().getTime();
                    text += jklArray[jklIndex];
                }
                else {
                    text += jklArray[jklIndex].toLowerCase();
                }
                enteredText.setText(text);
                checkText();
                resetIndexes("");
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                jklIndex++;
                if (jklIndex > jklArray.length-1) jklIndex = 1;
                textToSpeech.speak(jklArray[jklIndex], TextToSpeech.QUEUE_FLUSH, null);
                resetIndexes("jkl");
                return true;
            }
        });

        jklButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return jklGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setMnoButton() {
        mnoGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                String text = enteredText.getText().toString();
                if (text.length() == 0){
                    startData = Calendar.getInstance().getTime();
                    text += mnoArray[mnoIndex];
                }
                else {
                    text += mnoArray[mnoIndex].toLowerCase();
                }
                enteredText.setText(text);
                checkText();
                resetIndexes("");
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                mnoIndex++;
                if (mnoIndex > mnoArray.length-1) mnoIndex = 1;
                textToSpeech.speak(mnoArray[mnoIndex], TextToSpeech.QUEUE_FLUSH, null);
                resetIndexes("mno");
                return true;
            }
        });

        mnoButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mnoGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setPqrsButton() {
        pqrsGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                String text = enteredText.getText().toString();
                if (text.length() == 0){
                    startData = Calendar.getInstance().getTime();
                    text += pqrsArray[pqrsIndex];
                }
                else {
                    text += pqrsArray[pqrsIndex].toLowerCase();
                }
                enteredText.setText(text);
                checkText();
                resetIndexes("");
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                pqrsIndex++;
                if (pqrsIndex > pqrsArray.length-1) pqrsIndex = 1;
                textToSpeech.speak(pqrsArray[pqrsIndex], TextToSpeech.QUEUE_FLUSH, null);
                resetIndexes("pqrs");
                return true;
            }
        });

        pqrsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return pqrsGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setTuvButton() {
        tuvGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                String text = enteredText.getText().toString();
                if (text.length() == 0){
                    startData = Calendar.getInstance().getTime();
                    text += tuvArray[tuvIndex];
                }
                else {
                    text += tuvArray[tuvIndex].toLowerCase();
                }
                enteredText.setText(text);
                checkText();
                resetIndexes("");
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                tuvIndex++;
                if (tuvIndex > tuvArray.length-1) tuvIndex = 1;
                textToSpeech.speak(tuvArray[tuvIndex], TextToSpeech.QUEUE_FLUSH, null);
                resetIndexes("tuv");
                return true;
            }
        });

        tuvButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return tuvGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setWxyzButton() {
        wxyzGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                String text = enteredText.getText().toString();
                if (text.length() == 0){
                    startData = Calendar.getInstance().getTime();
                    text += wxyzArray[wxyzIndex];
                }
                else{
                    text += wxyzArray[wxyzIndex].toLowerCase();
                }
                enteredText.setText(text);
                checkText();
                resetIndexes("");
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                wxyzIndex++;
                if (wxyzIndex > wxyzArray.length-1) wxyzIndex = 1;
                textToSpeech.speak(wxyzArray[wxyzIndex], TextToSpeech.QUEUE_FLUSH, null);
                resetIndexes("wxyz");
                return true;
            }
        });

        wxyzButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return wxyzGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void checkText(){
        if (DataStorage.getTextToWrite().matches(enteredText.getText().toString())) {
            Date currentTime = Calendar.getInstance().getTime();
            DataStorage.setWrtitingSpeed((float)((currentTime.getTime() - startData.getTime())/1000));
            textToSpeech.speak("Twój czas pisania to " + DataStorage.getWrtitingSpeed() + " sekund", TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    private void resetIndexes(String letters){
        if (!letters.matches("abc"))
            abcIndex = 0;
        if (!letters.matches("def"))
            defIndex = 0;
        if (!letters.matches("ghi"))
            ghiIndex = 0;
        if (!letters.matches("jkl"))
            jklIndex = 0;
        if (!letters.matches("mno"))
            mnoIndex = 0;
        if (!letters.matches("pqrs"))
            pqrsIndex = 0;
        if (!letters.matches("tuv"))
            tuvIndex = 0;
        if (!letters.matches("wxyz"))
            wxyzIndex = 0;
        if (!letters.matches(" "))
            spaceDeleteIndex = 0;
    }
}
