FROM openjdk:8-jre
COPY target/account-0.0.1-SNAPSHOT.jar account.jar
ENTRYPOINT ["java","-jar","/account.jar"]