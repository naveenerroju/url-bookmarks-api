# URL Bookmarks API

## Overview
The URL Bookmarks API is a Spring Boot application designed to manage and store URLs as bookmarks. The application uses MongoDB as the database to persist the bookmark data.

## Features
- Retrieve the latest 100 bookmarks.
- Retrieve a bookmark by its ID.
- Add a new bookmark.
- Delete all bookmarks.

## Technologies Used
- Java 17
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Gradle

## Getting Started

### Prerequisites
- Java 17
- Gradle
- MongoDB

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/url-bookmarks-api.git
   cd url-bookmarks-api
2. **Configure MongoDB**
Make sure MongoDB is running on your local machine or configure the application to connect to a remote MongoDB instance. The default configuration assumes MongoDB is running on localhost with the default port 8081.
3. **Build the application**
    ```bash
   ./gradlew build
4. **Run the application**
    ```bash
   ./gradlew bootRun

## API Endpoints
Test the endpoints using the postman collection i added in main>resources.
### Retrieve the latest 100 bookmarks

```http
GET /bookmarks/
```
### Retrieve the bookmarks by its ID

```http
GET /bookmarks/{id}
```
### Adds a new bookmarks

```http
POST /bookmarks/
```
### Adds a new bookmarks

```http
DELETE /bookmarks/
```
