# Email Tracker

## Project Description

Email Tracker is a full-stack application designed to monitor and track email deliveries and interactions. It includes a Spring Boot backend API, an Angular frontend with NgRx for state management, PostgreSQL database, Kafka messaging, and Docker support for containerization.

---

## Features

- **Track email delivery status**
- **Monitor email open and click events**
- **Kafka integration for asynchronous event handling**
- **Spring Boot REST API backend**
- **Angular frontend with NgRx state management**
- **PostgreSQL for data persistence**
- **Dockerized services for easy deployment**
- **Basic CI/CD pipeline setup**

---

## Technologies Used

| Component          | Technology           |
|--------------------|----------------------|
| Backend            | Java, Spring Boot    |
| Frontend           | Angular, NgRx        |
| Database           | PostgreSQL           |
| Messaging Queue    | Apache Kafka         |
| Containerization   | Docker               |
| CI/CD              | Pipeline scripts     |

---

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 17 or higher
- Maven 3.6 or higher
- Node.js 16 or higher
- Angular CLI 15 or higher
- Docker and Docker Compose installed
- PostgreSQL 14 or higher
- Kafka cluster (can run via Docker)

---

### Installation Steps

1. **Clone the repository**

    ```bash
    git clone https://github.com/VarijaBalumuri/email-tracker.git
    cd email-tracker
    ```

2. **Backend Setup**

    - Navigate to the backend directory:
      ```bash
      cd backend
      ```
    - Build the project:
      ```bash
      ./mvnw clean install
      ```

3. **Frontend Setup**

    - Navigate to the frontend directory:
      ```bash
      cd ../frontend
      ```
    - Install dependencies:
      ```bash
      npm install
      ```

4. **Configuration**

    - Update backend configuration files (`application.properties` or `application.yml`) with your PostgreSQL and Kafka connection details.
    - Adjust Angular environment files if necessary.

5. **Run supporting services**

    - Start PostgreSQL and Kafka either locally or using Docker.

6. **Run the backend**

    ```bash
    ./mvnw spring-boot:run
    ```

7. **Run the frontend**

    ```bash
    ng serve
    ```

8. **Access the app**

    Open your browser and visit:

    ```
    http://localhost:4200
    ```

---

# Email Tracker UI

Angular application to visualize email status from the Email Tracker API.

## Prerequisites

* Node.js 18+
* Angular CLI (npm install -g @angular/cli)

## Setup

bash
unzip email-tracker-ui.zip
cd email-tracker-ui
npm install
ng serve


Navigate to http://localhost:4200 in your browser.

## API endpoint

The UI expects the Email Tracker REST API to be running at http://localhost:8080/api/emails.
Adjust baseUrl in src/app/services/email.service.ts if your backend is hosted elsewhere.

## Running with Docker

To start all components using Docker Compose, run:

```bash
docker-compose up --build
