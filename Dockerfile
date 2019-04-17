FROM openjdk:8-jdk-alpine

COPY ./build/libs/docker-visits.jar /usr/src/hello/

WORKDIR /usr/src/hello

EXPOSE 8080

CMD ["java", "-jar", "docker-visits.jar"]


#FROM gradle:4.4.1-jdk9
#WORKDIR /srv
#COPY build.gradle .
#COPY src ./src/
#CMD gradle build --no-daemon --console plain
