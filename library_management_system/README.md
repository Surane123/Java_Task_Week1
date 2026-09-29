# Library Management System

A Java Servlet and JDBC learning project for adding and searching for books. The project includes book and author beans, DAO and service layers, servlets, and HTML pages.

## Project contents

- Java sources: [`src/main/java`](src/main/java/)
- HTML pages and web configuration: [`src/main/webapp`](src/main/webapp/)
- Database table definitions and sample authors: [`SQLQUERIES.txt`](SQLQUERIES.txt)

## Requirements and configuration

- Eclipse with the Web Tools Platform and a Java JDK supported by your Eclipse installation.
- Apache Tomcat 9 for the current `javax.servlet` imports. The checked-in Eclipse classpath names JavaSE-21 and Tomcat 9.0.100; update those runtime entries to match your installed JDK and Tomcat.
- Oracle Database XE, unless you update [`DBUtil.java`](src/main/java/com/kce/book/util/DBUtil.java) to use another JDBC database and driver. Its current connection URL is `jdbc:oracle:thin:@localhost:1521:XE`; update its username and password to match your local database.

## Setup and run

1. Configure Oracle XE and run `SQLQUERIES.txt` to create the author and book tables.
2. Set the database connection details in `DBUtil.java`.
3. Import this folder into Eclipse as an existing Eclipse project, configure its Java and Tomcat runtimes, and run it on the Tomcat server.
4. Open `http://localhost:8080/LibraryManagement/AddBook.html`.

The repository README describes Tomcat 10/Jakarta, but the checked-in Java servlet sources currently use `javax.servlet`, so configure Tomcat 9 unless you migrate those imports and the project runtime together.
