package io.apkblog.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.apkblog.moviecatalogservice.model.CatalogItem;
import io.apkblog.moviecatalogservice.model.Movie;
import io.apkblog.moviecatalogservice.model.Rating;
import io.apkblog.moviecatalogservice.model.UserRating;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathParam("userId") String userId){
        /* 
            // creating rest template
                RestTemplate restTemplate = new RestTemplate(); // now it is coming from autowired.

            // rest template take two agrument 1: url of the rating service and second class of whose object new to create.
                  restTemplate.getForObject("http://localhost:8081" + Rating.getMovieId, Movie.class );
        */

        /* 
            //get all rated movies id
             List<Rating> ratings = Arrays.asList(
                new Rating("1234", 5),
                 new Rating("5678", 3));
        */
        //inplace of hard code details we are taking from api now for rating
        //ratings-data-service is the service name which we are passing in place of url
        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);

       return ratings.getUserRating().stream().map(rating ->{
        //this line making call to api and unmarsel to the onject
        //for each move id , call movie info service and get details
       Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
        //put them all together
       return new CatalogItem(movie.getName(), "Test", rating.getRating());
    })
            .collect(Collectors.toList());
    }
     /*
            // mow in place of restTemplate we are going to use WebClient
            //this all thing will give intance of move
                Movie movie= webClientBuilder.build() //webClientBuilder.build() using builder pattern and give it to client
                .get()//to get data
                .uri("http://localhost:8082/movies/" + rating.getMovieId())// url need to access
                .retrieve()//go do the fetch
                .bodyToMono(Movie.class) //what ever body you get back convert it into intance of this movie class // mono means it will take time to create intence but definatly it will create. this is similar to asynconous.
                .block(); // we are blocking the mono until it create intence of the movie
        */
}
