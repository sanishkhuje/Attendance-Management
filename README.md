# 🚀 Attendance Management System

A secure and scalable **Attendance Management System** built using **Java** and **Spring Boot**.
This project provides **JWT Authentication**, **role-based authorization**, and efficient **attendance tracking** with seamless **MySQL database integration**.

---

# ✨ Features

✅ User Authentication with JWT
✅ Spring Security Integration
✅ Role-Based Access Control
✅ Attendance Management APIs
✅ Teacher Management Module
✅ RESTful API Architecture
✅ MySQL Database Integration
✅ Validation Support
✅ Secure Protected Routes

---

# 🛠️ Tech Stack

| Technology          | Usage                      |
| ------------------- | -------------------------- |
| ☕ Java 17           | Backend Development        |
| 🌱 Spring Boot      | Application Framework      |
| 🔐 Spring Security  | Authentication & Security  |
| 🗄️ Spring Data JPA | Database Operations        |
| 🎫 JWT              | Token-based Authentication |
| 🐬 MySQL            | Database                   |
| 📦 Maven            | Dependency Management      |

---

# 📁 Project Structure

```text id="9lccax"
src/
 └── main/
     ├── java/com/example/attendanceapp/
     │    ├── config/
     │    ├── controller/
     │    ├── dto/
     │    ├── entity/
     │    ├── jwt/
     │    ├── repository/
     │    ├── security/
     │    └── service/
     └── resources/
          ├── application.properties
          ├── static/
          └── templates/
```

---

# 📚 Main Modules

## 🔐 Authentication Module

* User Login
* JWT Token Generation
* Secure API Access
* Authentication & Authorization

---

## 📅 Attendance Module

* Mark Attendance
* View Attendance Records
* Attendance Tracking System
* Attendance Management APIs

---

## 👨‍🏫 Teacher Module

* Teacher Management APIs
* Student Attendance Monitoring
* Attendance Record Access

---

# 📦 Dependencies Used

* Spring Boot Starter Web
* Spring Boot Starter Security
* Spring Boot Starter Data JPA
* Spring Boot Validation
* MySQL Connector
* JWT (JJWT)

---

# ⚙️ Database Configuration

Update your `application.properties` file:

```properties id="f6hdq7"
spring.datasource.url=jdbc:mysql://localhost:3306/attendance_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# ▶️ Run the Project

## 📥 Clone Repository

```bash id="53i8t2"
git clone https://github.com/YOUR_USERNAME/attendance-app.git
```

---

## 📂 Navigate to Project

```bash id="uv0j9e"
cd attendance-app
```

---

## 🚀 Run Application

```bash id="kkkqxr"
mvn spring-boot:run
```

---

# 🌐 Application URL

```text id="dqqmgi"
http://localhost:8080
```

---

# 📡 API Endpoints

| Method    | Endpoint      | Description            |
| --------- | ------------- | ---------------------- |
| 🔑 POST   | `/auth/login` | User Login             |
| ➕ POST    | `/attendance` | Mark Attendance        |
| 📄 GET    | `/attendance` | Get Attendance Records |
| 👨‍🏫 GET | `/teacher`    | Teacher Operations     |

---

# 🔒 Security Features

✅ JWT-based Authentication
✅ Protected API Routes
✅ Role-based Authorization
✅ Secure Request Handling

---

# 🚧 Future Improvements

🔹 React Frontend Integration
🔹 Student Dashboard
🔹 Attendance Analytics
🔹 Email Notifications
🔹 Swagger API Documentation
🔹 Docker Deployment

---

# 👨‍💻 Author

Developed with using **Java**, **Spring Boot**, and **MySQL**.
