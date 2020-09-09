package location;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Review {
    // this value is used to create reviewId value
    private static int count = 0;

    private int reviewId;
    private int userId;
    private int locationId;
    private LocalDate reviewedOn;
    private String description;
    private int rating;
 
    public Review(int userId, int locationId, LocalDate reviewedOn, String description, int rating) {
        this.reviewId = count++;
        this.userId = userId;
        this.locationId = locationId;
        this.reviewedOn = reviewedOn;
        this.description = description;
        this.rating = rating;
    }

    
    public List<Review> getReviewsByUser(List<Review> reviewsList, int id) {
        List<Review> reviewsByLocation = new ArrayList<>();
        for (Review review : reviewsList) {
            if (review.getUserId() == id) {
                reviewsByLocation.add(review);
            }
        }
        return reviewsByLocation;
    } 

    public List<Review> getReviewsByLocation(List<Review> reviewsList, int id) {
        List<Review> reviewsByLocation = new ArrayList<>();
        for (Review review : reviewsList) {
            if (review.getLocationId() == id) {
                reviewsByLocation.add(review);
            }
        }
        return reviewsByLocation;
    } 

    public List<Review> sortReviewsByRating(List<Review> reviewsList) {
        List<Review> reviewsByRating = new ArrayList<>(reviewsList);
        Comparator<Review> comparator = Comparator.comparing(Review::getRating);
        Collections.sort(reviewsByRating, comparator);

        return reviewsByRating;
    }

    public List<Review> sortReviewsByReviewDate(List<Review> reviewsList) {
        List<Review> reviewsByDate = new ArrayList<>(reviewsList);
        Comparator<Review> comparator = Comparator.comparing(Review::getReviewedOn);
        Collections.sort(reviewsByDate, comparator);

        return reviewsByDate;
    }
    
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Review.count = count;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getReviewedOn() {
        return reviewedOn;
    }

    public void setReviewedOn(LocalDate reviewedOn) {
        this.reviewedOn = reviewedOn;
    }



}