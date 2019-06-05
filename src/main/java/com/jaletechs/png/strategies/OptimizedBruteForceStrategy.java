package com.jaletechs.png.strategies;

import com.jaletechs.png.dtos.GenerationResponse;
import com.jaletechs.png.types.GenerationStategyType;
import com.jaletechs.png.util.PNGUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jaletechs on 2019-05-31.
 *
 * This uses Brute Force to find the prime numbers within a range of values
 * input by the user. The major optimization is the use of the Executor Service
 * to take advantage of the presence of multiple cores to the do work.
 */
public class OptimizedBruteForceStrategy implements GenerationStrategy {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final GenerationStategyType TYPE = GenerationStategyType.OPTIMIZED_BRUTE_FORCE;

    @Override
    public GenerationResponse generate(int start, int end) {

        logger.info("***** OPTIMIZED BRUTE FORCE STRATEGY *****");
        Instant startTime = Instant.now();

        ExecutorService executor = Executors.newCachedThreadPool();
        final StringBuffer buffer = new StringBuffer();

        List<int []> ranges = PNGUtil.partitions(start, end, 1000);

        List<Callable<Integer>> tasks = new ArrayList<>();
        int primeCount = 0;

        ranges.forEach(range -> {
            Callable<Integer> task = () -> {
                int count = 0;
                for (int i = range[0]; i <= range[1]; i++) {
                    if (PNGUtil.optimizedIsPrime(i)) {
                        buffer.append(i).append(", ");
                        count++;
                    }
                }
                return count;
            };
            tasks.add(task);
        });

        try {
            final List<Future<Integer>> futures = executor.invokeAll(tasks);
            primeCount = futures.stream().map(f -> {
                try {
                    return f.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                return 0;
            }).mapToInt(Integer::intValue).sum();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant endTime = Instant.now();

        GenerationResponse response = new GenerationResponse();
        response.setTimeElapsed(Duration.between(startTime, endTime).toMillis());
        response.setPrimeNumbers(buffer.toString());
        response.setNumberOfPrimes(primeCount);
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
