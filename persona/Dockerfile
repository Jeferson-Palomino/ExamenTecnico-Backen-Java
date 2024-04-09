FROM alpine:latest

RUN apk update && apk add --no-cache openjdk17

WORKDIR /app

COPY target/persona-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "persona-0.0.1-SNAPSHOT.jar"]