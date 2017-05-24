package com.davidrus.katana.dao;

import com.davidrus.katana.domain.Review;
import com.davidrus.katana.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * Created by david on 24-May-17.
 */
@Repository
@Slf4j
public class ReviewDaoImpl implements ReviewDao {
    @PersistenceContext
    public EntityManager em;

    /**
     * Creates a new review in the database
     *
     * @param review the review's details
     */
    @Override
    @Transactional
    public boolean createReview(Review review) {
        em.persist(review);

        return true;
    }

    /**
     * Fetches the review from the database
     *
     * @param id of the review
     * @return the review
     */
    @Override
    public Review getReviewById(Long id) {
        TypedQuery<Review> query = em.createNamedQuery(Review.GET_REVIEW_BY_ID, Review.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    /**
     * Updates the review details
     *
     * @param review the review's data
     */
    @Override
    public boolean updateReview(Review review) {
        em.merge(review);

        return true;
    }

    /**
     * Deletes the review
     *
     * @param id of the review
     */
    @Override
    public boolean deleteReview(Long id) {
        TypedQuery<Review> query = em.createNamedQuery(Review.GET_REVIEW_BY_ID, Review.class);
        query.setParameter("id", id);
        Review review = query.getSingleResult();
        em.remove(review);

        return true;
    }
}
