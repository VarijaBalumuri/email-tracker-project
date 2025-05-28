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