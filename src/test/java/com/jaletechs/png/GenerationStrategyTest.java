package com.jaletechs.png;


import com.jaletechs.png.dtos.GenerationResponse;
import com.jaletechs.png.strategies.BruteForceStrategy;
import com.jaletechs.png.strategies.GenerationStrategy;
import com.jaletechs.png.strategies.OptimizedBruteForceStrategy;
import com.jaletechs.png.strategies.SieveOfEratosthenesStrategy;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jaletechs on 2019-05-30.
 */
public class GenerationStrategyTest {
    @Test
    public void testBruteForceStrategy() {
        GenerationStrategy strategy = new BruteForceStrategy();

        GenerationResponse response = strategy.generate(1, 10);
        Assert.assertEquals(4, response.getNumberOfPrimes());
        Assert.assertEquals("2, 3, 5, 7, ", response.getPrimeNumbers());

        response = strategy.generate(1, 100);
        Assert.assertEquals(25, response.getNumberOfPrimes());

        response = strategy.generate(1, 1000);
        Assert.assertEquals(168, response.getNumberOfPrimes());
    }

    @Test
    public void testOptimizedBruteForceStrategy() {
        GenerationStrategy strategy = new OptimizedBruteForceStrategy();

        GenerationResponse response = strategy.generate(1, 10);
        Assert.assertEquals(4, response.getNumberOfPrimes());
        Assert.assertEquals("2, 3, 5, 7, ", response.getPrimeNumbers());

        response = strategy.generate(1, 100);
        Assert.assertEquals(25, response.getNumberOfPrimes());

        response = strategy.generate(1, 1000);
        Assert.assertEquals(168, response.getNumberOfPrimes());
    }

    @Test
    public void testSieveOfEratosthenesStrategy() {
        GenerationStrategy strategy = new SieveOfEratosthenesStrategy();

        GenerationResponse response = strategy.generate(1, 10);
        Assert.assertEquals(4, response.getNumberOfPrimes());
        Assert.assertEquals("2, 3, 5, 7, ", response.getPrimeNumbers());

        response = strategy.generate(1, 100);
        Assert.assertEquals(25, response.getNumberOfPrimes());

        response = strategy.generate(1, 1000);
        Assert.assertEquals(168, response.getNumberOfPrimes());

        //add test for abnormal range
        response = strategy.generate(10, 100);
        Assert.assertEquals(21, response.getNumberOfPrimes());
    }
} 
