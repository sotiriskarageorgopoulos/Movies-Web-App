package dev.sotkar.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired //We use a template to do dynamic and complex queries in database
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class) //collection
                .matching(Criteria.where("imdbId").is(imdbId)) //update condition
                .apply(new Update().push("reviewIds").value(review)) //the review pushed to reviewIds
                .first();

        return review;
    }
}
