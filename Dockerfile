# Use the official PostgreSQL image
FROM postgres:latest

# Set environment variables for database name, user and password
ENV POSTGRES_DB=warzone
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=123456

# Open port 5432 (default port for PostgreSQL)
EXPOSE 5432
