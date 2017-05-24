package com.davidrus.katana.dao;

import com.davidrus.katana.domain.Review;
import org.springframework.stereotype.Repository;

/**
 * Created by david on 24-May-17.
 */
@Repository
public interface ReviewDao {
    /**
     * Creates a new review in the database
     *
     * @param review the review's details
     */
    boolean createReview(Review review);

    /**
     * Fetches the review from the database
     *
     * @param id of the review
     * @return the review
     */
    Review getReviewById(Long id);

    /**
     * Updates the review details
     *
     * @param review the review's data
     */
    boolean updateReview(Review review);

    /**
     * Deletes the review
     *
     * @param id of the review
     */
    boolean deleteReview(Long id);
}
