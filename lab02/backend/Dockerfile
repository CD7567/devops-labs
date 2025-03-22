FROM alpine:3.21.3
LABEL authors="cd7567"

# Add username as argument
ARG CONTAINER_USER=petls


# Prepare Gradle and JVM
RUN apk add --no-cache openjdk21 gradle


# Build executable jar
COPY . /build
WORKDIR /build
RUN gradle clean bootJar

# Move executable jar to app folder
RUN mkdir /app && cp /build/build/libs/* /app/
WORKDIR /app

# Clear source files
RUN rm -rf /build

# Mark backend port 8080 as exposed
EXPOSE 8080

# Initialize a new user
RUN addgroup -S $CONTAINER_USER && \
    adduser -S $CONTAINER_USER -G $CONTAINER_USER petls

# Make run non-privileged
USER $CONTAINER_USER

# Start backend from jar
CMD java -jar $(ls)
