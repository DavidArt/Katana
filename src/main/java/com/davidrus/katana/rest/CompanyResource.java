package com.davidrus.katana.rest;

import com.davidrus.katana.dto.Company;
import com.davidrus.katana.dto.User;
import com.davidrus.katana.services.CompanyService;
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
@Path(RestConstants.COMPANY_PATH)
@Controller
public class CompanyResource {

    @Resource
    CompanyService companyService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCompany(Company company) {
        if (companyService.createCompany(company)) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.accepted().build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyName(@PathParam("id") Long id) {
        Company company = companyService.getCompany(id);
        if (company != null) {
            return Response.ok().entity(company).build();
        }
        return Response.accepted().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyName(@QueryParam("name") String name) {
        Company company = companyService.getCompanyByName(name);
        if (company != null) {
            return Response.ok().entity(company).build();
        }
        return Response.accepted().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCompany(Company company) {
        if(companyService.updateCompany(company)) {
            return Response.noContent().build();
        }
        return Response.accepted().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCompany(@PathParam("id") Long id) {
        if (companyService.deleteCompany(id)) {
            return Response.noContent().build();
        }
        return Response.accepted().build();
    }
}
