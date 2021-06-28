FROM openjdk:11.0-jre
MAINTAINER finatix.de

COPY ./docker /root
COPY ./target/demo-service-dc-0.0.1-SNAPSHOT.jar /opt/app.jar

EXPOSE 9000

RUN chmod +x /root/entrypoint.sh

ENTRYPOINT ["/root/entrypoint.sh"]