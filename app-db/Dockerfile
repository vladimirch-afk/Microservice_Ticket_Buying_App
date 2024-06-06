FROM postgres:alpine3.20
COPY db1.sql /docker-entrypoint-initdb.d/db1.sql
ENV POSTGRES_USERNAME=postgres
ENV POSTGRES_PASSWORD=postgres
EXPOSE 5432/tcp
