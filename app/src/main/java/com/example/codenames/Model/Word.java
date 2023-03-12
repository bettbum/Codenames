package com.example.codenames.Model;

public class Word {
    private String content;
    private boolean revealed;

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

    public Word(String content, boolean revealed) {
        this.content = content;
        this.revealed = revealed;
    }
}
