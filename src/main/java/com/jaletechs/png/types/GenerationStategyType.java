package com.jaletechs.png.types;

import com.jaletechs.png.exceptions.GenerationStrategyNotFoundException;

/**
 * Created by jaletechs on 2019-06-01.
 */
public enum GenerationStategyType {

    BRUTE_FORCE (1),
    OPTIMIZED_BRUTE_FORCE (2),
    SIEVE_OF_ERATOSTHENES (3);

    GenerationStategyType(int index) {
        this.index = index;
    }

    private int index;

    public static GenerationStategyType getStrategy(int index) {

        if (index == 1) {
            return BRUTE_FORCE;
        } else if (index == 2) {
            return OPTIMIZED_BRUTE_FORCE;
        } else if (index == 3) {
            return SIEVE_OF_ERATOSTHENES;
        } else {
            throw new GenerationStrategyNotFoundException(
                    "No Generation strategy exists for option: " + index);
        }
    }
}
