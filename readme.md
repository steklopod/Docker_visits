## [Docker и Kubernetes](https://www.udemy.com/docker-and-kubernetes-the-complete-guide/)

>Рабочие процессы CI+CD, развертывание в AWS, Kubernetes.

`Docker` и `Kubernetes` являются новейшими технологиями в мире `DevOps` и резко изменили поток 
создания и развертывания веб-приложений. 

`Docker` - это технология, которая позволяет приложениям работать в конструкциях, называемых 
*контейнерами*, в то время как `Kubernetes` позволяет запускать множество различных "контейнеров" в 
координации.

Приложение использует 2 образа: `node.js`, `redis`. Цель - подсчет количества заходов на страницу.

Много контейнеров `node-app` ипсользуют всего лишь 1 контейнер `redis-server`.


1. [Сборка](https://docs.docker.com/engine/reference/commandline/build/#tag-an-image--t) (_не забываем точку в конце_):

```docker
    docker build -t steklopod/visits:latest .
```

2. [Запуск](https://docs.docker.com/engine/reference/run/):

```docker
    docker-compose up --build
```
![alt text](https://github.com/steklopod/Docker_visits/blob/master/screenshots/docker-compose_up.png "docker-compose_up")


3. Зайти по адресу: [localhost:4001](http://localhost:4001)

___



*`docker-compose.yml`:*

```yaml
version: '3'
services:
  redis-server:
    image: 'redis'
  node-app:
    build: .
    ports:
      - "4001:8081"
```
___

*`docker-compose.yml`:*

```dockerfile
FROM node:alpine

WORKDIR '/app'

COPY package.json .
RUN npm install
COPY . .

CMD ["npm", "start"]
```

### Взаимодействие двух докер-образов:

Можно ссылаться по имени (`redis-server`): 

`index.js`:

```javascript
const client = redis.createClient({
    host: 'redis-server'
});
```

`docker-compose.yml`:

```yaml
services:
  redis-server:
```

