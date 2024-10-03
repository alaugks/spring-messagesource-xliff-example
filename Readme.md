# Example: Spring MessageSource for XLIFF files

* alaugks/spring-messagesource-xliff ([GitHub](https://github.com/alaugks/spring-messagesource-xliff))
* Docker Image: alaugks/spring-boot-xliff-example:
  2.0.0.1 ([Docker Hub](https://hub.docker.com/repository/docker/alaugks/spring-boot-xliff-example/general))
* [Example Website](https://spring-boot-xliff-example.alaugks.dev)

## Build and Run Docker Image

```bash
docker compose up -d
```

After a successful build, open the example in your web browser.: http://localhost:8080

## Custom Changes

If you want to make changes for testing, you have to restart the Docker image.

```bash
docker compose restart
```

> [!NOTE]  
> When you restart, the JAR file is rebuilt and the Tomcat is started. This can take a few seconds.
