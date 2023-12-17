package dev.sotkar.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // This class is the business logic of API
public class MovieService {
    @Autowired //Injects MovieRepository bean
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> movie(ObjectId id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> movieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
