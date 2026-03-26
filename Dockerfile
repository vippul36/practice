FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
# This matches your artifactId 'practice' from pom.xml
COPY target/*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]