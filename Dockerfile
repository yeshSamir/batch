# Use an official OpenJDK runtime as a parent image
FROM amazoncorretto:17
# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container at /app
COPY target/batch-aws-service.jar batch-aws-service.jar

# Expose port 8080 (assuming your Spring Boot application runs on this port)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "batch-aws-service.jar"]
