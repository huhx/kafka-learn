FROM openjdk:8
COPY ./build/libs/core-learn-kafka-0.0.1.jar /data/
WORKDIR /data

EXPOSE 9089
ENTRYPOINT java -jar core-learn-kafka-0.0.1.jar