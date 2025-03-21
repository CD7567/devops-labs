FROM gradle:8.13.0-jdk21-alpine

# Build executable jar
COPY . /build
WORKDIR /build
RUN gradle clean bootJar

# Move executable jar to app folder
RUN mkdir /app && cp /build/build/libs/* /app/
WORKDIR /app

# Clear source files
RUN rm -rf /build

EXPOSE 8080

CMD java -jar $(ls)