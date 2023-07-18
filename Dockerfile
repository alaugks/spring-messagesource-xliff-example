FROM openjdk:17-jdk
WORKDIR /app
COPY ./target/spring-translation-xliff-spring-boot-example.jar /app
EXPOSE 8080
CMD ["java", "-jar", "spring-translation-xliff-spring-boot-example.jar"]
