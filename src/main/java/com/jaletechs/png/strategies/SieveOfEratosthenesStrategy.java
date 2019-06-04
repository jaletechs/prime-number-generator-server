package com.jaletechs.png.strategies;


import com.jaletechs.png.dtos.GenerationResponse;
import com.jaletechs.png.types.GenerationStategyType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Created by jaletechs on 2019-05-30.
 *
 * This strategy is based on the Sieve of Eratosthenes algorithm for
 * finding all prime numbers from zero up to a given range.
 * The algorithm is estimated to take O(N log (log N))
 * time to find prime numbers smaller than N.
 */
public class SieveOfEratosthenesStrategy implements GenerationStrategy {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final GenerationStategyType TYPE = GenerationStategyType.SIEVE_OF_ERATOSTHENES;

    @Override
    public GenerationResponse generate(int start, int end) {
        logger.info("***** SIEVE OF ERATOSTHENES *****");

        Instant startTime = Instant.now();
        int count = 0;
        StringBuilder builder = new StringBuilder();

        boolean [] primePositions = new boolean [end];
        Arrays.fill(primePositions, true);

        for (int i = start; i * i < end; i++) {
            if (i <= 1) {
                primePositions[i] = false;
                continue;
            }

            if (primePositions[i]) {
                for (int j = i * i; j < end; j+=i) {
                    primePositions [j] = false;
                }
            }
        }

        for (int i = start; i < end; i++) {
            if (primePositions[i]) {
                builder.append(i + ", ");
                count++;
            }
        }

        Instant endTime = Instant.now();

        GenerationResponse response = new GenerationResponse();
        response.setNumberOfPrimes(count);
        response.setPrimeNumbers(builder.toString());
        response.setTimeElapsed(Duration.between(startTime, endTime).toMillis());

        return response;
    }

    @Override
    public int hashCode() {
        return TYPE.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}
