package com.example.codenames.Model;

public class GuessWord {
    private String guessWord;
    private int numberOfGuesses;

    public String getGuessWord() {
        return guessWord;
    }

    public void setGuessWord(String guessWord) {
        this.guessWord = guessWord;
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public void setNumberOfGuesses(int numberOfGuesses) {
        this.numberOfGuesses = numberOfGuesses;
    }

    public GuessWord(String guessWord, int numberOfGuesses) {
        this.guessWord = guessWord;
        this.numberOfGuesses = numberOfGuesses;
    }
}
