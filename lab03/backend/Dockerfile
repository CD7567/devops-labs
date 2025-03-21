FROM gradle:8.12.1-jdk21-graal AS slave

COPY . /build
WORKDIR /build
RUN gradle clean nativeCompile


FROM alpine:3.21.3

ARG CONTAINER_USER=petls

RUN apk add --no-cache gcompat

COPY --from=slave /build/build/native/nativeCompile/ /app/
WORKDIR /app

EXPOSE 8080

RUN addgroup -S $CONTAINER_USER && \
    adduser -S $CONTAINER_USER -G $CONTAINER_USER petls

USER $CONTAINER_USER

CMD ["./petls"]
