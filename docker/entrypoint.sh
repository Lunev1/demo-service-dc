#!/bin/bash

JAVA_DOCKER="-XX:+UseSerialGC -XX:GCTimeRatio=19"
JAVA_OPTS="${JAVA_OPTS} ${JAVA_DOCKER} -Djava.security.egd=file:/dev/./urandom"

JAVA_JAR_FILE="/opt/app.jar"
JAVA_CMD="java ${JAVA_OPTS} -jar ${JAVA_JAR_FILE} ${LOCALSTACK_PROPERTIES_IF_LOCAL}"

echo "${JAVA_CMD}"
eval "${JAVA_CMD}"
