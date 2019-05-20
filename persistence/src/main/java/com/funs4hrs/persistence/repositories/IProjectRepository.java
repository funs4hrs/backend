package com.funs4hrs.persistence.repositories;

import com.funs4hrs.domain.models.Project;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("ProjectRepository")
public interface IProjectRepository extends PagingAndSortingRepository<Project,Long> {
}
