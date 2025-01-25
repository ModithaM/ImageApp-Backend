### ImageApp-Backend Documentation

#### Overview

This repository is a project designed to practice Java Spring Boot. It provides a RESTful API for managing movie-related images using MongoDB as the database.

#### Main Functionalities and Features

- **RESTful API**: The project includes an API to manage movie-related images, enabling CRUD operations.
- **Java Spring Boot**: Leveraging the Spring Boot framework for fast and secure web application development.
- **Database Integration**: Uses MongoDB to store and retrieve image data.
- **API Endpoints**:
  - `GET /api/v1/movies`: Get all images.
  - `GET /api/v1/movies/{imdbId}`: Get one image.
  - `POST api/v1/reviews`: Add a review.
  - `DELETE api/v1/reviews/{id}`: Delete a review.

#### Project Structure

- **src**: Contains the source code for the project.
  - **main**: The main application code.
    - **java**: Java source files.
    - **resources**: Configuration files and static resources.
- **test**: Contains test cases for the application.

#### Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/ModithaM/ImageApp-Backend.git
   ```
2. Navigate to the project directory:
   ```bash
   cd ImageApp-Backend
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

#### Usage

- **Database Configuration**: Update the `application.properties` file with your database configuration.

#### Contributing

- Fork the repository.
- Create a new branch for your feature or bugfix.
- Submit a pull request with a detailed description of your changes.
