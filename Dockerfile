FROM openjdk:13-jdk-alpine
EXPOSE 8081
VOLUME /tmp
ARG JAR_FILE=target/thesis-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} thesis-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","thesis-0.0.1-SNAPSHOT.jar"]
