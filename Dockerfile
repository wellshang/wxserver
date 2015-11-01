FROM ubuntu

MAINTAINER wellshang "wellshang@gmail.com"

RUN apt-get update
RUN apt-get install openjdk-7-jre -y
RUN apt-get install openjdk-7-jdk -y
RUN apt-get install nginx -y
RUN apt-get install wget -y
RUN apt-get install openssh-server -y

ADD ./etc/nginx-conf /etc/nginx/conf.d

ADD ./etc/scripts /usr/local
RUN chmod a+x /usr/local/start.sh

RUN wget http://www.us.apache.org/dist/tomcat/tomcat-7/v7.0.65/bin/apache-tomcat-7.0.65.tar.gz
RUN cd /usr/local && tar xzf /tmp/apache-tomcat-7.0.65.tar.gz
RUN ln -s /usr/local/apache-tomcat-7.0.65 /usr/local/tomcat
RUN rm /tmp/apache-tomcat-7.0.65.tar.gz

RUN wget http://219.233.31.85/mirror.sdunix.com/apache/maven/maven-3/3.3.3/binaries/apache-maven-3.3.3-bin.tar.gz
RUN cd /usr/local && tar xzf /tmp/apache-maven-3.1.1-bin.tar.gz
RUN ln -s /usr/local/apache-maven-3.1.1 /usr/local/maven
RUN rm /tmp/apache-maven-3.1.1-bin.tar.gz

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