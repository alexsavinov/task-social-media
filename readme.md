# Social Media Application

This is a simple social media application built using Spring Boot 3.3, Hibernate, and PostgreSQL. The application allows users to create and view posts, follow other users, and like posts. Each post has a title, body, and author. Hibernate is used to persist the post and user data in the database.

## Features

- User registration and authentication
- Create and view posts
- Follow other users
- Like posts

## Technologies Used

- Spring Boot 3.3
- Hibernate
- PostgreSQL
- H2 (for testing)
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- PostgreSQL 12 or higher

### Installation

1. **Clone the repository:**

    ```sh
    git clone https://github.com/yourusername/social-media-app.git
    cd social-media-app
    ```

2. **Configure the database:**

   Update the `src/main/resources/application.properties` file with your PostgreSQL database credentials:

    ```ini
    spring.datasource.url=jdbc:postgresql://localhost:5432/social_media?createDatabaseIfNotExist=true
    spring.datasource.username=your_postgres_username
    spring.datasource.password=your_postgres_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. **Build the project:**

    ```sh
    mvn clean install
    ```

4. **Run the application:**

    ```sh
    mvn spring-boot:run 
    ```

### Running Tests

The application uses H2 in-memory database for testing. To run the tests, use the following command:

```sh
mvn test
```

## API Endpoints

### User Endpoints

- **Create User:**
    - `POST /users`
    - Request Body: `{ "username": "testuser", "password": "password" }`

- **Get All Users:**
    - `GET /users`

- **Get User By ID:**
    - `GET /users/{id}`

- **Follow User:**
    - `POST /users/{userId}/follow/{followerId}`

### Post Endpoints

- **Create Post:**
    - `POST /posts/{userId}`
    - Request Body: `{ "title": "Test Title", "body": "Test Body" }`

- **Get All Posts:**
    - `GET /posts`

- **Get Post By ID:**
    - `GET /posts/{id}`

### Like Endpoints

- **Like Post:**
    - `POST /likes/{userId}/{postId}`

- **Get All Likes:**
    - `GET /likes`

# Feedback
Q: Was it easy to complete the task using AI?\
A: Yes, it was easy to complete the task using AI.

Q: How long did task take you to complete? (Please be honest, we need it to gather anonymized statistics)\
A: It took me about 2 hours to complete the task.

Q: Was the code ready to run after generation? What did you have to change to make it usable?\
A: The code was ready to run after generation. I had to update the database configuration in the `application.properties` file to make it usable.

Q: Which challenges did you face during completion of the task?\
A: I did not face any challenges during the completion of the task.

Q: Which specific prompts you learned as a good practice to complete the task?\
A: I learned that it is a good practice to provide clear instructions on how to run the application and tests.
