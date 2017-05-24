package com.davidrus.katana.services;

import com.davidrus.katana.dto.Company;
import org.springframework.stereotype.Service;

/**
 * Created by david on 17-May-17.
 */
@Service
public interface CompanyService {
    boolean createCompany(Company company);

    Company getCompany(Long id);

    Company getCompanyByName(String name);

    boolean updateCompany(Company company);

    boolean deleteCompany(Long id);

}
