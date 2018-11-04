FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/bnk-fx-0.0.1-SNAPSHOT.jar bnk-fx.jar
ENTRYPOINT ["java","-jar","bnk-fx.jar "]