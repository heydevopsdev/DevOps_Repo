# Use a lightweight OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built APK file from the Jenkins workspace to the Docker image
COPY build/outputs/apk/debug/app-debug.apk app.apk

# Expose the application port if necessary (adjust if required by your app)
EXPOSE 8081

# Add a command to run your application if needed
# CMD ["java", "-jar", "app.apk"]
