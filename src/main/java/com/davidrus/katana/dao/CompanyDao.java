package com.davidrus.katana.dao;

import com.davidrus.katana.domain.Company;
import com.davidrus.katana.domain.Company;
import org.springframework.stereotype.Repository;

/**
 * Created by david on 24-May-17.
 */
@Repository
public interface CompanyDao {

    /**
     * Creates a new company in the database
     *
     * @param company the company's details
     */
    boolean createCompany(Company company);

    /**
     * Fetches the company from the database
     *
     * @param id of the company
     * @return the company
     */
    Company getCompanyById(Long id);

    /**
     * Fetches the company from the database
     *
     * @param companyName of the company
     * @return the company
     */
    Company getCompanyByName(String companyName);

    /**
     * Updates the company details
     *
     * @param company the company's data
     */
    boolean updateCompany(Company company);

    /**
     * Deletes the company
     *
     * @param id of the company
     */
    boolean deleteCompany(Long id);

}
