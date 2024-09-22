FROM eclipse-temurin:23_37-jre-alpine
WORKDIR /app
COPY target/ruoyi-admin.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
