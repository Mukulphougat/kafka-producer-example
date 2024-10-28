# Use a base image with Java installed
FROM openjdk:17-jdk-slim
LABEL authors="mukul"

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file into the container
COPY target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 9090

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=9090"]
# One More Update

#DOCKER DEPLOY
#stage('Deploy') {
#            steps {
#                script {
#                    echo 'Stopping any running instances...'
#                    // Optionally stop and remove any existing Docker container
#                    sh "/Applications/Docker.app/Contents/Resources/bin/docker stop myapp || true"
#                    sh "/Applications/Docker.app/Contents/Resources/bin/docker rm myapp || true"
#
#                    echo 'Building Docker image...'
#                    // Build the Docker image
#                    sh "/Applications/Docker.app/Contents/Resources/bin/docker build -t myapp:latest ."
#
#                    echo 'Deploying application with Docker...'
#                    // Run the Docker container
#                    sh "/Applications/Docker.app/Contents/Resources/bin/docker run -d --name myapp -p 9090:9090 myapp:latest"
#
#                    // Wait for a few seconds for the application to start
#                    sleep 20
#                }
#            }
#        }