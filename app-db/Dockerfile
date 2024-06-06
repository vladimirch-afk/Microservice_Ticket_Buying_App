FROM postgres:alpine3.20
COPY db2.sql /docker-entrypoint-initdb.d/db2.sql
ENV POSTGRES_USERNAME=postgres
ENV POSTGRES_PASSWORD=postgres
EXPOSE 5432/tcp
