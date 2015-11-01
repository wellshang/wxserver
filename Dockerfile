FROM ubuntu

MAINTAINER wellshang "wellshang@gmail.com"

RUN apt-get update
RUN apt-get install openjdk-7-jre -y
RUN apt-get install openjdk-7-jdk -y
RUN apt-get install nginx -y
RUN apt-get install wget -y
RUN apt-get install openssh-server -y

ADD ./pkg/apache-tomcat-7.0.65.tar.gz /tmp/apache-tomcat-7.0.65.tar.gz
ADD ./pkgs/apache-maven-3.3.3-bin.tar.gz /tmp/apache-maven-3.3.3-bin.tar.gz
ADD ./etc/nginx-conf /etc/nginx/conf.d
ADD ./etc/scripts /usr/local
RUN chmod a+x /usr/local/start.sh

RUN cd /usr/local && tar xzf /tmp/apache-tomcat-7.0.65.tar.gz
RUN ls apache-tomcat-7.0.65
RUN mv apache-tomcat-7.0.65 /usr/local
RUN ln -s /usr/local/apache-tomcat-7.0.65 /usr/local/tomcat
RUN rm -rf /tmp/apache-tomcat-7.0.65.tar.gz
RUN cd /usr/local/tomcat/conf && sed -i "s/8080/80/g" sserver.xml

RUN cd /usr/local && tar xzf /tmp/apache-maven-3.3.3-bin.tar.gz
RUN ln -s /usr/local/apache-maven-3.3.3 /usr/local/maven
RUN rm -rf /tmp/apache-maven-3.3.3-bin.tar.gz

RUN mkdir -p /webapp
ADD ./webapp /webapp

ENV TOMCAT_HOME /usr/local/tomcat
ENV MAVEN_HOME /usr/local/maven
ENV APP_HOME /webapp

RUN cd /webapp && /usr/local/maven/bin/mvn package 
RUN rm -rf $TOMCAT_HOME/webapps/*
RUN cd /webapp && cp target/wx_server.war $TOMCAT_HOME/webapps/ROOT.war

CMD /usr/local/start.sh && tail -F /usr/local/tomcat/logs/catalina.out

EXPOSE 80 8080