package com.jaletechs.png.controllers;

import com.jaletechs.png.controllers.util.ApiParameters;
import com.jaletechs.png.controllers.util.ApiPaths;
import com.jaletechs.png.dtos.GenerationResponse;
import com.jaletechs.png.entities.UserGenerationLog;
import com.jaletechs.png.entities.security.User;
import com.jaletechs.png.managers.UserManager;
import com.jaletechs.png.repositories.UserGenerationLogRepository;
import com.jaletechs.png.security.JwtTokenUtil;
import com.jaletechs.png.strategies.GenerationStrategy;
import com.jaletechs.png.types.GenerationStategyType;
import com.jaletechs.png.util.PNGUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by jaletechs on 2019-06-01.
 */
@RestController
@RequestMapping(ApiPaths.PRIME_NUMBERS)
public class PrimeNumberGeneratorRestController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserManager userManager;
    @Autowired
    private UserGenerationLogRepository userGenerationLogRepository;

    @GetMapping(ApiPaths.GENERATE)
    public GenerationResponse generatePrimeNumbers(@RequestHeader(ApiParameters.AUTHORIZATION) String authorizationHeader,
                                                   @RequestParam(ApiParameters.START) int start,
                                                   @RequestParam(ApiParameters.END) int end,
                                                   @RequestParam(ApiParameters.STRATEGY) int strategyOption) {

        String email = jwtTokenUtil.getUsernameFromToken(authorizationHeader.substring("Bearer ".length()));
        User user = userManager.getUser(email);

        GenerationStategyType type = GenerationStategyType.getStrategy(strategyOption);

        GenerationStrategy strategy = PNGUtil.getGenerationStrategy(type);

        GenerationResponse response = strategy.generate(start, end);

        logExecution(start, end, user, type, response);

        return response;
    }

    private void logExecution(int start, int end, User user,
                              GenerationStategyType type, GenerationResponse response) {
        UserGenerationLog log = new UserGenerationLog();
        log.setStartOfRange(start);
        log.setEndOfRange(end);
        log.setUser(user);
        log.setStrategy(type);
        log.setTimeElapsed(response.getTimeElapsed());
        log.setExecutionTime(new Date());
        log.setNumberOfPrimes(response.getNumberOfPrimes());

        userGenerationLogRepository.save(log);
    }


} 
