FROM openjdk:18
# Custom cache invalidation
ARG CACHEBUST=1
ADD target/prices-api-0.0.1.jar /developments/
ENTRYPOINT ["java","-jar","/developments/prices-api-0.0.1.jar"]