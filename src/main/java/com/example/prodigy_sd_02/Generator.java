package com.example.prodigy_sd_02;

import java.util.Random;

public class Generator {
    int generatedValue;
    int attempts;
    int range;

    private void setGeneratedValue(int range) {
        this.range = range;
        Random rand = new Random();
        this.generatedValue = rand.nextInt(range + 1);
    }

    public int getAttempts() {
        return attempts;
    }

    public String checkValue(int inputValue) {
        this.attempts++;
        float differenceRatio = (inputValue - generatedValue) / (float) range;
        if (differenceRatio > 0.5)
            return "Too high";
        else if (differenceRatio < -0.5)
            return "Too low";
        else if (differenceRatio > 0)
            return "High";
        else if (differenceRatio < 0)
            return "Low";
        else
            return "Correct";
    }

    public void start(int range) {
        setGeneratedValue(range);
        this.attempts = 0;
    }

}
