package com.davidrus.katana.services;

import com.davidrus.katana.dao.CompanyDao;
import com.davidrus.katana.dto.Company;
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
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private Mapper mapper;
    @Resource
    private CompanyDao companyDao;

    @Override
    public boolean createCompany(Company company) {
        com.davidrus.katana.domain.Company companyDomain = mapper.map(company, com.davidrus.katana.domain.Company.class);
        return companyDao.createCompany(companyDomain);
    }

    @Override
    public Company getCompany(Long id) {
       com.davidrus.katana.domain.Company company = companyDao.getCompanyById(id);
        Company companyDto = mapper.map(company, Company.class);
        return companyDto;
    }

    @Override
    public Company getCompanyByName(String name) {
        com.davidrus.katana.domain.Company company = companyDao.getCompanyByName(name);
        Company companyDto = mapper.map(company, Company.class);
        return companyDto;
    }

    @Override
    public boolean updateCompany(Company company) {
        com.davidrus.katana.domain.Company companyDomain = mapper.map(company, com.davidrus.katana.domain.Company.class);
        return companyDao.updateCompany(companyDomain);
    }

    @Override
    public boolean deleteCompany(Long id) {
        com.davidrus.katana.domain.Company company = companyDao.getCompanyById(id);
        return companyDao.deleteCompany(id);
    }
}
