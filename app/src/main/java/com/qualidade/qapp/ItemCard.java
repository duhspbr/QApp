package com.qualidade.qapp;

public class ItemCard {
    private String mtext1;
    private String mtext2;
    private String mtext3;
    private int mColor;

    public ItemCard (String text1, String text2, String text3, int color) {
        mtext1 = text1;
        mtext2 = text2;
        mtext3 = text3;
        mColor = color;
    }

    public String getMtext1() {
        return mtext1;
    }

    public String getMtext2() {
        return mtext2;
    }

    public String getMtext3() {
        return mtext3;
    }

    public int getMColor() { return mColor; }

    public void changeColor(int color) { mColor = color; }
}
