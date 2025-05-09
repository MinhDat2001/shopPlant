# Stage 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Tối ưu cache dependency trước (chỉ copy pom.xml trước)
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copy toàn bộ source code và build
COPY src ./src
RUN mvn clean package -DskipTests -B

# Stage 2: Run the application (minimal image)
FROM eclipse-temurin:17-jre-alpine

# Metadata optional
LABEL maintainer="Dang Minh Dat <datd61340@gmail.com>"

# Tối ưu JVM trong container
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Thư mục làm việc trong container
WORKDIR /app

# Copy file jar từ stage build
COPY --from=build /app/target/*.jar app.jar

# Expose port ứng dụng (thay 8080 nếu app bạn dùng port khác)
EXPOSE 8081

# Default CMD (cho phép override JAVA_OPTS nếu cần)
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]