# Stage 1: Build the WAR file using Gradle
FROM gradle:8.7-jdk21 AS build
WORKDIR /app
COPY . .
# Run the bootWar task to generate the .war file (skipping tests for speed)
RUN ./gradlew clean bootWar -x test

# Stage 2: Deploy to an official Tomcat 10 Server
FROM tomcat:10.1-jdk21
# Remove the default Tomcat splash page applications
RUN rm -rf /usr/local/tomcat/webapps/*
# Copy our built WAR from Stage 1 and rename it to ROOT.war
# (Naming it ROOT.war ensures your API is at the root URL '/' instead of '/micro/')
COPY --from=build /app/build/libs/*.war /usr/local/tomcat/webapps/ROOT.war

# Tomcat's default port is 8080
EXPOSE 8080
CMD ["catalina.sh", "run"]