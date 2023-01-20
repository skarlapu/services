FROM openjdk:17
EXPOSE 9292
ADD target/service-discovery.jar service-discovery.jar
ENTRYPOINT ["java","-jar","service-discovery.jar"]