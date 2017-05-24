package com.davidrus.katana.services;

import com.davidrus.katana.dao.ReviewDao;
import com.davidrus.katana.dto.Review;
import com.davidrus.katana.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by david on 17-May-17.
 */
@Service
@Slf4j
public class ReviewServiceImpl implements ReviewService {
    @Resource
    private Mapper mapper;
    @Resource
    private ReviewDao reviewDao;

    @Override
    public boolean createReview(Review review) {
        com.davidrus.katana.domain.Review reviewDomain = mapper.map(review, com.davidrus.katana.domain.Review.class);
        return reviewDao.createReview(reviewDomain);
    }

    @Override
    public Review getReview(Long id) {
        com.davidrus.katana.domain.Review review = reviewDao.getReviewById(id);
        Review reviewDto = mapper.map(review, Review.class);
        return reviewDto;
    }

    @Override
    public boolean updateReview(Review review) {
        com.davidrus.katana.domain.Review userDomain = mapper.map(review, com.davidrus.katana.domain.Review.class);
        return reviewDao.updateReview(userDomain);
    }

    @Override
    public boolean deleteReview(Long id) {
        com.davidrus.katana.domain.Review review = reviewDao.getReviewById(id);
        return reviewDao.deleteReview(id);
    }
}
