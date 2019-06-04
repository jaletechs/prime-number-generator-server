# Prime Number Generator Server

Prime Number Generator Server is an extension of the
 [Prime Number Generator](https://github.com/jaletechs/prime-number-generator) for generating prime numbers using a number of generation strategies.
e.g. Brute Force (with and without optimizations), and Sieve of Eratosthenes. It is a Spring Boot project which 
exposes prime number generation strategies over a RESTful API.

## Requirements
This project is built with Gradle 4.4.1 and Java 1.8


## Execution

The project is a gradle project, hence execution would require running a few gradle tasks. e.g.

```bash
gradle bootRun
```
To run tests
```bash
gradle test
```
Depending on your preferred IDE, you can run both and project and tests with a simple button click :)

## Usage
Just start the application with the Spring Boot gradle plugin(`gradle bootRun`). With no other application running,
the application is running at [http://localhost:8080](http://localhost:8080).

There are two user accounts present to ease testing and access to authentication (login)
endpoints and subsequently prime number generation. These users are

```$xslt
Test User 1
    username: admin@gmail.com
    password: 12345678
    
Test User 2
    username: user@gmail.com
    password: 12345678
```
There are a few endpoints to ease the demonstration of this project:
#### /auth
/auth - authentication endpoint with unrestricted access. It returns a JWT Token with which subsequent
requests e.g. prime number generation, can be made. This requires a JSON with the following structure
```json
    {
        "username": "admin@gmail.com",
        "password": "12345678"
    }
```
#### /auth/users
/auth/users - endpoint with unrestricted access for creating a new user on the system. 
This requires a JSON with the following structure
```json
    {
    	"email":"test@gmail.com",
    	"password": "testpassword",
    	"fullName": "New Test User"
    }
```

#### /prime-numbers/generate
This endpoint returns the result of generating prime numbers for a given range provided by the user.
It requires the token received from authentication in the header of the request. (`Bearer + token` with the `Authorization` entry).

An example of a query to this endpoint is:
```$xslt
    http://localhost:8080/prime-numbers/generate/?start=0&end=100&strategy=1
```
Available generation strategies are listed below:
```$xslt
1.  Brute Force Strategy
2.  Optimized Brute Force Strategy
3.  Sieve of Eratosthenes
```

#### /h2-console
/h2-console - endpoint for viewing records in the in-memory H2 Database (Should be disabled in production).

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.