# Job Portal System

A backend-based Job Portal application developed using Java and Spring Boot. This project allows users to register, view and apply for jobs, while administrators can manage job listings and user applications.

## 🔧 Technologies Used

- Java 24
- Spring Boot
- Maven
- MySQL
- Spring Security
- Eclipse IDE

## 📁 Project Structure

```
job-portal-system/
├── controller/
├── service/
├── dao/
├── repository/
├── model/
├── config/
├── resources/
└── JobPortalSystemApplication.java
```

## ✅ Features

- User registration and login with encrypted passwords (BCrypt)
- Role-based access control (`ROLE_USER` and `ROLE_ADMIN`)
- Job listing, creation, update, and deletion
- Users can apply for jobs
- Admin can manage jobs and view applications
- RESTful API structure

## 🛠️ How to Run

1. Clone this repository
2. Import into Eclipse as a Maven project
3. Set up MySQL and update credentials in `application.properties`
4. Run `JobPortalSystemApplication.java`

## 📦 Database Tables

- `users`: stores user credentials and roles
- `jobs`: job postings
- `applications`: user applications for jobs

## 🔐 Security

- Spring Security configuration restricts access based on roles
- Admin routes are protected
- Passwords are stored securely using BCrypt hashing

## 🚀 Future Enhancements

- Resume upload and file handling
- Frontend (React/HTML)
- Employer login module
- Deployment with Docker or cloud platforms

---

© 2025 Pratheek Gaba
