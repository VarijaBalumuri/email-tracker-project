# Email Tracker Project

An end-to-end application for tracking and visualizing email status.  
The backend REST API handles email tracking data, while the Angular frontend provides a user-friendly interface to visualize email statuses.

---

## Project Overview

- **Backend:** Spring Boot REST API for managing email tracking data.
- **Frontend:** Angular application that consumes the backend API and displays email statuses.
- **Database:** PostgreSQL for persisting email records.
- **Messaging:** Kafka integration for asynchronous email event processing.
- **DevOps:** Dockerized services with CI/CD support.

---

## Prerequisites

- Java 17+ and Maven (for backend)
- Node.js 18+ and Angular CLI (for frontend)
- PostgreSQL
- Kafka (if running the full event-driven system)
- Docker & Docker Compose (optional for containerized setup)

---

## Backend Setup (Email Tracker API)

1. Clone the repo and navigate to the backend directory:

    ```bash
    git clone https://github.com/VarijaBalumuri/email-tracker-project.git
    cd email-tracker-project/email-tracker\(backend\)
    ```

2. Configure PostgreSQL database connection in `application.properties` or `application.yml`.

3. Build and run the backend:

    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

4. The API will be available at:

    ```
    http://localhost:8080/api/emails
    ```

---

## Frontend Setup (Email Tracker UI)

1. Navigate to the frontend directory:

    ```bash
    cd ../email-tracker-ui
    ```

2. Install dependencies:

    ```bash
    npm install
    ```

3. Start the Angular development server:

    ```bash
    ng serve
    ```

4. Open your browser and go to:

    ```
    http://localhost:4200
    ```

5. The frontend expects the backend API running at `http://localhost:8080/api/emails`.  
   To change the backend URL, update `baseUrl` in:

    ```
    src/app/services/email.service.ts
    ```

---

## Running with Docker (Optional)

You can build and run the backend and frontend using Docker for easier environment setup.

1. Build Docker images (if Dockerfiles are present).
2. Use Docker Compose to spin up all services including PostgreSQL and Kafka.

---

## Technologies Used

- Backend: Java, Spring Boot, JPA, Hibernate, PostgreSQL, Kafka, Docker
- Frontend: Angular, NgRx, TypeScript, RxJS
- DevOps: Docker, CI/CD pipelines

---

## Additional Notes

- Ensure Kafka and PostgreSQL services are running for full functionality.
- Unit and integration tests are included in backend and frontend respectively.
