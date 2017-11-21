package com.soft.virtualkeyboard.virtualkeyboard;

import android.content.SharedPreferences;

/**
 * Created by Kuba on 21.11.2017.
 */

public class DataStorage {

    public static void setTextToRead(String val){
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("textToRead", val);
        editor.commit();
    }

    public static void setTextToWrite(String val){
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("textToWrite", val);
        editor.commit();
    }

    public static void setErrorsCoefficient(Float val){
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat("errorsCoefficient", val);
        editor.commit();
    }

    public static void setWrtitingSpeed(Float val){
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat("wrtitingSpeed", val);
        editor.commit();
    }

    public static String getTextToRead(){
        return textToRead;
    }

    public static String getTextToWrite(){
        return textToRead;
    }

    public static float getErrorsCoefficient(){
        return errorsCoefficient;
    }

    public static float getWrtitingSpeed(){
        return wrtitingSpeed;
    }

    private static SharedPreferences settings;

    // Konfigurowalny tekst do wprowadzania za pomoca 9-cio klawiszowej klawiatury
    private static String textToRead;
    // Konfigurowalny tekst do odczytywania za pomoca 9-cio klawiszowej klawiatury
    private static String textToWrite;
    // Wspolczynnik popelnianych bledow przy ostatnim odczytywaniu
    private static float errorsCoefficient;
    // Szybkosc wprowadzania ostatnich danych za pomoca 9-cio klawiszowej klawiatury
    private static float wrtitingSpeed;

    public static void init(SharedPreferences settings){
        textToRead = settings.getString("textToRead", "");
        textToWrite = settings.getString("textToWrite", "");
        errorsCoefficient = settings.getFloat("errorsCoefficient", 0.0f);
        wrtitingSpeed = settings.getFloat("wrtitingSpeed", 0.0f);
    }
}
