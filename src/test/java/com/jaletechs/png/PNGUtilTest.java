package com.jaletechs.png;

import com.jaletechs.png.strategies.BruteForceStrategy;
import com.jaletechs.png.strategies.OptimizedBruteForceStrategy;
import com.jaletechs.png.strategies.SieveOfEratosthenesStrategy;
import com.jaletechs.png.types.GenerationStategyType;
import com.jaletechs.png.util.PNGUtil;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jaletechs on 2019-05-29.
 */
public class PNGUtilTest {

    @Test
    public void testIsPrimeNumber() {
        Assert.assertTrue(PNGUtil.isPrime(3));
        Assert.assertTrue(PNGUtil.isPrime(11));
        Assert.assertTrue(PNGUtil.isPrime(101));
        Assert.assertFalse(PNGUtil.isPrime(4));
    }

    @Test
    public void shouldGenerateStrategyGivenValidOption() {
        Assertions.assertThat(GenerationStategyType.getStrategy(1))
                .isEqualTo(GenerationStategyType.BRUTE_FORCE);

        Assertions.assertThat(GenerationStategyType.getStrategy(2))
                .isEqualTo(GenerationStategyType.OPTIMIZED_BRUTE_FORCE);

        Assertions.assertThat(GenerationStategyType.getStrategy(3))
                .isEqualTo(GenerationStategyType.SIEVE_OF_ERATOSTHENES);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionGivenInvalidOption() {
        GenerationStategyType.getStrategy(10);
    }

    @Test
    public void shouldReturnGenerationStrategyGivenType() {
        Assertions.assertThat(PNGUtil.getGenerationStrategy(GenerationStategyType.BRUTE_FORCE))
                .isEqualTo(new BruteForceStrategy());

        Assertions.assertThat(PNGUtil.getGenerationStrategy(GenerationStategyType.OPTIMIZED_BRUTE_FORCE))
                .isEqualTo(new OptimizedBruteForceStrategy());

        Assertions.assertThat(PNGUtil.getGenerationStrategy(GenerationStategyType.SIEVE_OF_ERATOSTHENES))
                .isEqualTo(new SieveOfEratosthenesStrategy());
    }

} 
