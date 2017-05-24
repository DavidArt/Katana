package com.davidrus.katana.services;

import com.davidrus.katana.dto.Review;
import com.davidrus.katana.dto.User;
import org.springframework.stereotype.Service;

/**
 * Created by david on 17-May-17.
 */
@Service
public interface ReviewService {

    boolean createReview(Review review);

    Review getReview(Long id);

    boolean updateReview(Review review);

    boolean deleteReview(Long id);

}
