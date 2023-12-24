# Use the official OpenJDK image for Java 17
FROM openjdk:17-oracle

# Add Maintainer Info
LABEL maintainer="bla"

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory of your Maven build to the container
COPY target/microservice-demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
