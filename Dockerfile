FROM openjdk:8-jre
ENTRYPOINT ["\/app\/bin\/openapi"]
COPY 0/stage /app
WORKDIR data