FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD build/libs/springtutorialapp-0.2.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
