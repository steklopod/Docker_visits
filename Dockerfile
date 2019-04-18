FROM openjdk:8-jdk-alpine

COPY ./build/libs/docker-visits.jar /usr/src/hello/

WORKDIR /usr/src/hello

EXPOSE 8080

CMD ["java", "-jar", "docker-visits.jar"]
