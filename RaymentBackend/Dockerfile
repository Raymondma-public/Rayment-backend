#Updated 8
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/rayment-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]