FROM openjdk:8-jdk-alpine
MAINTAINER Philippe Tjon-A-Hen (philippe@tjonahen.nl)
VOLUME /tmp
ADD springstdcat.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]