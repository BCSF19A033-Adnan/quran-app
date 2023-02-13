package com.example.quranapp;



public class Verse {
    private int number;
    private int juz;
    private String text, revelationType, surah_name;
    private String urduTranslation, urduTafseer, englishTranslation, englishTafseer, sindhiTranslation,
            sindhiTafseer, hindiTranslation, hindiTafseer, pushtoTranslation, pushtoTafseer;
    private int numberInSurah;

    public Verse(int num, String ayat, String revType, String surah, int verseNum, int parah, String[] translations)
    {
        number=num;
        text=ayat;
        surah_name = surah;
        revelationType = revType;
        numberInSurah = verseNum;
        juz = parah;
        urduTranslation = translations[0];
        urduTafseer = translations[1];
        englishTranslation=translations[2];
        englishTafseer=translations[3];
        hindiTranslation=translations[4];
        hindiTafseer=translations[5];
        sindhiTranslation=translations[6];
        sindhiTafseer=translations[7];
        pushtoTranslation=translations[8];
        pushtoTafseer=translations[9];
    }
    public int getNumber()
    {
        return number;
    }
    public void setText(String verse)
    {
        text=verse;
    }
    public String getText()
    {
        return  text;
    }

    public String getEnglishTafseer() {
        return englishTafseer;
    }

    public String getEnglishTranslation() {
        return englishTranslation;
    }

    public String getHindiTafseer() {
        return hindiTafseer;
    }

    public String getHindiTranslation() {
        return hindiTranslation;
    }

    public String getPushtoTafseer() {
        return pushtoTafseer;
    }

    public String getPushtoTranslation() {
        return pushtoTranslation;
    }

    public String getSindhiTafseer() {
        return sindhiTafseer;
    }

    public String getSindhiTranslation() {
        return sindhiTranslation;
    }

    public String getUrduTafseer() {
        return urduTafseer;
    }

    public String getUrduTranslation() {
        return urduTranslation;
    }

    public void setEnglishTafseer(String englishTafseer) {
        this.englishTafseer = englishTafseer;
    }

    public void setEnglishTranslation(String englishTranslation) {
        this.englishTranslation = englishTranslation;
    }

    public void setHindiTafseer(String hindiTafseer) {
        this.hindiTafseer = hindiTafseer;
    }

    public void setHindiTranslation(String hindiTranslation) {
        this.hindiTranslation = hindiTranslation;
    }

    public void setPushtoTafseer(String pushtoTafseer) {
        this.pushtoTafseer = pushtoTafseer;
    }

    public void setPushtoTranslation(String pushtoTranslation) {
        this.pushtoTranslation = pushtoTranslation;
    }

    public void setSindhiTafseer(String sindhiTafseer) {
        this.sindhiTafseer = sindhiTafseer;
    }

    public void setSindhiTranslation(String sindhiTranslation) {
        this.sindhiTranslation = sindhiTranslation;
    }

    public void setUrduTafseer(String urduTafseer) {
        this.urduTafseer = urduTafseer;
    }

    public void setUrduTranslation(String urduTranslation) {
        this.urduTranslation = urduTranslation;
    }

    public void setRevelationType(String revelationType) {
        this.revelationType = revelationType;
    }

    public String getRevelationType() {
        return revelationType;
    }

    public String getSurah_name() {
        return surah_name;
    }

    public void setSurah_name(String surah_name) {
        this.surah_name = surah_name;
    }

    public int getNumberInSurah() {
        return numberInSurah;
    }

    public void setNumberInSurah(int numberInSurah) {
        this.numberInSurah = numberInSurah;
    }

    public int getJuz() {
        return juz;
    }

    public void setJuz(int juz) {
        this.juz = juz;
    }
}
