package com.soft.virtualkeyboard.virtualkeyboard;

import android.content.SharedPreferences;

/**
 * Created by Kuba on 21.11.2017.
 */

public class DataStorage {

    public static boolean setTextToRead(String val){
        try {
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("textToRead", val);
            editor.commit();
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public static boolean setTextToWrite(String val){
        try {
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("textToWrite", val);
            editor.commit();
            return true;
        }catch(Exception ex){
            return false;
        }
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
        checkWriteSpeed(val);
    }

    public static void setReadingSpeed(Float val){
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat("readingSpeed", val);
        editor.commit();
        checkReadSpeed(val);
    }

    // Konfigurowalny tekst do odczytywania za pomoca 9-cio klawiszowej klawiatury
    public static String getTextToRead(){
        return settings.getString("textToRead", "");
    }

    // Konfigurowalny tekst do wprowadzania za pomoca 9-cio klawiszowej klawiatury
    public static String getTextToWrite(){
        return settings.getString("textToWrite", "");
    }

    // Wspolczynnik popelnianych bledow przy ostatnim odczytywaniu
    public static float getErrorsCoefficient(){
        return settings.getFloat("errorsCoefficient", 0.0f);
    }

    // Szybkosc wprowadzania ostatnich danych za pomoca 9-cio klawiszowej klawiatury
    public static float getWrtitingSpeed(){
        return settings.getFloat("wrtitingSpeed", 0.0f);
    }

    // Najlepsza szybkosc wprowadzania danych za pomoca 9-cio klawiszowej klawiatury
    public static float getBestWriteSpeed(){
        return settings.getFloat("bestWriteSpeed", 0.0f);
    }

    // Średnia szybkosc wprowadzania danych za pomoca 9-cio klawiszowej klawiatury
    public static float getAverageWriteSpeed(){
        return settings.getFloat("averageWriteSpeed", 0.0f);
    }

    // Najlepsza szybkosc odczytywania danych za pomoca 9-cio klawiszowej klawiatury
    public static float getBestReadSpeed(){
        return settings.getFloat("bestReadSpeed", 0.0f);
    }

    // Średnia szybkosc odczytywania danych za pomoca 9-cio klawiszowej klawiatury
    public static float getAverageReadSpeed(){
        return settings.getFloat("averageReadSpeed", 0.0f);
    }

    private static SharedPreferences settings;

    public static void init(SharedPreferences _settings){
        settings = _settings;
    }

    public static void clearValue(String textName) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(textName, 0);
        editor.commit();
    }

    private static void checkWriteSpeed(Float speed) {
        Float bestSpeed = getBestWriteSpeed(), averageSpeed = getAverageWriteSpeed();
        SharedPreferences.Editor editor = settings.edit();
        if ((bestSpeed > speed) || (bestSpeed == 0)){
            editor.putFloat("bestWriteSpeed", speed);
        }

        editor.putFloat("averageWriteSpeed", (averageSpeed + speed)/2);
        editor.commit();
    }

    private static void checkReadSpeed(Float speed) {
        Float bestSpeed = getBestReadSpeed(), averageSpeed = getAverageReadSpeed();
        SharedPreferences.Editor editor = settings.edit();
        if ((bestSpeed > speed) || (bestSpeed == 0)){
            editor.putFloat("bestReadSpeed", speed);
        }

        editor.putFloat("averageReadSpeed", (averageSpeed + speed)/2);
        editor.commit();
    }
}
