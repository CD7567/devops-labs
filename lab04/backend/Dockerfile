FROM alpine:3.21.3 AS slave
LABEL authors="cd7567"


# Prepare GraalVM (Liberica NIK is the only one supporting musl-libc)
RUN cd /opt && \
    wget https://download.bell-sw.com/vm/23.1.6/bellsoft-liberica-vm-core-openjdk21.0.6+10-23.1.6+1-linux-x64-musl.apk && \
    apk add --allow-untrusted bellsoft-liberica-vm-core-openjdk21.0.6+10-23.1.6+1-linux-x64-musl.apk && \
    rm bellsoft-liberica-vm-core-openjdk21.0.6+10-23.1.6+1-linux-x64-musl.apk

# Install native-image requirements
RUN apk add --no-cache gcc musl-dev zlib-static

# Prepare Gradle without JVM
RUN cd /opt && \
    wget https://services.gradle.org/distributions/gradle-8.13-bin.zip && \
    unzip gradle-8.13-bin.zip && \
    rm gradle-8.13-bin.zip

# Make env variables for manually installed dependencies
ENV JAVA_HOME=/opt/bellsoft/liberica-vm-core-23.1.6-openjdk21
ENV PATH=$PATH:/opt/gradle-8.13/bin


# Transfer sources to builder
COPY . /build
WORKDIR /build
RUN gradle clean nativeCompile


FROM alpine:3.21.3
LABEL authors="cd7567"

# Add username as argument
ARG CONTAINER_USER=petls


# Add compatibility layer between musl and gnu libc
#RUN apk add --no-cache gcompat


# Transfer binary artifact
COPY --from=slave /build/build/native/nativeCompile/ /app/
WORKDIR /app

# Mark backend port 8080 as exposed
EXPOSE 8080

# Initialize a new user
RUN addgroup -S $CONTAINER_USER && \
    adduser -S $CONTAINER_USER -G $CONTAINER_USER petls

# Make run non-privileged
USER $CONTAINER_USER

# Start backend from binary
CMD ["./petls"]
