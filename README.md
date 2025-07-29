# Hosptial-Management-System
# 🏥 Hospital Management System (Java + JDBC + MySQL)

A simple Java console-based application designed to manage patient records, doctor listings, and appointment bookings. Built using **JDBC** and **MySQL**, this project simulates essential hospital operations in a modular and beginner-friendly setup.

---

## 🚀 Features

- ➕ Add New Patients  
- 📋 View All Patient Records  
- 🧑‍⚕️ View List of Doctors  
- 📅 Book Doctor Appointments  
- 🖥️ Menu-Driven Console Interface  

---

## 👤 User Roles

| Role         | Permissions                                                                 |
|--------------|------------------------------------------------------------------------------|
| **Receptionist** | Add/View Patients, View Doctors, Book Appointments                      |
| **Admin**         | Add Doctors via MySQL manually (no UI access)                           |

---

## 🧱 Technologies Used

- Java  
- JDBC (Java Database Connectivity)  
- MySQL  
- Eclipse IDE  
- Git & GitHub  

---

## 🛠️ How to Run

1. **Install MySQL** and create a database named `hospital`.

2. **Create the required tables**:
   ```sql
   CREATE TABLE doctors (
     id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(100),
     specialty VARCHAR(100)
   );

   CREATE TABLE patients (
     id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(100),
     age INT,
     gender VARCHAR(10)
   );

   CREATE TABLE appointments (
     id INT PRIMARY KEY AUTO_INCREMENT,
     patient_id INT,
     doctor_id INT,
     appointment_date DATE,
     FOREIGN KEY (patient_id) REFERENCES patients(id),
     FOREIGN KEY (doctor_id) REFERENCES doctors(id)
   );
3. Open Eclipse IDE (or IntelliJ/NetBeans):
  - Create a new Java Project
  - Add the MySQL JDBC connector JAR to your project:
     - Download from: https://dev.mysql.com/downloads/connector/j/
     - Right-click project → Build Path → Configure Build Path → Libraries → Add External JARs → Select MySQL Connector
    
4. Add the Java file:
   - Place HospitalManagementSystem.java in the src/ folder
  
5. Update database credentials inside the Java file:
 ```bash
String url = "jdbc:mysql://localhost:3306/hospital";
String user = "your_mysql_username";
String password = "your_mysql_password";

 ```
 6. Run the application

  - Compile and execute HospitalManagementSystem.java

  - Use the menu in the console to interact with the system

---

## 📁 Project Structure
 
 ```bash
HospitalManagementSystem/
├── src/
│   └── HospitalManagementSystem.java
│   └── Doctor.java
│   └── Patient.java
├── lib/
│   └── mysql-connector-java-x.x.xx.jar
├── README.md
├── LICENSE
└── Documents


 ```

- 🔁 Replace x.x.xx with your MySQL Connector version.
---
## 🧩 Future Enhancements

- GUI using JavaFX or Swing
- Role-based login system
- Doctor availability & scheduling
- Prescription and billing modules
- Email/SMS notification system
- REST API + frontend integration

---

## 👨‍💻 Author

**Name**: M Mukunda Sai  
**Email**: mothkumukundasai@gmail.com  
**GitHub**: [MukundaSai](https://github.com/mukunda6)

---

## 📝 License

This project is open source and available under the [MIT License](LICENSE).
      

     
