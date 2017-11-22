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

import java.util.Locale;

public class EnterTextActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    private TextView enteredText;
    private Button backToMenuButton, abcButton, defButton, ghiButton, jklButton, mnoButton, pqrsButton, tuvButton, wxyzButton;
    private GestureDetector backToMenuGestureDetector, abcGestureDetector, defGestureDetector, ghiGestureDetector, jklGestureDetector, mnoGestureDetector, pqrsGestureDetector, tuvGestureDetector, wxyzGestureDetector;
    private String[] abcArray= new String[]{"","A","B","C"}, defArray= new String[]{"","D","E","D"},
            ghiArray= new String[]{"","G","H","I"}, jklArray= new String[]{"","J","K","L"},
            mnoArray= new String[]{"","M","N","O"}, pqrsArray= new String[]{"","P","Q","R","s"},
            tuvArray= new String[]{"","T","U","V"}, wxyzArray= new String[]{"","W","X","Y","Z"};
    private int abcIndex = 0, defIndex, ghiIndex, jklIndex, mnoIndex, pqrsIndex, tuvIndex, wxyzIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertext);
        backToMenuButton=(Button)findViewById(R.id.backButton);
        abcButton=(Button)findViewById(R.id.abcButton);
        enteredText = (TextView)findViewById(R.id.wprowadzonyText);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int i) {
                textToSpeech.setLanguage(new Locale("pl_PL"));
            }
        });

        setBackToMenuButton();
        setAbcButton();
    }

    private void setBackToMenuButton() {
        backToMenuGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak(backToMenuButton.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        backToMenuButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return backToMenuGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setAbcButton() {
        abcGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                String text = enteredText.getText().toString();
                if (text.length() == 0)
                    text += abcArray[abcIndex];
                else
                    text += abcArray[abcIndex].toLowerCase();
                enteredText.setText(text);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                abcIndex++;
                if (abcIndex > 3) abcIndex = 1;
                textToSpeech.speak(abcArray[abcIndex], TextToSpeech.QUEUE_FLUSH, null);
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
        backToMenuGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak(backToMenuButton.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        backToMenuButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return backToMenuGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setGhiButton() {
        backToMenuGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak(backToMenuButton.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        backToMenuButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return backToMenuGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setJklButton() {
        backToMenuGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak(backToMenuButton.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        backToMenuButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return backToMenuGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setMnoButton() {
        backToMenuGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak(backToMenuButton.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        backToMenuButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return backToMenuGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setPqrsButton() {
        backToMenuGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak(backToMenuButton.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        backToMenuButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return backToMenuGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setTuvButton() {
        backToMenuGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak(backToMenuButton.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        backToMenuButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return backToMenuGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private void setWxyzButton() {
        backToMenuGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                textToSpeech.speak(backToMenuButton.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });

        backToMenuButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return backToMenuGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

}
