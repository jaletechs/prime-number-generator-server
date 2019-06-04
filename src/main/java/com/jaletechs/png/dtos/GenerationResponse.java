package com.jaletechs.png.dtos;

/**
 * Created by jaletechs on 2019-06-02.
 */
public class GenerationResponse {

    private String primeNumbers;
    private int numberOfPrimes;
    private long timeElapsed;

    public GenerationResponse () {}

    public String getPrimeNumbers() {
        return primeNumbers;
    }

    public void setPrimeNumbers(String primeNumbers) {
        this.primeNumbers = primeNumbers;
    }

    public int getNumberOfPrimes() {
        return numberOfPrimes;
    }

    public void setNumberOfPrimes(int numberOfPrimes) {
        this.numberOfPrimes = numberOfPrimes;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
