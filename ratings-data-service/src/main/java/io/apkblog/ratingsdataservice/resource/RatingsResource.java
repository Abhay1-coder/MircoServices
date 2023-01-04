package io.apkblog.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.apkblog.ratingsdataservice.model.Rating;
import io.apkblog.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId")String movieId){
        return new Rating(movieId, 9);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUseRating(@PathVariable("userId")String userId){
        List<Rating> ratings = Arrays.asList(
            new Rating("1234", 5),
            new Rating("5678", 3)
        );// since the return type will become list we are creating another userRating classes so that we can create onject of that and put the list into onject and return object
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
    
}
