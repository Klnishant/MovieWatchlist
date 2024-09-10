
# Movie Watchlist Web Application

This is a simple Movie Watchlist web application built using **Spring Boot**, **Thymeleaf**, and an **H2 Database**. The application allows users to add movies to their watchlist with details such as title, rating, priority, and comments. It also fetches movie ratings from the **OMDb API** and stores these details in the database for display.

## Features
- **Add Movie:** Add a movie to the watchlist with a title, rating, priority, and comments.
- **Fetch OMDb Rating:** Automatically fetch the movie's rating from the OMDb API based on the title and store it in the database.
- **View Watchlist:** Display the watchlist with movie details including the OMDb rating.
- **H2 Database:** Store all movie details in an H2 in-memory database for simplicity and quick setup.

## Technologies Used
- **Spring Boot:** Backend framework for creating a RESTful web service.
- **Thymeleaf:** Template engine for rendering HTML pages.
- **H2 Database:** In-memory database for storing movie data.
- **OMDb API:** Used for fetching movie ratings by title.
- **Maven:** Dependency management and build tool.
- **Java 22:** Programming language.

## Getting Started

### Prerequisites
To run this application, you need to have the following installed on your local machine:
- **Java 22**
- **Maven**
- **OMDb API Key** (You can get one by registering at the OMDb website: [http://www.omdbapi.com/apikey.aspx](http://www.omdbapi.com/apikey.aspx))

### Installation and Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Klnishant/MovieWatchlist.git
