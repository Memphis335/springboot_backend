# Getting Started

This is a simple backend written with [Spring Boot](https://spring.io/projects/spring-boot) to obtain question from the [Open Trivia Database](https://opentdb.com/). 

# The api exposes two endpoints:

1.  /questions
2.  /checkanswers

# In order to run the application:

1. Open a terminal window.
2. Create a local directory to hold your Spring Boot application by typing mkdir SpringBoot
3. Change to that directory by typing cd SpringBoot.
4. Clone the springboot_backend project into the directory you created by typing git clone https://github.com/Memphis335/springboot_backend
5. Change to the directory of the completed project by typing cd springboot_backend/backend
6. Build the JAR file using Maven by typing ./mvnw clean package
7. When the web app has been created, start it by typing ./mvnw spring-boot:run

Test it locally by either visiting http://localhost:8080 or typing curl http://localhost:8080 from another terminal window.
