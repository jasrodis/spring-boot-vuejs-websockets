<p align="center">
	<img align="center" src="spring-boot-vuejs-ws.png"/>
</p>

 
<h2 align="center">spring-boot-vuejs-websockets</h2>

<p align="center">
  <em>
  Spring Boot
  · Vue.js
  · Websockets
  · STOMP
  · SockJS
  · Bootstrap4
  · Docker
</p>

<p align="center"> 
  <a href="https://travis-ci.com/jasrodis/spring-boot-vuejs-websockets">
    <img alt="travis" src="https://img.shields.io/travis/jasrodis/spring-boot-vuejs-websockets.svg?style=flat-square">
  <a href="https://opensource.org/licenses/MIT">
    <img alt="licence" src="https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square">
  </a>
</p>

This is a simple application using spring-boot, vue.js and websockets.
It displays random real-time data on a table every second.
 

## Run it! 🏃
```sh
./mvnw clean compile spring-boot:run
```
Visit `http://localhost:8080` 🙏 

## Run the tests
```sh
./mvnw test
```



## Run with docker 🏃🐳
1. Build docker image

```sh
cd spring-boot-vuejs-websockets
docker build -t spring-boot-vuejs-websockets .
```
2. Run 

```sh
docker run -p 8080:8080 -it spring-boot-vuejs-websockets
```
3. Visit `http://localhost:8080`🙏

### Made with ❤️@2019

