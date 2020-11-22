FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} taskIMB.jar
ENTRYPOINT ["java","-jar","/taskIMB.jar"]