FROM openjdk:11
ARG JAR_FILE=target/*.jar
ADD ./target/MySpringBootPOS-1.0.0.jar MySpringBootPOS-1.0.0.jar
ENTRYPOINT ["java","-jar","/MySpringBootPOS-1.0.0.jar"]
EXPOSE 8080
#
#FROM java:11
#VOLUME /tmp
#ADD target/demo-0.0.1-SNAPSHOT.jar app.jar
#RUN bash -c 'touch /app.jar'
#EXPOSE 8080
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

#FROM ${BUILD_IMAGE} as dependencies
#COPY pom.xml ./
#RUN mvn -B dependency:go-offline
#
#FROM dependencies as build
#COPY src ./src
#RUN mvn -B clean package
#
#FROM ${RUNTIME_IMAGE}
#COPY --from=build ./target/MySpringBootPOS-1.0.0.jar MySpringBootPOS-1.0.0.jar
#CMD ["/usr/bin/java", "-jar", "/target/MySpringBootPOS-1.0.0.jar"]
