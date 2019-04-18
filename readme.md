## [Docker и Kubernetes](https://www.udemy.com/docker-and-kubernetes-the-complete-guide/)

>Рабочие процессы CI+CD, развертывание в AWS, Kubernetes.

`Docker` и `Kubernetes` являются новейшими технологиями в мире `DevOps` и резко изменили поток 
создания и развертывания веб-приложений. 

`Docker` - это технология, которая позволяет приложениям работать в конструкциях, называемых 
*контейнерами*, в то время как `Kubernetes` позволяет запускать множество различных "контейнеров" в 
координации.

*Цель* - подсчет количества заходов на страницу.


### Docker Compose

![alt text](https://github.com/steklopod/Docker_visits/blob/master/screenshots/compose.png "compose")

`Docker Compose` - это инструмент для определения и запуска приложений с несколькими контейнерами `Docker`.

Определяет службы, составляющие ваше приложение, в [docker-compose.yml](https://docs.docker.com/compose/compose-file/), 
чтобы они могли работать вместе в изолированной среде.

*`docker-compose.yml`:*

```yaml
version: '3.5'
services:
  redis-server:
    image: 'redis'
  node-app:
    build: .
    ports:
      - "4001:8081"
```

Порт `4001` - наружный, `8081` - порт внутри контейнера.

> Запуск:

```docker
docker-compose up --build
```

Флаг `--build` делает сборку каждый раз:

![alt text](https://github.com/steklopod/Docker_visits/blob/master/screenshots/docker-compose_up.png "docker-compose_up")

Зайти по адресу: [http://192.168.99.100:4001/](http://192.168.99.100:4001/)


>[Остановка](https://docs.docker.com/compose/reference/down/):

```docker
docker-compose down
```
___

### Dockerfile 

`Dockerfile` - это простой текстовый файл, содержащий команды, которые пользователь может вызвать для сборки изображения.


*`Dockerfile`:*

```dockerfile
FROM node:alpine

WORKDIR '/app'

COPY package.json .
RUN npm install
COPY . .

CMD ["npm", "start"]
```


> [Сборка](https://docs.docker.com/engine/reference/commandline/build/#tag-an-image--t) Если не используем `docker-compose`.
(_не забываем точку в конце_):

```docker
docker build -t steklopod/visits:latest .
```

![alt text](https://github.com/steklopod/Docker_visits/blob/master/screenshots/Docker_build.jpg "Docker_build")


>[Запуск](https://docs.docker.com/engine/reference/run/)

```docker
docker run -d -p 8080:8080 steklopod/visits
```

>[Остановка](https://docs.docker.com/engine/reference/commandline/stop/)
```docker
docker ps
```
скопировать `id` контейнера, а затем:
```docker
docker stop my_container_ID
```
___


#### Взаимодействие двух докер-образов:

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

___

#### Замена `192.168.99.100` -> localdocker

Чтобы изменить адрес `192.168.99.100:4001` на [localdocker:4001](http://localdocker:4001) необходимо в
файле `C:\Windows\System32\Drivers\etc\hosts` добавить строку:

```text
192.168.99.100    localdocker
```

#### Уточнить хост по умолчанию:

```bash
docker-machine ip default
```
___

#### Обновить докер:
```docker
docker-machine upgrade default
```
