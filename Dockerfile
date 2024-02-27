FROM openjdk:17-jdk
WORKDIR /app
COPY ./target/spring-messagesource-xliff-example.jar /app
EXPOSE 8080
CMD ["java", "-jar", "spring-messagesource-xliff-example.jar"]
