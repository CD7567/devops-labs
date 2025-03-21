FROM gradle:8.13.0-jdk21-alpine

ARG CONTAINER_USER=petls

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

RUN addgroup -S $CONTAINER_USER && \
    adduser -S $CONTAINER_USER -G $CONTAINER_USER petls

USER $CONTAINER_USER

CMD java -jar $(ls)