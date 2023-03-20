package com.example.codenames.Model;

import android.graphics.Color;

public class Word {
    private String content;
    private boolean revealed;
    private int color;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Word(String content, int color, boolean revealed) {
        this.content = content;
        this.color = color;
        this.revealed = revealed;
    }
    public Word(String content, int color){
        this.content = content;
        this.color = color;
        this.revealed = false;
    }
    public Word(){
    }
}
