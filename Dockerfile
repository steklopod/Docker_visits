FROM openjdk:10-jre-slim
COPY ./target/hola-docker-1.0.0-SNAPSHOT.jar /usr/src/hello/
WORKDIR /usr/src/hello
EXPOSE 8080
CMD ["java", "-jar", "hello-docker-1.0.0-SNAPSHOT.jar"]
