FROM openjdk:8-jdk-alpine

COPY ./build/libs/docker-visits.jar /usr/src/steklopod/

WORKDIR /usr/src/steklopod

EXPOSE 8080

CMD ["java", "-jar", "docker-visits.jar"]
