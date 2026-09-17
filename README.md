# Smart Complaint Management System Using Java Collections and OOP

## 📌 Project Overview

The **Smart Complaint Management System** is a Java-based console application designed to help users register, manage, search, and track complaints in an organized way.

The project uses **Object-Oriented Programming concepts**, the **Java Collections Framework**, and **file handling** to store and manage user and complaint information.

This system provides separate options for users and administrators. Users can register complaints and view their complaint details, while administrators can manage complaints and monitor the complaint system.

---

## 🎯 Objectives

The main objectives of this project are:

* To develop a simple and user-friendly complaint management system.
* To allow users to register complaints easily.
* To generate unique complaint IDs automatically.
* To provide complaint searching and tracking facilities.
* To manage complaint priorities and statuses.
* To implement Java OOP concepts in a real-world application.
* To use Java Collections for storing and managing records.
* To store user and complaint data using file handling.
* To provide separate user and admin functionalities.

---

## ✨ Features

### 👤 User Features

* New user registration
* User login
* User dashboard
* Register a new complaint
* Automatic complaint ID generation
* Enter complaint title and description
* Select complaint category
* Select complaint priority
* View personal complaints
* View all complaints
* Search complaint by ID
* View latest complaint
* Logout option

### 🛠️ Admin Features

* Admin login
* View registered users
* View all complaints
* Search complaints
* Manage complaint status
* Manage complaint priorities
* View pending complaints
* View complaints according to departments or categories
* Manage complaint-related records
* Logout option

---

## 🧑‍💻 Technologies Used

* **Programming Language:** Java
* **Concepts:** Object-Oriented Programming
* **Data Structure:** Java Collections Framework
* **Storage:** File Handling
* **IDE:** Visual Studio Code
* **Version Control:** Git
* **Repository Hosting:** GitHub
* **Operating System:** Windows

---

## 🧠 Java Concepts Implemented

This project demonstrates the following Java concepts:

### 1. Object-Oriented Programming

* Classes and objects
* Encapsulation
* Constructors
* Methods
* Inheritance, wherever applicable
* Data abstraction
* Access modifiers

### 2. Java Collections

The project uses collections to manage users, complaints, and other records efficiently.

Examples include:

* `ArrayList`
* `HashMap`
* Other collection-based structures used by the managers

### 3. File Handling

File handling is used to save and load information so that data can remain available after closing the application.

The project stores information such as:

* User details
* Complaint details
* Complaint priority
* Complaint status

### 4. Exception Handling

Exception handling is used to manage invalid inputs and prevent the application from terminating unexpectedly.

### 5. Enums

Enums are used for fixed values such as:

* Complaint priority
* Complaint status

---

## 📂 Project Structure

```text
Smart-Complaint-Management-System
│
├── src
│   └── complaintmanagement
│       │
│       ├── Main.java
│       ├── UserMenu.java
│       ├── AdminMenu.java
│       │
│       ├── model
│       │   ├── Admin.java
│       │   ├── Complaint.java
│       │   ├── ComplaintStatus.java
│       │   ├── Priority.java
│       │   └── User.java
│       │
│       └── service
│           ├── AdminManager.java
│           ├── CategoryManager.java
│           ├── ComplaintManager.java
│           ├── DepartmentManager.java
│           ├── FrequentComplainerManager.java
│           ├── PendingComplaintManager.java
│           ├── PriorityManager.java
│           └── UserManager.java
│
├── .gitignore
├── README.md
└── data
```

---

## 🔐 Admin Login Details

```text
Username: admin
Password: admin123
```

---

## ▶️ How to Run the Project

### Step 1: Open the Project

Open the project folder in Visual Studio Code.

### Step 2: Open PowerShell or Terminal

Move to the project directory:

```powershell
cd C:\Users\Avani\Desktop\Complaint-Management-System
```

