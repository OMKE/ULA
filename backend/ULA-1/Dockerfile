FROM adoptopenjdk/openjdk11
VOLUME /tmp
COPY target/ula-main-app-dist.war /usr/local/tomcat/webapps/ula-main-app-dist.war
EXPOSE 8080
RUN addgroup spring && adduser --disabled-password --no-create-home --system spring
USER spring:spring
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/ula-main-app-dist.war" ]