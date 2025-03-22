FROM alpine:3.21.3
LABEL authors="cd7567"

# Add nginx to container
RUN apk add --no-cache nginx

# Redirect nginx logs to container std streams
RUN ln -sf /dev/stdout /var/log/nginx/access.log && \
    ln -sf /dev/stderr /var/log/nginx/error.log


# Copy nginx config inside the container
COPY conf/nginx.conf /etc/nginx/

# Mark standard port 80 as exposed
EXPOSE 80

# Attach static pages as a volume
VOLUME /usr/share/nginx/html

# Make run non-privileged from nginx user
USER nginx

# Standard nginx daemonless launch command
CMD ["nginx", "-g", "daemon off;"]
