FROM maven:3.9.11-eclipse-temurin-17 AS build
WORKDIR /app    
COPY src/ ./src/
COPY pom.xml .
RUN mvn -B clean package -DskipTests

FROM tomcat:11.0.14-jdk25-temurin-noble
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]