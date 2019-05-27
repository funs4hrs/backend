package com.funs4hrs.persistence.repositories;

import com.funs4hrs.domain.models.Project;
import com.funs4hrs.domain.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProjectRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "projects")

public interface IProjectRepository extends PagingAndSortingRepository<Project,Long> {
/*    @Query("SELECT p FROM Project p JOIN user_to_project u ON u.user_id = :user")
    public List<Project> findByUser(@Param("user") User user);*/
}
