FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/autocomplete-app.jar autocomplete-app.jar
ENTRYPOINT ["java", "-jar", "/autocomplete-app.jar"]
EXPOSE 9090