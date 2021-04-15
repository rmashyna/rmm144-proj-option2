FROM alpine
WORKDIR /root
COPY Engine.java /root

#install JDK
RUN apk add openjdk8

ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:$JAVA_HOME/bin

#compile prog
RUN javac Engine.java

ENTRYPOINT java Engine
