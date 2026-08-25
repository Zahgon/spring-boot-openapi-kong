FROM openjdk:17-jdk-slim

MAINTAINER Jonas Hecht

# Add Quarkus fast-jar layout to Container
COPY target/quarkus-app/lib/ /deployments/lib/
COPY target/quarkus-app/*.jar /deployments/
COPY target/quarkus-app/app/ /deployments/app/
COPY target/quarkus-app/quarkus/ /deployments/quarkus/

ENV JAVA_OPTS=""

# Fire up our Quarkus app by default
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /deployments/quarkus-run.jar" ]
