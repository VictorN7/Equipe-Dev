FROM adoptopenjdk/openjdk11:alpine
COPY ./target/*.jar app.jar
CMD [ "java", "-jar", "app.jar" ]
EXPOSE 8080