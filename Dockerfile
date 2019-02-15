FROM openjdk:8-jdk-alpine

VOLUME /tmp
ADD /target/coffee-order-service-spring.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
