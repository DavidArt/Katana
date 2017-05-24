package com.davidrus.katana.rest;

import com.davidrus.katana.dto.Review;
import com.davidrus.katana.dto.User;
import com.davidrus.katana.services.ReviewService;
import com.davidrus.katana.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by david on 12-May-17.
 */

@Slf4j
@Path(RestConstants.REVIEW_PATH)
@Controller
public class ReviewResource {

    @Resource
    ReviewService reviewService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReview(Review review) {
        if (reviewService.createReview(review)) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.accepted().build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReviewName(@PathParam("id") Long id) {
        Review review = reviewService.getReview(id);
        if (review != null) {
            return Response.ok().entity(review).build();
        }
        return Response.accepted().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateReview(Review review) {
        if(reviewService.updateReview(review)) {
            return Response.noContent().build();
        }
        return Response.accepted().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        if (reviewService.deleteReview(id)) {
            return Response.noContent().build();
        }
        return Response.accepted().build();
    }
}
