# Product Service

## Project Description

Product Service is a modular backend application designed for managing products and users. It is built using Java and
Kotlin, leveraging the Spring Boot framework. The project follows a microservices architecture, with separate modules
for products, users, and an API gateway. It is suitable for scalable enterprise environments and can be run locally or
with Docker. The project is built with reactive programming principles using Spring WebFlux and Project Reactor,
enabling
asynchronous and non-blocking operations for high scalability.

## Project Structure

- **apigateway/**: Handles API routing and gateway logic.
- **ms-products/**: Microservice for product management (domain, application, infrastructure layers).
- **ms-users/**: Microservice for user management (domain, application, infrastructure layers).
- **docker/**: Contains configuration files for observability tools (Prometheus, Grafana, OpenTelemetry).

## Prerequisites

- Java 21+
- Gradle 8.8+
- Spring Boot 3.3.5+
- Docker (for containerized deployment)

## How to Run Locally

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd product-service
   ```
2. Build the project:
   ```bash
   ./gradlew build
   ```
3. Run the microservices:
   ```bash
   ./gradlew :ms-products:infrastructure:bootRun
   ./gradlew :ms-users:infrastructure:bootRun
   ./gradlew :apigateway:infrastructure:bootRun
   ```

## How to Run with Docker

1. Build Docker images:
   ```bash
   ./gradlew build
   docker-compose build
   ```
2. Start all services:
   ```bash
   docker-compose up
   ```

## Usage

- The API Gateway exposes endpoints for product and user management.
- Default ports:
    - API Gateway: 8080
    - Products Service: 8081
    - Users Service: 8082
- Access the API documentation (if enabled) at `http://localhost:8080/swagger-ui.html`

## Contributing

Feel free to open issues or submit pull requests. For major changes, please discuss them first.

## License

This project is licensed under the MIT License.
