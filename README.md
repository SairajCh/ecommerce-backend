# E-Commerce Backend

Spring Boot REST API backend for a full-stack e-commerce application. Serves product, order, and customer data to the [Angular frontend](https://github.com/SairajCh/ecommerce-frontend).

## Tech Stack

`Java` · `Spring Boot` · `Spring Data JPA` · `Spring Security` · `MySQL` · `Maven` · `REST API`

## Features

- RESTful API for products, categories, orders, and customers
- Spring Data JPA with MySQL for data persistence
- Spring Security for authentication and authorisation
- CORS configuration for Angular frontend integration
- DAO and service layer separation

## Project Structure

```
spring-boot-ecommerce/
├── src/main/java/com/sairaj/ecommerce/
│   ├── config/         # Security and CORS config
│   ├── controller/     # REST controllers (product, order, customer…)
│   ├── dao/            # Spring Data JPA repositories
│   ├── dto/            # Data Transfer Objects
│   ├── entity/         # JPA entities
│   └── service/        # Business logic layer
├── src/main/resources/
│   └── application.properties   # DB connection, server port
└── pom.xml
```

## Getting Started

### Prerequisites

- Java 11+
- Maven
- MySQL

### Database Setup

```sql
CREATE DATABASE ecommerce;
```

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Run Locally

```bash
# 1. Clone the repo
git clone https://github.com/SairajCh/ecommerce-backend.git
cd ecommerce-backend/spring-boot-ecommerce

# 2. Build the project
mvn clean install

# 3. Start the server
mvn spring-boot:run
```

API runs at [http://localhost:8080](http://localhost:8080).

### Example Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| GET | `/api/product-category` | Get all categories |
| POST | `/api/checkout/purchase` | Place an order |

## Related Repository

**Frontend:** [SairajCh/ecommerce-frontend](https://github.com/SairajCh/ecommerce-frontend) — Angular UI
