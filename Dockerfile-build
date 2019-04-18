FROM gradle:5.4.0-jdk11-slim

USER root

WORKDIR /usr/app

COPY . .

RUN gradle build

RUN cp ./build/libs/*.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
