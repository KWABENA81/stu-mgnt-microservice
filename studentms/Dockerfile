#   Dockerfile for studentms
#
FROM openjdk:11

#   label image
LABEL Description="Student Microservice" Version="0.0.1"

ARG VERSION=0.0.1

VOLUME /tmp

ADD target/studentms-${VERSION}-SNAPSHOT.jar app.jar

#
RUN sh -c 'touch /app.jar'

#   entrypoint
ENTRYPOINT ["java", "-jar", "/app.jar"]

