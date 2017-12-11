package com.soft.virtualkeyboard.virtualkeyboard;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ReadTextActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    private Button abcButton, defButton, ghiButton, jklButton, mnoButton, pqrsButton, tuvButton, wxyzButton, spaceButton;
    private GestureDetector abcGestureDetector, defGestureDetector, ghiGestureDetector,
            jklGestureDetector, mnoGestureDetector, pqrsGestureDetector, tuvGestureDetector,
            wxyzGestureDetector, enteredTextButtonGestureDetector, spaceDeleteButtonGestureDetector;
    private String[] abcArray = new String[]{"","A","B","C"}, defArray = new String[]{"","D","E","D"},
            ghiArray = new String[]{"","G","H","I"}, jklArray = new String[]{"","J","K","L"},
            mnoArray = new String[]{"","M","N","O"}, pqrsArray = new String[]{"","P","Q","R","s"},
            tuvArray = new String[]{"","T","U","V"}, wxyzArray = new String[]{"","W","X","Y","Z"};
    private int abcIndex = 0, defIndex, ghiIndex, jklIndex, mnoIndex, pqrsIndex, tuvIndex, wxyzIndex;
    private TextView textToReadView;
    private String textToRead;
    private int CurrentWordIndex = 0;
    private Vibrator v;
    private Date startData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_text);
        abcButton=(Button)findViewById(R.id.abcButton);
        defButton=(Button)findViewById(R.id.defButton);
        ghiButton=(Button)findViewById(R.id.ghiButton);
        jklButton=(Button)findViewById(R.id.jklButton);
        mnoButton=(Button)findViewById(R.id.mnoButton);
        pqrsButton=(Button)findViewById(R.id.pqrsButton);
        tuvButton=(Button)findViewById(R.id.tuvButton);
        wxyzButton=(Button)findViewById(R.id.wxyzButton);
        spaceButton = (Button)findViewById(R.id.spaceButton);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int i) {
                textToSpeech.setLanguage(new Locale("pl_PL"));
            }
        });
        textToRead = DataStorage.getTextToRead();
        textToReadView = (TextView)findViewById(R.id.textToRead);
        textToReadView.setText(textToRead);
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        setAbcButton();
        setDefButton();
        setGhiButton();
        setJklButton();
        setMnoButton();
        setPqrsButton();
        setTuvButton();
        setWxyzButton();
        setTextToRead();
        setSpaceButton();
    }

    private void setTextToRead() {
        enteredTextButtonGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                String text = textToReadView.getText().toString();
                if (text.length() == 0)
                    text = "Brak tekstu do odczytania";

                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak("Tekst do odczytania", TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        textToReadView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return enteredTextButtonGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void checkVibrate(String letter){
        if (CurrentWordIndex == 0) {
            startData = Calendar.getInstance().getTime();
        }
        if(letter.equals(" ")){
            textToSpeech.speak("Spacja", TextToSpeech.QUEUE_FLUSH, null);
        }
        else{
            textToSpeech.speak(letter, TextToSpeech.QUEUE_FLUSH, null);
        }
        if(CurrentWordIndex < textToRead.length() &&
                String.valueOf(textToRead.charAt(CurrentWordIndex)).toUpperCase()
                .equals(letter.toUpperCase())){
            v.vibrate(500);
            CurrentWordIndex++;
            if(CurrentWordIndex == textToRead.length()){
                v.vibrate(2000);
                setAchievements();
            }
        }
    }


    private void setSpaceButton() {
        spaceDeleteButtonGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                checkVibrate(" ");
                return true;
            }
        });

        spaceButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return spaceDeleteButtonGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setAbcButton() {
        abcGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                abcIndex++;
                if (abcIndex > abcArray.length-1) abcIndex = 1;
                checkVibrate(abcArray[abcIndex]);
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
            public boolean onSingleTapConfirmed(MotionEvent e) {
                defIndex++;
                if (defIndex > defArray.length-1) defIndex = 1;
                checkVibrate(defArray[defIndex]);
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
            public boolean onSingleTapConfirmed(MotionEvent e) {
                ghiIndex++;
                if (ghiIndex > ghiArray.length-1) ghiIndex = 1;
                checkVibrate(ghiArray[ghiIndex]);
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
            public boolean onSingleTapConfirmed(MotionEvent e) {
                jklIndex++;
                if (jklIndex > jklArray.length-1) jklIndex = 1;
                checkVibrate(jklArray[jklIndex]);
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
            public boolean onSingleTapConfirmed(MotionEvent e) {
                mnoIndex++;
                if (mnoIndex > mnoArray.length-1) mnoIndex = 1;
                checkVibrate(mnoArray[mnoIndex]);
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
            public boolean onSingleTapConfirmed(MotionEvent e) {
                pqrsIndex++;
                if (pqrsIndex > pqrsArray.length-1) pqrsIndex = 1;
                checkVibrate(pqrsArray[pqrsIndex]);
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
            public boolean onSingleTapConfirmed(MotionEvent e) {
                tuvIndex++;
                if (tuvIndex > tuvArray.length-1) tuvIndex = 1;
                checkVibrate(tuvArray[tuvIndex]);
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
            public boolean onSingleTapConfirmed(MotionEvent e) {
                wxyzIndex++;
                if (wxyzIndex > wxyzArray.length-1) wxyzIndex = 1;
                checkVibrate(wxyzArray[wxyzIndex]);
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

    private void setAchievements(){
        Date currentTime = Calendar.getInstance().getTime();
        float writingSpeed =  (float)((currentTime.getTime() - startData.getTime())/1000);
        DataStorage.setReadingSpeed(writingSpeed);
        textToSpeech.speak("Twój czas pisania to " + writingSpeed + " sekund", TextToSpeech.QUEUE_FLUSH, null);
    }

}
