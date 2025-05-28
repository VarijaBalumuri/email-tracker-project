📧 Email Tracker Project

A full-stack email tracking application that enables users to monitor email opens through embedded tracking pixels. Built with a Java Spring Boot backend and a React.js frontend, the project utilizes Docker for containerization and deployment. ￼

⸻

⚙️ Tech Stack
	•	Frontend: React.js, HTML, CSS, SCSS
	•	Backend: Java 17, Spring Boot
	•	Database: H2 (in-memory) or PostgreSQL (configurable)
	•	Containerization: Docker, Docker Compose ￼

⸻

🛠️ Setup & Installation

Prerequisites
	•	Docker installed on your machine
	•	Docker Compose installed ￼

Steps
	1.	Clone the Repository

git clone https://github.com/VarijaBalumuri/email-tracker-project.git
cd email-tracker-project


	2.	Build and Run with Docker Compose

docker-compose up --build

This command will build and start both the frontend and backend services.

	3.	Access the Application
	•	Frontend: Navigate to http://localhost:3000 in your browser.
	•	Backend API: Access http://localhost:8080/api for API endpoints.

⸻

📩 How Email Tracking Works

The application embeds a unique 1x1 transparent pixel in the body of outgoing emails. When a recipient opens the email, their client loads this pixel, triggering a request to the backend server. This request logs the open event, capturing metadata such as timestamp and IP address. ￼

⸻

📊 Dashboard Overview

The React.js frontend provides a dashboard where users can: ￼
	•	View a list of sent emails with their tracking status.
	•	Monitor real-time open events.
	•	Access detailed analytics for each tracked email. ￼

⸻

🧪 Running Tests

Backend Tests
	1.	Navigate to the Backend Directory

cd email-tracker


	2.	Run Tests Using Maven

mvn test



Frontend Tests
	1.	Navigate to the Frontend Directory

cd email-tracker-ui


	2.	Install Dependencies

npm install


	3.	Run Tests

npm test



⸻

🧑‍💻 Contributing

Contributions are welcome! Please follow these steps:
	1.	Fork the Repository
Click on the “Fork” button at the top right of the repository page.
	2.	Create a New Branch

git checkout -b feature/YourFeatureName


	3.	Commit Your Changes

git commit -m "Add Your Feature"


	4.	Push to Your Fork

git push origin feature/YourFeatureName


	5.	Create a Pull Request
Open a pull request from your forked repository to the main branch of this repository.

⸻

📄 License

This project is licensed under the MIT License.

⸻

📬 Contact
For any inquiries or feedback, please contact Varija Balumuri.
