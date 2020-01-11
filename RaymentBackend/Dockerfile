#Updated 9
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/rayment-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=<SPRING_PROFILES_ACTIVE>","/app.jar"]