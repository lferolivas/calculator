FROM tomcat:10-jdk17
COPY target/calculator.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
