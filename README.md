# Todo-List-Api
 A simple todo-list implementation for RESTful apis. Project is built with Java, Springboot 3, leveraging Spring Security 6 and Oauth2.0 to secure the application.

# Instructions for running the app
1. Please ensure that Docker is installed and initialized
2. From Intellij, build the project for local use.

# Instructions for testing the app
1. Ensure the application is running
2. Navigate to [`http://localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)
3. Perform the tests for `GET`, `POST`, `DELETE`, `PUT` within the tabs.

# Instructions for building the app
1. Please pull the mongo image to docker, this can be done by running: `docker pull mongo: latest`
2. Two ways to build the application, either within Intellij with Docker extension or Terminal docker calls.
3. Intellij with Docker Extension:
    - Click the double arrow within the **docker-compose** file.
4. Terminal docker calls:
    - Navigate to directory where docker compose file is located.
    - Execute the command -> `docker compose up`

# POST Requests Commands:
* `GET` 	-> http://localhost:8080/api/v1/todo/List
* `POST`	-> http://localhost:8080/api/v1/todo/Add
* `PUT`	-> http://localhost:8080/api/v1/todo/Mark-complete/{id}
* `DELETE`-> http://localhost:8080/api/v1/todo/Delete/{id}

# Download Docker Image
Link: [`https://hub.docker.com/repository/docker/synxcrads/todo-list-api/general`](https://hub.docker.com/repository/docker/synxcrads/todo-list-api/general)
