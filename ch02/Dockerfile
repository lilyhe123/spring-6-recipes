FROM tomcat:jdk21-openjdk

ENV JAVA_OPTS="-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=5005,server=y,suspend=n -Djava.compiler=NONE"

COPY court.war $CATALINA_HOME/webapps/
