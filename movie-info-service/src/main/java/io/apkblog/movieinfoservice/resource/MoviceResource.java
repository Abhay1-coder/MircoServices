package io.apkblog.movieinfoservice.resource;

import java.util.Collections;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.apkblog.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MoviceResource {
    
    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){

        return new Movie(movieId, "Test name");
        
    }
}
