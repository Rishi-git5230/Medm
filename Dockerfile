# Use the official OpenJDK image as the build environment
FROM openjdk:17-jdk-slim as builder

# Set the working directory
WORKDIR /app

# Copy the Gradle wrapper files and the build files
COPY gradlew ./
COPY gradle ./gradle/
COPY build.gradle settings.gradle ./

# Make the Gradle wrapper executable
RUN chmod +x ./gradlew

# Copy the rest of the application code
COPY . .

# Build the application
RUN ./gradlew build --no-daemon

# Second stage: run the application
FROM openjdk:17-jdk-slim
COPY --from=builder /app/build/libs/MEDM-0.0.1-SNAPSHOT.jar medm-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/medm-api.jar"]
