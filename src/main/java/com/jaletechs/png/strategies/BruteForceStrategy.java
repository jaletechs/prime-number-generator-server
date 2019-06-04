package com.jaletechs.png.strategies;

import com.jaletechs.png.dtos.GenerationResponse;
import com.jaletechs.png.types.GenerationStategyType;
import com.jaletechs.png.util.PNGUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by jaletechs on 2019-05-30.
 *
 * This strategy uses brute force to find the prime numbers in a range provided by the user.
 */
public class BruteForceStrategy implements GenerationStrategy {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final GenerationStategyType type = GenerationStategyType.BRUTE_FORCE;

    @Override
    public GenerationResponse generate(int start, int end) {
        logger.info("***** BRUTE FORCE *****");
        Instant startTime = Instant.now();
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < end; i++) {
            if (PNGUtil.isPrime(i)) {
                builder.append(i).append(", ");
                count++;
            }
        }

        Instant endTime = Instant.now();

        GenerationResponse response = new GenerationResponse();
        response.setPrimeNumbers(builder.toString());
        response.setNumberOfPrimes(count);
        response.setTimeElapsed(Duration.between(startTime, endTime).toMillis());

        return response;
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}
