FROM adoptopenjdk/openjdk8
WORKDIR /app
COPY ./dockerdemo-0.0.1-SNAPSHOT.jar ./dockerdemo-0.0.1-SNAPSHOT.jar
RUN chmod g+rwx -R .
EXPOSE 8082
CMD java -jar dockerdemo-0.0.1-SNAPSHOT.jar