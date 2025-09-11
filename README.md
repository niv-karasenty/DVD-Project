# BlockKBusterr - DVD Rental Management System
A comprehensive DVD rental management system built with Jakarta EE, featuring user management, movie catalog, rental tracking, and review system with automatic database initialization.

## 🎯 Overview

BlockKBusterr is a modern DVD rental management system designed for rental stores and customers. Built using Jakarta EE 10 with JSF for the frontend, it provides a complete solution for managing movie inventory, user accounts, rentals, and reviews.

## 💻 System Requirements

### Prerequisites
- **Java Development Kit (JDK) 11** or higher
- **Apache Maven 3.6+** for build management
- **MySQL 8.0+** database server
- **Git** for version control

### Recommended Environment
- **Operating System**: Windows 10/11, macOS 10.15+, or Linux
- **RAM**: 4GB minimum, 8GB recommended
- **Storage**: 2GB free space for application and database
- **Network**: Internet connection for Maven dependencies

## 🔧 Installation & Setup

### Step 1: Environment Setup

1. **Install Java 11+**:
   ```bash
   # Verify Java installation
   java -version
   javac -version
   ```

2. **Install Maven**:
   ```bash
   # Verify Maven installation
   mvn -version
   ```

3. **Install MySQL**:
   - Download and install MySQL 8.0+
   - Start MySQL service
   - Create database user if needed

### Step 2: Project Setup

1. **Clone and navigate**:
   ```bash
   git clone <repository-url>
   cd DVD-Project
   ```

2. **Verify project structure**:
   ```
   DVD-Project/
   ├── src/main/
   │   ├── java/com/mycompany/blockkbusterr/
   │   ├── resources/
   │   └── webapp/
   ├── pom.xml
   ├── pom-tomee.xml
   ├── run-with-tomee.bat
   └── README.md
   ```

### Step 3: Database Configuration

1. **Create database**:
   ```sql
   mysql -u root -p
   CREATE DATABASE blockkbusterr CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   GRANT ALL PRIVILEGES ON blockkbusterr.* TO 'root'@'localhost';
   FLUSH PRIVILEGES;
   ```

2. **Configure connection**:
   Update database credentials in [`src/main/webapp/WEB-INF/tomee.xml`](src/main/webapp/WEB-INF/tomee.xml):
   ```xml
   <Resource id="blockkbusterrDS" type="DataSource">
       JdbcUrl jdbc:mysql://localhost:3306/blockkbusterr?useSSL=false&amp;allowPublicKeyRetrieval=true&amp;serverTimezone=UTC
       UserName YOUR_USERNAME
       Password YOUR_PASSWORD
   </Resource>
   ```

### Step 4: Build and Run

1. **Build the project**:
   ```bash
   mvn clean compile
   ```

2. **Run with embedded TomEE**:
   ```bash
   mvn -f pom-tomee.xml clean package tomee:run
   ```

3. **Access application**:
   - Open browser to: http://localhost:8080/blockkbusterr/
   - Login with: `admin` / `admin123`

## 🗄️ Database Configuration

### Automatic Initialization (Default)

The application includes an automatic database initialization system that:

- **Creates default admin user**: `admin` / `admin123`
- **Populates sample movies**: 15 popular movies across various genres
- **Sets up proper relationships**: Users, movies, rentals, reviews
- **Runs only once**: Smart detection prevents duplicate data