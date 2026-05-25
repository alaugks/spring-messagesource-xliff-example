FROM ubuntu:22.04

WORKDIR /var/www/app

RUN apt-get update \
	&& apt-get install -y --no-install-recommends curl openjdk-21-jdk openjdk-21-jre \
	&& apt-get clean \
	&& rm -rf /var/lib/apt/lists/* \
	&& mkdir -p /usr/share/maven \
	&& curl -fsSL -o /tmp/apache-maven.tar.gz https://dlcdn.apache.org/maven/maven-3/3.9.16/binaries/apache-maven-3.9.16-bin.tar.gz \
	&& tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
	&& rm -f /tmp/apache-maven.tar.gz \
	&& ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME="/usr/share/maven"

COPY pom.xml ./
RUN mvn dependency:go-offline -B

COPY . ./
RUN mvn install

EXPOSE 8080

CMD ["java", "-jar", "/var/www/app/target/app.jar"]