# Use Amazon Corretto 21 as the base image
FROM amazoncorretto:21

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your application runs on
EXPOSE 8080

# Define a custom entrypoint
ENTRYPOINT ["java", "-jar", "-XX:MaxRAMPercentage=70.0", "/app/app.jar"]
