package com.qualidade.qapp.ui.psc;

import android.view.View;

public class ItemCard {
    private final String mtext1;
    private final String mtext2;
    private final String mtext3;
    private int mColor;
    private String mStatus;
    private String colorLabel;
    private int mView;

    public ItemCard (String text1, String text2, String text3, String status, int color, int view) {
        mtext1 = text1;
        mtext2 = text2;
        mtext3 = text3;
        mColor = color;
        mView = view;
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

    public int getColor() { return mColor; }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getStatus() { return mStatus; }

    public int getStatusRelative() {
        if (mView == View.GONE) {
            mView = View.VISIBLE;
            return mView;
        }
        else {
            mView = View.GONE;
            return mView;
        }
    }

    public void setStatusRelative(int visible) { mView = visible; }

    public void setPanelStatus(String ok) {
    }

    public void setColor(int parseColor) { mColor = parseColor; }
}
