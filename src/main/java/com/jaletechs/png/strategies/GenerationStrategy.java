package com.jaletechs.png.strategies;

import com.jaletechs.png.dtos.GenerationResponse;

/**
 * Created by jaletechs on 2019-05-30.
 *
 *  Core interface which is the base start for every generation
 *  strategy to be implemented on the system.
 */
public interface GenerationStrategy {

    /**
     * provides the implementation for a chosen generation strategy,
     * returning the result in a specific format
     *
     * @param start start of user's range
     * @param end end of user's range
     * @return GenerationResponse an object containing the prime numbers,
     * number of primes generated, and time taken to generate prime numbers.
     */
    GenerationResponse generate(int start, int end);

}
