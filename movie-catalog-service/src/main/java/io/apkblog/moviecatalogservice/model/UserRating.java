package io.apkblog.moviecatalogservice.model;

import java.util.List;

public class UserRating {
    private List<Rating> UserRating;

    public void setUserRating(List<Rating> userRating) {
        UserRating = userRating;
    }

    public List<Rating> getUserRating() {
        return UserRating;
    }
    
}
