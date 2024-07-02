Portfolio Project: Contact Form with Email Notification

Overview:
This project is a full-stack web application that includes a contact form for portfolio websites. The form allows users to submit their contact information and message, which is then stored in a MySQL database and sent via email to a specified recipient.

Features:
1. Contact Form: A user-friendly form where visitors can input their name, email, subject, and message.
2. Email Notification: Upon form submission, an email notification is sent to the specified recipient using Gmail's SMTP server.
3. Database Storage: Submitted form data is stored in a MySQL database for record-keeping and further processing.
4. CORS Configuration: Configured to handle cross-origin requests, enabling the frontend and backend to communicate seamlessly despite being hosted on different platforms.

Technologies Used:
Frontend:
HTML/CSS/JavaScript: The frontend is built with standard web technologies.
Netlify: Deployed the static frontend on Netlify for fast, reliable, and scalable hosting.

Backend:
Spring Boot: A Java-based framework used to create the RESTful API for handling form submissions and sending emails.
Spring Data JPA: Used for interacting with the MySQL database.
Spring Boot Starter Mail: Used for configuring the email service.
MySQL: Database for storing form submissions.

