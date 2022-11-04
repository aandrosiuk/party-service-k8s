FROM openjdk:11
COPY target/party-service-0.0.1-SNAPSHOT.jar party-service.jar
ENTRYPOINT ["java","-jar","party-service.jar"]
