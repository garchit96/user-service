FROM openjdk:8
ADD target/User-service.jar User-service.jar
EXPOSE 9003
ENTRYPOINT ["java", "-jar","User-service.jar"]