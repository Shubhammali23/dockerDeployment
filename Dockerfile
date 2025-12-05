FROM eclipse-temurin:17
LABEL mainterner="malishubham391@gmail.com"
WORKDIR /app
COPY target/spring-boot-data-jpa-0.0.1-SNAPSHOT.jar /app/spring-boot-crud-docker.jar
ENTRYPOINT ["java", "-jar", "spring-boot-crud-docker.jar"]
