FROM openjdk:8-jdk-alpine
COPY target/*.jar msui-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/msui-0.0.1-SNAPSHOT.jar"]