### Step 3: Compile the Java Files

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })
```

### Step 4: Run the Application

```powershell
java -cp out complaintmanagement.Main
```

### Step 5: Use the Menu

Follow the options displayed in the console application.

---

## 📝 Sample Working Flow

```text
1. Start the application
2. Register or log in as a user
3. Open the User Dashboard
4. Select Register Complaint
5. Enter complaint details
6. Receive an automatically generated complaint ID
7. View or search the complaint
8. Log out
9. Log in as admin
10. Manage and monitor complaints
```

---

## 📊 Complaint Information

Each complaint may contain the following information:

* Complaint ID
* Complaint title
* Complaint description
* Complaint category
* Username
* Complaint priority
* Complaint status

Example:

```text
Complaint ID: 101
Title: WiFi not working
Category: Network
Priority: HIGH
Status: PENDING
```

---

## 🧪 Testing

The project includes test classes for checking important manager operations.

The testing files include:

```text
TestAdminManager.java
TestComplaintManager.java
TestUserManager.java
```

These files help verify that user, admin, and complaint-related operations work properly.

---

## 💾 Data Storage

The application uses file-based storage for maintaining records.

The data files may include:

```text
data/users.txt
data/complaints.txt
```

This allows the application to save information and load it again when the program is executed.

---

## 🚀 Future Scope

The project can be improved in the future by adding:

* A graphical user interface
* A web-based version
* Database connectivity using MySQL
* Email notifications
* Complaint progress tracking
* Admin analytics dashboard
* Complaint filtering and sorting
* Password encryption
* Role-based access control
* Export complaints to CSV or PDF
* Automatic email updates for complaint status

---

## ✅ Advantages

* Easy to use
* Simple console-based interface
* Automatic complaint ID generation
* Organized complaint management
* Separate user and admin modules
* Uses important Java programming concepts
* Supports data persistence through file handling
* Easy to extend and improve

---

## 👩‍💻 Developer

**Name:** Avani Khare
**Course:** Computer Science and Engineering – Artificial Intelligence and Machine Learning
**Project:** Smart Complaint Management System Using Java Collections and OOP

---

## 🔗 GitHub Repository

[Smart Complaint Management System](https://github.com/avani25bai11450-tech/Smart-Complaint-Management-System)

---

## 📸 Screenshots

## Main menu
  The main menu provides options for user registration, user login, admin login, and exiting the system.
  
  <img width="1554" height="1016" alt="image" src="https://github.com/user-attachments/assets/c384ddca-f2db-4b2e-a266-d9ed18cd6665" />

## User login & User dashboard
  This screenshot shows successful user login and the user dashboard, which provides options to register, view, search, and manage complaints.
  
<img width="1557" height="1015" alt="image" src="https://github.com/user-attachments/assets/56dce015-bb3f-4020-a93a-9f5be3c68ee3" />

## Complaint registration & Complaint ID generation
  This screenshot shows the process of registering a complaint by entering its title, description, category, and priority. The system automatically generates a      unique complaint ID for each registered complaint.
  
  <img width="1557" height="1004" alt="image" src="https://github.com/user-attachments/assets/a95994b6-ce9b-4d28-977e-54a66dc54823" />

## View complaints
  This screenshot shows the complaints registered by the user, including the complaint ID, title, category, priority, and current status.
  
<img width="1488" height="1017" alt="image" src="https://github.com/user-attachments/assets/c391c41e-8e93-4b81-a977-60eea33ffc2e" />

## Search complaint
  This screenshot shows how users can search for a complaint using its unique complaint ID and view the complaint details.
  
<img width="1477" height="997" alt="image" src="https://github.com/user-attachments/assets/1aa86610-a92f-41f4-98c6-7754e25a0e55" />

## Admin dashboard
  This screenshot shows the administrator dashboard, which provides options to manage users, view complaints, update complaint status, and perform administrative    tasks.
  
<img width="1482" height="990" alt="image" src="https://github.com/user-attachments/assets/f8d0ddc8-3afb-4aef-91ad-519cd84598f5" />


---

## 📄 Conclusion

The **Smart Complaint Management System** provides a simple and efficient way to manage complaints using Java. It demonstrates the practical use of Object-Oriented Programming, Java Collections, enums, exception handling, and file handling.

The project helps users register and track complaints while allowing administrators to manage complaint records in an organized manner. It can also be extended into a database-based or web-based application in the future.
