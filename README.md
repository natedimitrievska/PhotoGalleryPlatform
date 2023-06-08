PhotoGalleryPlatform API Documentation
This README file provides a technical overview of the APIs implemented in the PhotoGalleryPlatform application. The application is built using the Spring Boot framework and follows RESTful principles for the API design.

Table of Contents
Application Configuration
API Endpoints
PhotoController
GET /api/photos/allPhotos
GET /api/photos/{id}
POST /api/photos/add
PUT /api/photos/update/{id}
DELETE /api/photos/delete/{id}
Data Model
Photo
Dependencies
Application Configuration
The application's configuration is managed through the following property files:

application-prod.properties
spring.main.allow-bean-definition-overriding=true: Allows overriding bean definitions in the Spring application context.
spring.datasource.url: Specifies the URL of the PostgreSQL database.
spring.datasource.username: Specifies the username for the database connection.
spring.datasource.password: Specifies the password for the database connection.
spring.datasource.hikari.connectionTimeout: Sets the maximum time to wait for a connection from the connection pool.
spring.datasource.hikari.maximumPoolSize: Sets the maximum number of connections in the connection pool.
spring.jpa.properties.hibernate.dialect: Specifies the Hibernate dialect for PostgreSQL.
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation: Sets the Hibernate property for handling LOB (Large Object) data.
spring.jpa.hibernate.ddl-auto: Determines the Hibernate DDL (Data Definition Language) behavior.
spring.jpa.show-sql: Enables SQL logging for Hibernate.
application.properties
server.port: Specifies the port on which the server listens.
spring.profiles.active: Sets the active profile for the application.
server.servlet.session.timeout: Sets the session timeout duration.
server.servlet.session.cookie.name: Sets the name of the session cookie.
spring.mvc.hiddenmethod.filter.enabled: Enables support for hidden HTTP method overriding.
API Endpoints
The following sections describe the APIs provided by the application. All API endpoints are relative to the base URL: http://localhost:8896.

PhotoController
GET /api/photos/allPhotos
Returns a list of all photos.
Method: GET
Path: /api/photos/allPhotos
Response:
Status: 200 OK
Body: JSON array containing the list of photos.
Example:

GET /api/photos/allPhotos HTTP/1.1
Host: localhost:8896


GET /api/photos/{id}
Retrieves a specific photo by its ID.
Method: GET
Path: /api/photos/{id}
Parameters:
id (path variable): The ID of the photo.
Response:
Status: 200 OK
Body: JSON object representing the photo.
Example:

GET /api/photos/1 HTTP/1.1
Host: localhost:8896


POST /api/photos/add
Creates a new photo.
Method: POST
Path: /api/photos/add
Request body: JSON object containing the photo data.
photoTitle (string): The title of the photo.
photoDescription (string): The description of the photo.
photoUrl (string): The URL of the photo.
Response:
Status: 201 Created
Body: JSON object representing the created photo.
Example:

POST /api/photos/add HTTP/1.1
Host: localhost:8896
Content-Type: application/json

{
  "photoTitle": "Beautiful Sunset",
  "photoDescription": "A stunning sunset over the beach.",
  "photoUrl": "https://example.com/sunset.jpg"
}


PUT /api/photos/update/{id}
Updates an existing photo.
Method: PUT
Path: /api/photos/update/{id}
Parameters:
id (path variable): The ID of the photo.
Request body: JSON object containing the updated photo data.
photoTitle (string): The updated title of the photo.
photoDescription (string): The updated description of the photo.
photoUrl (string): The updated URL of the photo.
Response:
Status: 200 OK
Body: JSON object representing the updated photo.
Example:

PUT /api/photos/update/1 HTTP/1.1
Host: localhost:8896
Content-Type: application/json

{
  "photoTitle": "Amazing Sunrise",
  "photoDescription": "A breathtaking sunrise over the mountains.",
  "photoUrl": "https://example.com/sunrise.jpg"
}


DELETE /api/photos/delete/{id}
Deletes a photo.
Method: DELETE
Path: /api/photos/delete/{id}
Parameters:
id (path variable): The ID of the photo to delete.
Response:
Status: 204 No Content
Example:

DELETE /api/photos/delete/1 HTTP/1.1
Host: localhost:8896


Data Model
Photo
Represents a photo entity in the application.
Properties:
id (integer): The ID of the photo.
photoTitle (string): The title of the photo.
photoDescription (string): The description of the photo.
photoUrl (string): The URL of the photo.
createdAt (date): The creation date of the photo.
updatedAt (date): The last update date of the photo.
Dependencies
The application has the following dependencies:

Spring Boot: 2.5.2
Spring Web: 2.5.2
Spring Data JPA: 2.5.2
PostgreSQL Driver: 42.2.23
Hibernate Core: 5.4.32.Final
Jackson Core: 2.12.3
Jackson Databind: 2.12.3
