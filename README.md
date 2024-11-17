# User Auth Management System

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Usage](#usage)
- [License](#license)

## Overview
This project is a Spring Boot web application designed for managing user authentication, registration, and profile management. It allows users to create accounts, log in, and update their profiles. The application utilizes Spring Security for authentication and authorization, along with Thymeleaf for view rendering.

### Features
- **User Registration**: Users can create a new account with a username, email, and password.
- **User Login**: Secure login functionality for users using their credentials.
- **Profile Management**: Users can view and update their profile information.
- **OAuth2 Login**: Google login integration for OAuth2-based authentication.
- **Session Management**: Manages user sessions and enforces access control.

## Usage
1. **Setup and Deployment**:
    - Clone the repository to your local machine.
    - Build the application using Maven.
    - Configure the database settings in the `application.yaml` file.
    - Start the application.

2. **Access the Application**:
    - Navigate to `http://localhost:8080` in your web browser.
    - Register a new account or log in with existing credentials.

3. **Interacting with the Application**:
    - **Registration**: Visit `/registration` to create a new account.
    - **Login**: Go to `/login` to log in with your credentials.
    - **Profile**: After logging in, access your profile at `/profile` to view and edit your information.
    - **Logout**: Log out by visiting `/logout`.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.