package com.davidrus.katana.dao;

import com.davidrus.katana.domain.Company;
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
public class CompanyDaoImpl implements CompanyDao {

    @PersistenceContext
    public EntityManager em;

    /**
     * Creates a new company in the database
     *
     * @param company the company's details
     */
    @Override
    @Transactional
    public boolean createCompany(Company company) {
        em.persist(company);

        return true;
    }

    /**
     * Fetches the company from the database
     *
     * @param id of the company
     * @return the company
     */
    @Override
    public Company getCompanyById(Long id) {
        TypedQuery<Company> query = em.createNamedQuery(Company.GET_COMPANY_BY_ID, Company.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    /**
     * Fetches the company from the database
     *
     * @param companyName of the company
     * @return the company
     */
    @Override
    public Company getCompanyByName(String companyName) {
        TypedQuery<Company> query = em.createNamedQuery(Company.GET_COMPANY_BY_NAME, Company.class);
        query.setParameter("name", companyName);

        return query.getSingleResult();
    }

    /**
     * Updates the company details
     *
     * @param company the company's data
     */
    @Override
    public boolean updateCompany(Company company) {
        em.merge(company);

        return true;
    }

    /**
     * Deletes the company
     *
     * @param id of the company
     */
    @Override
    public boolean deleteCompany(Long id) {
        TypedQuery<Company> query = em.createNamedQuery(Company.GET_COMPANY_BY_ID, Company.class);
        query.setParameter("id", id);
        Company company = query.getSingleResult();
        em.remove(company);

        return true;
    }
}
