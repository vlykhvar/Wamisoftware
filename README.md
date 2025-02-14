# Wamisoftware

### Prerequisites

1. [JDK 17.x](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
2. [Maven 3.8.x](https://maven.apache.org/docs/3.8.6/release-notes.html)

## Building and running the project

To build project by Maven execute the following command:

```
mvn clean install
```

Then run the project using the command below:
```
java -jar .\target\wamisoftware.jar
```

As the result the process listens the HTTP 8081 port:
```
2024-07-03 16:00:34.633  INFO 33164 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8081 (http) with context path '/geometry'
2024-07-03 16:00:34.647  INFO 33164 --- [           main] com.geometry.config.Application          : Started Application in 2.787 seconds (JVM running for 3.233)
```

Then navigate to `http://localhost:8081/geometry/swagger-ui/index.html` to try it out or 
move to `provisioning/postman/` folder and import actual postman collection and try to make request.
