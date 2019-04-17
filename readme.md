## [Docker и Spring Boot](https://thepracticaldeveloper.com/2017/12/11/dockerize-spring-boot/)



1. [Сборка](https://docs.docker.com/engine/reference/commandline/build/#tag-an-image--t) (_не забываем точку в конце_):

```docker
    docker build -t visits .
```

2. [Запуск](https://docs.docker.com/engine/reference/run/):

```docker
    docker-compose up --build
```
![alt text](https://github.com/steklopod/Docker_visits/blob/master/screenshots/docker-compose_up.png "docker-compose_up")


3. Зайти по адресу: [192.168.99.100:8080](http://192.168.99.100:8080)

