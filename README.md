Email Tracker

Overview
Email Tracker is a full-stack application designed to track email deliveries and user interactions efficiently. The backend is built with Spring Boot and exposes REST APIs, while the frontend is an Angular application utilizing NgRx for state management. The project integrates Kafka for asynchronous event handling and uses PostgreSQL as the primary database. The entire system is containerized with Docker and supports CI/CD pipelines for automated deployment.

Features
Track sent emails and their delivery status.
Monitor email open and click events.
Kafka integration for scalable event processing.
REST API backend built with Spring Boot.
Angular frontend with NgRx state management.
PostgreSQL database persistence.
Dockerized services for easy deployment.
Basic CI/CD pipeline setup.


Prerequisites
- Java 17+
- Maven 3.6+
- Node.js 16+
- Angular CLI 15+
- Docker & Docker Compose
- PostgreSQL 14+
- Kafka (or Docker-based Kafka)

Installation
* Clone the repository: 
- git clone https://github.com/VarijaBalumuri/email-tracker.git
- cd email-tracker

* Backend Setup: Navigate to the backend folder and build the project:
- cd backend
- ./mvnw clean install
  
* Frontend Setup: Navigate to the frontend folder and install dependencies:
- cd ../frontend
- npm install

* Configure Environment:
- Update application.properties or application.yml in the backend with your PostgreSQL and Kafka connection details.
- Update Angular environment files if needed.
- You can start PostgreSQL and Kafka via Docker or locally.

* Run the Backend: 
- ./mvnw spring-boot:run

* Run the Frontend:
- ng serve
  
Finally, Open your browser at http://localhost:4200
