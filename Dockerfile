FROM openjdk:17.0.2

WORKDIR /app

COPY ./target/stream-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

ENTRYPOINT ["java","-jar","stream-0.0.1-SNAPSHOT.jar"]

# docker build -t arquetipo-negocio .
# docker run -d -p 8081:8081 -t arquetipo-negocio:latest  arquetipo-negocio