package com.funs4hrs.persistence.repositories;

import com.funs4hrs.domain.models.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("CompanyRepository")
public interface ICompanyRepository extends PagingAndSortingRepository<Company, Long> {
}
