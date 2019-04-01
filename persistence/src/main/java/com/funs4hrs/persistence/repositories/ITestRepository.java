package com.funs4hrs.persistence.repositories;

import com.funs4hrs.domain.models.Test;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("TestRepository")
public interface ITestRepository extends PagingAndSortingRepository<Test,Long> {
}
