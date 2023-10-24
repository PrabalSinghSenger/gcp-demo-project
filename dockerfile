FROM openjdk:11
COPY target/gcp-demo-project-0.0.1-SNAPSHOT.jar gcp-demo-project-0.0.1.jar
ENTRYPOINT ["java","-jar","/gcp-demo-project-0.0.1.jar"]