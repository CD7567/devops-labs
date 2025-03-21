FROM nginx:1.27.4-alpine3.21-perl
LABEL authors="cd7567"

RUN chown -R nginx:nginx /var/cache/nginx && \
    chown -R nginx:nginx /etc/nginx

RUN touch /var/run/nginx.pid && \
    chown -R nginx:nginx /var/run/nginx.pid /run/nginx.pid

COPY conf/nginx.conf /etc/nginx/

EXPOSE 80
VOLUME /usr/share/nginx/html

USER nginx

CMD ["nginx", "-g", "daemon off;"]
