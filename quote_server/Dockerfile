FROM debian:buster-slim

RUN apt-get update
RUN apt-get install -y openjdk-11-jre curl

ADD target/QuteQuote-1.1.1-SNAPSHOT-jar-with-dependencies.jar /srv/apiserver.jar
ADD QuoteDatabase.db /srv/QuoteDatabase.db

WORKDIR /srv
EXPOSE 5000

CMD ["java", "-jar", "apiserver.jar"]
