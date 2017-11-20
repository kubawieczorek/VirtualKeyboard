package com.soft.virtualkeyboard.virtualkeyboard;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Layout;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    private Button informationButton, enterTextButton, listenTextButton, configureWordButton;
    GestureDetector informationGestureDetector, enterTextGestureDetector, listenTextGestureDetector, configureWordGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        informationButton=(Button)findViewById(R.id.button);
        enterTextButton=(Button)findViewById(R.id.button2);
        configureWordButton=(Button)findViewById(R.id.button3);
        listenTextButton=(Button)findViewById(R.id.button4);

        informationGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onDoubleTap(MotionEvent event) {

                textToSpeech.speak("dwa razy", TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak(informationButton.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        enterTextGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {

                textToSpeech.speak("dwa razy", TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak(enterTextButton.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        listenTextGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {

                textToSpeech.speak("dwa razy", TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak(listenTextButton.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        configureWordGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {

                textToSpeech.speak("dwa razy", TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak(configureWordButton.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int i) {
                textToSpeech.setLanguage(new Locale("pl_PL"));
            }
        });

        informationButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return informationGestureDetector.onTouchEvent(motionEvent);
            }
        });

        enterTextButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return enterTextGestureDetector.onTouchEvent(motionEvent);
            }
        });

        configureWordButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return configureWordGestureDetector.onTouchEvent(motionEvent);
            }
        });

        listenTextButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return listenTextGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

}
