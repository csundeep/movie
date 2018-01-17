FROM java:8

MAINTAINER SANDY

EXPOSE 9000

ADD Movieflix-0.0.1-SNAPSHOT.jar /Movieflix-0.0.1-SNAPSHOT.jar
RUN chmod +x /Movieflix-0.0.1-SNAPSHOT.jar

ADD start_up.sh /start_up.sh
RUN chmod +x /start_up.sh

CMD bash start_up.sh