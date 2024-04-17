# Example for Spring Boot: XLIFF translation support for Spring Boot and Spring

* [Package Repository](https://github.com/alaugks/spring-messagesource-xliff)
* [Package on Maven Central](https://central.sonatype.com/artifact/io.github.alaugks/spring-messagesource-xliff)
* [Example Website](https://spring-boot-xliff-example.alaugks.dev)

## Docker Compose

Load image from Docker Hub. `linux/amd64`, `linux/arm64` and `windows/amd64` is supported.

1. Start docker compose
```bash
docker-compose -f "docker-compose.yml" up -d
```

2. Open
   http://localhost:8080/

## Docker Build

Docker image to build yourself.

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
