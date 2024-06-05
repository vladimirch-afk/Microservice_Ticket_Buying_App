FROM postgres:16.3-alpine
ENV POSTGRES_USERNAME postgres
ENV POSTGRES_PASSWORD postgres
COPY db1.sql /docker-entrypoint-initdb.d/db1.sql
EXPOSE 5432