# Start with a base image containing Java runtime
FROM maven:3.5-jdk-8-alpine

LABEL maintainer="jasrodis@gmail.com"

# Add project directory
COPY . /app

# Working dir is now the project dir
WORKDIR /app

# Create jar file
RUN mvn clean package

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/target/spring-boot-vuejs-websockets-1.0.0.jar"]

