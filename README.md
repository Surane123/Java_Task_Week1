# Java Week 1 Assignment

This repository brings together three Java tasks: a servlet based library management system, a menu driven banking application, and a Java Collections console challenge. Each project is in its own folder with source code and a project README.

## Tasks

### Task 1: Library Management System

A Java Servlet and JDBC web application for adding and searching for books. It includes book and author models, DAO and service layers, servlets, HTML pages, and Oracle SQL setup scripts.

- **Technologies:** Java Servlets (`javax.servlet`), JDBC, Oracle XE, HTML, Apache Tomcat 9.
- **Setup:** Configure Oracle XE and run [`library_management_system/SQLQUERIES.txt`](library_management_system/SQLQUERIES.txt). Set the database URL and credentials in `library_management_system/src/main/java/com/kce/book/util/DBUtil.java`, then import the folder into Eclipse, configure JDK and Tomcat 9 runtimes, and run on the server.
- **Open:** `http://localhost:8080/LibraryManagement/AddBook.html`
- **Details and requirements:** [Task 1 README](library_management_system/README.md)

The current source uses `javax.servlet`, so it needs Tomcat 9 unless the servlet imports and runtime are migrated together. The checked in Eclipse configuration refers to Java 21 and Tomcat 9.0.100; adjust these to the versions installed on your computer.

### Task 2: Banking Application

A menu driven Java console application for basic account operations. It supports deposits, withdrawals, balance inquiries, input validation, and insufficient funds handling.

**Run with JDK 17 or newer** from the repository root:

```powershell
cd banking_application
javac -d out src\banking\*.java
java -cp out banking.Main
```

No external libraries are required. See the [Task 2 README](banking_application/README.md).

### Task 3: Java Collections Challenge

An interactive console program demonstrating three collection types:

- `ArrayList` for adding, removing, updating, searching, and listing tasks.
- `HashMap` for storing and looking up student IDs and names.
- `Queue` for a first-in, first-out customer service line.

**Run with JDK 17 or newer** from the repository root:

```powershell
cd java_collections_challenge
javac -d out src\collections\*.java
java -cp out collections.Main
```

No external libraries are required. See the [Task 3 README](java_collections_challenge/README.md).

## Screenshots

### Task 2: Banking Application

- [Deposit and withdrawal](screenshots/banking_application/deposit-and-withdrawal.png)
- [Balance inquiry](screenshots/banking_application/balance-inquiry.png)
- [Exit message](screenshots/banking_application/exit-message.png)

### Task 3: Java Collections Challenge

[View all Task 3 screenshots](screenshots/java_collections_challenge/)

## Repository layout

```text
banking_application/             Task 2 source and README
java_collections_challenge/      Task 3 source and README
library_management_system/       Task 1 source and README
screenshots/                     Task 2 and Task 3 screenshots
main_README.md                   Short repository overview
```
