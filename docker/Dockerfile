FROM adoptopenjdk/openjdk11

ENV server.port 8080

RUN sh -c 'mkdir -p /app/{logs,data}'

COPY target/app.jar /app/app.jar

RUN sh -c 'touch /app/app.jar'
EXPOSE 8080
WORKDIR /app
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]