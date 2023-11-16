package com.mishal.learnbasicurdu;

public class helperClass {

    private final String getUrduTranslation;
    private final String getEnglishTranslation;

    private final int NO_IMAGE_PROVIDED = -1;

    private int images = NO_IMAGE_PROVIDED;
    private int audio;


    public helperClass(String getUrduTranslation, int images , String getEnglishTranslation , int audio) {
        this.getUrduTranslation = getUrduTranslation;
        this.getEnglishTranslation = getEnglishTranslation;
        this.images = images;
        this.audio = audio;
    }

    public helperClass(String getEnglishTranslation  , String getUrduTranslation , int audio) {
        this.getUrduTranslation = getUrduTranslation;
        this.audio = audio;
        this.getEnglishTranslation = getEnglishTranslation;
    }


    public String getGetUrduTranslation() {
        return getUrduTranslation;
    }

    public String getGetEnglishTranslation() {
        return getEnglishTranslation;
    }

    public int getImages() {
        return images;
    }

    public int getAudio() {
        return audio;
    }

    public boolean hasImage() {

        return images != NO_IMAGE_PROVIDED;
    }

}
