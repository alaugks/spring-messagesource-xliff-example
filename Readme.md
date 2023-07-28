# Example for Spring Boot: XLIFF translation support for Spring Boot and Spring

Example implementation of the [io.github.alaugks:spring-messagesource-xliff](https://github.com/alaugks/spring-xliff-translation) package.

## Run projekt

1. Install Project
```bash
mvn clean install
```

2. Build Docker Image
```bash
docker build -t spring-boot-xliff-example . 
```

3. Run Docker Image
```bash
docker run -it -p 8080:8080 spring-boot-xliff-example
```

4. Open
http://localhost:8080/
