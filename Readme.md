# Example: XLIFF MessageSource for Spring

This example shows how to use [spring-messagesource-xliff](https://github.com/alaugks/spring-messagesource-xliff).

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


## Related MessageSources and Examples  
  
* [XLIFF MessageSource for Spring](https://github.com/alaugks/spring-messagesource-xliff)  
* [JSON MessageSource for Spring](https://github.com/alaugks/spring-messagesource-json)
* [Example: XLIFF MessageSource for Spring](https://github.com/alaugks/spring-messagesource-xliff-example)    
* [Example: JSON MessageSource for Spring](https://github.com/alaugks/spring-messagesource-json-example)  
* [Example: Custom Database Spring MessageSource](https://github.com/alaugks/spring-messagesource-db-example)
