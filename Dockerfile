FROM openjdk:8

COPY ./target/cassandra-client-java-0.1.0.jar  /var/lib/cassandra/
WORKDIR /var/lib/cassandra/

EXPOSE 8080
CMD ["java", "-jar", "cassandra-client-java-0.1.0.jar"]
