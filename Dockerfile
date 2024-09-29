FROM ubuntu:22.04

RUN mkdir -p /var/www/app

WORKDIR /var/www/app

COPY ./ /var/www/app

### Install packages
RUN apt-get update \
	&& apt-get install -y --no-install-recommends curl openjdk-21-jdk openjdk-21-jre \
  	&& apt-get clean

### Install maven
RUN mkdir -p /usr/share/maven \
	&& curl -fsSL -o /tmp/apache-maven.tar.gz https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz \
	&& tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
	&& rm -f /tmp/apache-maven.tar.gz \
	&& ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME="/usr/share/maven"

RUN export JAVA_HOME="$(dirname $(dirname $(readlink -f $(which java))))"

RUN mvn install

EXPOSE 8080
CMD ["java", "-jar", "spring-messagesource-xliff-example.jar"]
