📦 E-Commerce Shipping Cost Calculation System

A Spring Boot based backend system that calculates shipping cost dynamically based on distance, product weight and delivery type.

This project demonstrates clean architecture, design patterns, caching, validation and REST API best practices.

🚀 Tech Stack

Java 17

Spring Boot 3.2.5

Spring Data JPA

H2 In-Memory Database

Swagger (OpenAPI)

Lombok

Maven

🏗️ Architecture

The project follows a layered architecture:

Controller → Service → Repository → Database
Implemented Design Patterns

✅ Strategy Pattern (Transport rate calculation)

✅ Enum-based Delivery Type (STANDARD / EXPRESS)

✅ Global Exception Handling

✅ Caching with @Cacheable

✅ Clean Separation of Concerns


📌 Features

Calculate shipping cost based on:

Warehouse location

Customer location

Product weight

Delivery type

Dynamic rate calculation using Strategy Pattern

Distance calculation using Haversine formula

Base charge + Express delivery extra charge

Swagger API documentation

In-memory H2 database

Clean RESTful API structure


📂 Project Structure

com.saicharan.shipping
│
├── controller
├── service
├── repository
├── model
├── enums
├── strategy
├── exception
├── util

🧮 Shipping Cost Formula
Shipping Cost = Distance × Product Weight × Rate
                + Base Charge
                + Express Charge (if applicable)

Rate is selected dynamically using Strategy Pattern:

Distance ≤ 100 km → High Rate

Distance ≤ 500 km → Medium Rate

Distance > 500 km → Low Rate

📘 API Documentation (Swagger)

After running the application, open:

http://localhost:8080/swagger-ui.html

📊 Sample API

Calculate Shipping Cost
GET /api/v1/shipping-charge

Example:
http://localhost:8080/api/v1/shipping-charge?warehouseId=1&customerId=1&productId=1&deliveryType=STANDARD



