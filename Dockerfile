FROM openjdk:11
ADD target/prices-api-0.0.1.jar /developments/
ENTRYPOINT ["java","-jar","/developments/prices-api-0.0.1.jar"]