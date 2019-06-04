package com.jaletechs.png;

import com.jaletechs.png.dtos.GenerationResponse;
import com.jaletechs.png.repositories.UserGenerationLogRepository;
import com.jaletechs.png.security.JwtAuthenticationRequest;
import com.jaletechs.png.security.JwtTokenUtil;
import com.jaletechs.png.security.service.JwtAuthenticationResponse;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jaletechs on 2019-06-03.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PrimeNumberGeneratorRestControllerTest {

    @Autowired
    private UserGenerationLogRepository userGenerationLogRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private RestTemplate restTemplate = new RestTemplate();
    @Value("${local.server.port}")
    private int serverPort;


    @Before
    public void setUp() {
        userGenerationLogRepository.deleteAll();
    }

    @Test
    public void testGetUsernameFromValidToken() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE2Mj" +
                "AwNzkxODEsImlhdCI6MTU1OTU5OTE4MX0.UR9f5bLTFaIKTrNh678GCKX4d1brep6pRq7HmXePwf" +
                "Ht_z2fsEbXq1Zsb0y0C7IXsSaPF7F9qkuRNqWXyR59PA";

        String username = jwtTokenUtil.getUsernameFromToken(token);

        Assertions.assertThat(username).isEqualTo("admin@gmail.com");
    }

    @Test
    public void testAuthenticationWithCorrectCredentials () {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        JwtAuthenticationRequest request = new JwtAuthenticationRequest();
        request.setPassword("12345678");
        request.setUsername("admin@gmail.com");
        HttpEntity<JwtAuthenticationRequest> loginRequest = new HttpEntity<>(request, headers);
        HttpStatus status = restTemplate.exchange(
                "http://localhost:" + serverPort + "/auth",
                HttpMethod.POST, loginRequest, JwtAuthenticationRequest.class).getStatusCode();

        ResponseEntity<JwtAuthenticationResponse> responseEntity = restTemplate.postForEntity(
                "http://localhost:" + serverPort + "/auth", loginRequest, JwtAuthenticationResponse.class);

        Assertions.assertThat(status).isEqualTo(HttpStatus.OK);

        Assertions.assertThat(responseEntity.getBody().getToken()).isNotNull();

    }

    @Test
    public void testGeneratePrimeNumber() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE2Mj" +
                "AwNzkxODEsImlhdCI6MTU1OTU5OTE4MX0.UR9f5bLTFaIKTrNh678GCKX4d1brep6pRq7HmXePwf" +
                "Ht_z2fsEbXq1Zsb0y0C7IXsSaPF7F9qkuRNqWXyR59PA";
        headers.add("Authorization", "Bearer " + token);
        HttpEntity<GenerationResponse> httpEntity = new HttpEntity<>(headers);

        HttpStatus status = restTemplate
                .exchange("http://localhost:" + serverPort + "/prime-numbers/generate/?start=0&end=100&strategy=1",
                        HttpMethod.GET, httpEntity, GenerationResponse.class).getStatusCode();

        Assertions.assertThat(status).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(userGenerationLogRepository.findAll()).hasSize(1);
    }
} 
