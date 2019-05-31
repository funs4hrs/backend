package com.funs4hrs.persistence.repositories;

import com.funs4hrs.domain.models.Attendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository("AttendanceRepository")
@RepositoryRestResource(collectionResourceRel = "results",path = "attendances")
public interface IAttendanceRepository extends PagingAndSortingRepository<Attendance,Long> {

    @Query("SELECT a FROM Attendance a WHERE a.user.id = :user AND a.project.id = :project AND a.end_time = null")
    Attendance readAllOpenByUserAndProject(@Param("user") Long user, @Param("project") Long project);


//    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
//    public User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
